package gui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

public class Shadow extends JComponent{
	private int height;
	private int width;
	private Point leftUp;
	private Point leftDown;
	private Point rightUp;
	private Point rightDown;
	
	public Shadow(NodeLabel node){
		this.height = node.getHeight();
		this.width = node.getWidth();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(leftUp.x, leftUp.y, leftDown.x, leftDown.y);
		g.drawLine(leftUp.x, leftUp.y, rightUp.x, rightUp.y);
		g.drawLine(leftDown.x, leftDown.y, rightDown.x, rightDown.y);
		g.drawLine(rightUp.x, rightUp.y, rightDown.x, rightDown.y);
	}
	
	public void borderMoved(int num, MouseEvent e) {
		NodeLabel nodeLabel = (NodeLabel)e.getSource();
		Point nodePoint = nodeLabel.getLocation();
		Point absPoint = new Point(nodePoint.x + e.getX(), nodePoint.y + e.getY());
		switch(num) {
		case NodeLabel.UP :
			if(absPoint.y > nodeLabel.getBottom().y - NodeLabel.OFFSET) {
				absPoint.y = nodeLabel.getBottom().y - NodeLabel.OFFSET;
			}
			leftUp = new Point(nodeLabel.getLeft().x ,absPoint.y);
			leftDown = new Point(nodeLabel.getLeft().x, nodeLabel.getBottom().y);
			rightUp = new Point(nodeLabel.getRight().x, absPoint.y);
			rightDown = new Point(nodeLabel.getRight().x, nodeLabel.getBottom().y);
			break;
		case NodeLabel.DOWN :
			if(absPoint.y < nodeLabel.getTop().y + NodeLabel.OFFSET) {
				absPoint.y = nodeLabel.getTop().y + NodeLabel.OFFSET;
			}
			leftUp = new Point(nodeLabel.getLeft().x, nodeLabel.getTop().y);
			leftDown = new Point(nodeLabel.getLeft().x, absPoint.y);
			rightUp = new Point(nodeLabel.getRight().x, nodeLabel.getTop().y);
			rightDown = new Point(nodeLabel.getRight().x, absPoint.y);
			break;
		case NodeLabel.LEFT :
			if(absPoint.x > nodeLabel.getRight().x - NodeLabel.OFFSET) {
				absPoint.x = nodeLabel.getRight().x - NodeLabel.OFFSET;
			}
			leftUp = new Point(absPoint.x, nodeLabel.getTop().y);
			leftDown = new Point(absPoint.x, nodeLabel.getBottom().y);
			rightUp = new Point(nodeLabel.getRight().x, nodeLabel.getTop().y);
			rightDown = new Point(nodeLabel.getRight().x, nodeLabel.getBottom().y);
			break;
		case NodeLabel.RIGHT :
			if(absPoint.x < nodeLabel.getLeft().x + NodeLabel.OFFSET) {
				absPoint.x = nodeLabel.getLeft().x + NodeLabel.OFFSET;
			}
			leftUp = new Point(nodeLabel.getLeft().x, nodeLabel.getTop().y);
			leftDown = new Point(nodeLabel.getLeft().x, nodeLabel.getBottom().y);
			rightUp = new Point(absPoint.x, nodeLabel.getTop().y);
			rightDown = new Point(absPoint.x, nodeLabel.getBottom().y);
			break;
		}
	}
	
	public void NodeMove(Point mousePoint) {
		leftUp = new Point(mousePoint.x - width/2, mousePoint.y - height / 2);
		leftDown = new Point(mousePoint.x - width/2, mousePoint.y + height / 2);
		rightUp = new Point(mousePoint.x + width/2, mousePoint.y -  height / 2);
		rightDown = new Point(mousePoint.x + width/2, mousePoint.y + height / 2);
	}

	public Point getLeftUp() {
		return leftUp;
	}

	public Point getLeftDown() {
		return leftDown;
	}

	public Point getRightUp() {
		return rightUp;
	}

	public Point getRightDown() {
		return rightDown;
	}	
}
