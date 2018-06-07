package guiListener.MouseListener;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import gui.*;
import guiListener.MouseListener.NodeLabelMouseMethod.*;

public class NodeLabelMouseListener extends MouseAdapter{
	private static NodeLabel prevLabel;
	private AttributeEditor attrEditor;
	private NodeMouseMethod[] method;
	private Point pressedPoint;
	private boolean isBorder = false;
	private boolean isClicked = false;
	private boolean isDragged = false;
	
	public NodeLabelMouseListener(AttributeEditor attrEditor){
		this.attrEditor = attrEditor;
		method = new NodeMouseMethod[] {
				 new TextWrapper(Constants.TEXT_ATTRIBUTE, attrEditor),
				 new XWrapper(Constants.X_ATTRIBUTE, attrEditor),
				 new YWrapper(Constants.Y_ATTRIBUTE, attrEditor),
				 new WidthWrapper(Constants.WIDTH_ATTRIBUTE, attrEditor),
				 new HeightWrapper(Constants.HEIGHT_ATTRIBUTE, attrEditor),
				 new ColorWrapper(Constants.COLOR_ATTRIBUTE, attrEditor)};
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() != MouseEvent.BUTTON1)
			return ;
			
		isClicked = true;
		
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		if(prevLabel != null && prevLabel != nodeLabel)
		{
			{
				Color color = prevLabel.getForeground();
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				prevLabel.setForeground(new Color(255 - red, 255 - green, 255- blue));
			}
			
			{
				Color color = prevLabel.getBackground();
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				prevLabel.setBackground(new Color(255 - red, 255 - green, 255 - blue));
			}
		}
		if(prevLabel != nodeLabel) {
			{
				Color color = nodeLabel.getForeground();
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				nodeLabel.setForeground(new Color(255-red, 255 - green, 255 - blue));
			}
			
			{
				Color color = nodeLabel.getBackground();
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				nodeLabel.setBackground(new Color(255-red, 255-green, 255-blue));
			}
			prevLabel = nodeLabel;
		}
		if(method.length != attrEditor.getLength()) {
			System.out.println("NodeMethod와  attributeEditor의 갯수가 안 맞습니다. 코드 변경 필요");
			return;
		}
		attrEditor.setNodeLabel(nodeLabel);
		for(int i=0; i < method.length; ++i) {
			method[i].write();
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		nodeLabel.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		nodeLabel.setBorder(null);
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() != MouseEvent.BUTTON1)
			return ;
		
		isBorder = false;
		NodeLabel nodeLabel = (NodeLabel)(e.getSource());
		Point point = new Point(e.getX() + nodeLabel.getX(),e.getY() + nodeLabel.getY());
		pressedPoint = point;
		
		if(nodeLabel.isConnectionPoint(point))
			isBorder = true;
		
		isClicked = false;
		isDragged = false;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		isDragged = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() != MouseEvent.BUTTON1)
			return ;
		
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		Point releasedPoint = new Point(e.getX() + nodeLabel.getX() , e.getY() + nodeLabel.getY()); 
		
		if(isDragged && !isBorder && !isClicked) {
			changeLocation(e);
			mouseClicked(e);
		}
		else if(isDragged && isBorder && !isClicked) {
			nodeLabel.manipulateBorder(pressedPoint, releasedPoint);
			mouseClicked(e);
		}
	}
	
	void changeLocation(MouseEvent e) {
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		int width = nodeLabel.getWidth();
		int height = nodeLabel.getHeight();
		Point originPoint = nodeLabel.getLocation();
		int changedX = originPoint.x + e.getX() - width/2, changedY = originPoint.y + e.getY() - height / 2;
		if(changedX < 0 || changedX > Constants.MINDMAP_X_SIZE || changedY < 0 || changedY > Constants.MINDMAP_Y_SIZE)
			return;
		Constants.setComponent(new Point(changedX, changedY), width, height, nodeLabel);
	}
}
