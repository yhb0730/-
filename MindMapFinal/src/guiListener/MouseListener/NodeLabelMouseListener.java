package guiListener.MouseListener;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import gui.*;
import guiListener.MouseListener.NodeLabelMouseMethod.*;

public class NodeLabelMouseListener extends MouseAdapter{
	private static NodeLabel prevLabel;
	private MindMapEditor mindMapEditor;
	private AttributeEditor attrEditor;
	private NodeMouseMethod[] method;
	private Point pressedPoint;
	private boolean isBorder = false;
	private boolean isClicked = false;
	private boolean isDragged = false;
	private Shadow shadow;
	
	public NodeLabelMouseListener(AttributeEditor attrEditor, MindMapEditor mindMapEditor){
		this.attrEditor = attrEditor;
		this.mindMapEditor = mindMapEditor;
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
				Color reverseColor = new Color(255 - red, 255 - green, 255 - blue);
				prevLabel.setBackground(reverseColor);
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
				Color reverseColor = new Color(255 - red, 255 - green, 255 - blue);
				nodeLabel.setBackground(reverseColor);	
			}
			prevLabel = nodeLabel;
		}
		if(method.length != attrEditor.getLength()) {
			//debug
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
		
		shadow = new Shadow(nodeLabel);
		if(nodeLabel.isConnectionPoint(point))
			isBorder = true;
		
		isClicked = false;
		isDragged = false;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		isDragged = true;
		
		if(!isBorder) {
			draggedMoveShadow(e);
		}
		else {
			draggedBorderShadow(e);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() != MouseEvent.BUTTON1)
			return ;
		
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		Point releasedPoint = new Point(e.getX() + nodeLabel.getX() , e.getY() + nodeLabel.getY()); 
		if(isDragged) {
			mindMapEditor.getPanel().remove(shadow);
		}
		
		if(isDragged && !isBorder && !isClicked) {
			Constants.IS_CHANGED = true;
			changeLocation(e);
			mindMapEditor.repaintUI();
			mouseClicked(e);
		}
		else if(isDragged && isBorder && !isClicked) {
			Constants.IS_CHANGED = true;
			nodeLabel.manipulateBorder(pressedPoint, releasedPoint);
			mindMapEditor.repaintUI();
			mouseClicked(e);
		}
	}
	
	void draggedMoveShadow(MouseEvent e) {
		JPanel panel = this.mindMapEditor.getPanel();
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		Point nodePoint = nodeLabel.getLocation();
		Point newPoint = new Point(nodePoint.x + e.getX(), nodePoint.y + e.getY());
		try {
			panel.remove(shadow);
		}catch(NullPointerException exception) {
			;
		}
		shadow.NodeMove(newPoint);
		Constants.setComponent(new Point(0,0), Constants.SCROLL_X_SIZE, Constants.SCROLL_Y_SIZE, shadow);
		panel.add(shadow);
		mindMapEditor.revalidate();
		mindMapEditor.repaint();
	}
	
	void draggedBorderShadow(MouseEvent e) {
		JPanel panel = this.mindMapEditor.getPanel();
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		int num = nodeLabel.findPressedOutline(pressedPoint);
		try {
			panel.remove(shadow);
		}catch(NullPointerException exception) {
			;
		}
		shadow.borderMoved(num, e);
		Constants.setComponent(new Point(0,0), Constants.SCROLL_X_SIZE, Constants.SCROLL_Y_SIZE, shadow);
		panel.add(shadow);
		mindMapEditor.revalidate();
		mindMapEditor.repaint();
	}
	
	void changeLocation(MouseEvent e) {
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		int width = nodeLabel.getWidth();
		int height = nodeLabel.getHeight();
		Point originPoint = nodeLabel.getLocation();
		int changedX = originPoint.x + e.getX() - width/2, changedY = originPoint.y + e.getY() - height / 2;
		if(changedX < 0 || changedX > Constants.SCROLL_X_SIZE || changedY < 0 || changedY > Constants.SCROLL_Y_SIZE)
			return;
		Constants.setComponent(new Point(changedX, changedY), width, height, nodeLabel);
		nodeLabel.refreshArrow(true);
	}
}
