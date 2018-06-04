package guiListener.MouseListener;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import NodeLabelMouseMethod.*;
import gui.AttributeEditor;
import gui.Constants;
import gui.NodeLabel;

public class NodeLabelMouseListener extends MouseAdapter{
	private NodeLabel nodeLabel;
	private AttributeEditor attrEditor;
	private NodeMouseMethod[] method;
	private boolean isBorder = false;
	private int	dragStartedX;
	private int dragStartedY;
	
	public NodeLabelMouseListener(NodeLabel nodeLabel, AttributeEditor attrEditor){
		this.nodeLabel = nodeLabel; //e.getSoure�� ��ü�� �� ������ �����ѵ�?
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
		
		if(method.length != attrEditor.getLength()) {
			System.out.println("NodeMethod��  attributeEditor�� ������ �� �½��ϴ�. �ڵ� ���� �ʿ�");
			return;
		}
		attrEditor.setNodeLabel((NodeLabel)e.getSource());
		//attrEditor.setNodeLabel(nodeLabel);
		for(int i=0; i < method.length; ++i) {
			method[i].write();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.dragStartedX = e.getX();
		this.dragStartedY = e.getY();
		isBorder = true;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(isBorder)
			changeLocation(e);
		else
			;
	}
	
	void changeLocation(MouseEvent e) {
		//TODO clicked�� ������ �� �� �� �˾Ҵµ� clicked�� �̰Ŷ� ���� ����ǹ�����.
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		int width = nodeLabel.getWidth();
		int height = nodeLabel.getHeight();
		Point originPoint = nodeLabel.getLocation();
		Constants.setComponent(new Point(originPoint.x + e.getX() - width/2, originPoint.y + e.getY() - height/2), width, height, nodeLabel);
	}
}
