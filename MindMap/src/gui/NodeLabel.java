package gui;

import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.*;
import dataStructure.*;

public class NodeLabel extends JLabel{
	final static int UP = 0;
	final static int DOWN = 1;
	final static int LEFT = 2;
	final static int RIGHT = 3;
	final static int OFFSET = 10;
	
	private Node node;
	private NodeLabel parentLabel;
	private Arrow arrow;
	private Point top;
	private Point bottom;
	private Point left;
	private Point right;
	
	public NodeLabel getParentLabel() {
		return parentLabel;
	}

	public void setParentLabel(NodeLabel parentLabel) {
		this.parentLabel = parentLabel;
	}

	public void setBottom(Point bottom) {
		this.bottom = bottom;
	}	
	
	public NodeLabel(Node node, NodeLabel parent){
		this.node = node;
		this.parentLabel = parent;
		setText(node.getString());
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);;
		setOpaque(true);
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.black);
	}
		
	public void connectPointInit() {
		Point location = getLocation();
		int width = getWidth(), height = getHeight();
		top = new Point(location.x + width / 2, location.y);
		bottom = new Point(location.x + width / 2, location.y + height);
		left = new Point(location.x, location.y + height / 2);
		right = new Point(location.x + width, location.y + height / 2);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		connectPointInit();
	}
			
	public int getWidth() {
		return this.getSize().width;
	}


	public void setWidth(int width) {
		setSize(width, getHeight());
		connectPointInit();
	}


	public int getHeight() {
		return this.getSize().height;
	}


	public void setHeight(int height) {
		setSize(getWidth(), height);
		connectPointInit();
	}

	public Arrow getArrow() {
		return arrow;
	}

	public void setArrow(Arrow arrow) {
		this.arrow = arrow;
	}

	public Node getNode() {
		return node;
	}
		
	public void setNode(Node node) {
		this.node = node;
	}
		
	public Point getTop() {
		return top;
	}

	public Point getBottom() {
		return bottom;
	}

	public Point getLeft() {
		return left;
	}

	public Point getRight() {
		return right;
	}
	
	public boolean isConnectionPoint(Point point) {
		if(findPressedConnection(point) < 0)
			return false;
		return true;
	}
	
	public void manipulateBorder(Point pressed, Point released) {
		int num = findPressedConnection(pressed);
		Point changedPoint = this.getLocation();
		int changedWidth = this.getWidth();
		int changedHeight = this.getHeight();
		int limitY = 0, limitX = 0;
		
		connectPointInit();
		
		switch(num) {
		case NodeLabel.UP :
			limitY = this.getY() + this.getHeight();
			changedPoint = new Point(changedPoint.x, released.y);
			changedHeight += (this.getY() - released.y);
			if(released.y >= limitY - OFFSET) {
				changedPoint = new Point(changedPoint.x, limitY - OFFSET);
				changedHeight = OFFSET;
			}
			break;
		case NodeLabel.DOWN :
			limitY = this.getY();
			changedHeight = (released.y - this.getY());
			if(released.y <= limitY + OFFSET) {
				changedHeight = OFFSET;
			}
			break;
		case NodeLabel.LEFT :
			limitX = this.getX() + this.getWidth() - OFFSET;
			changedPoint = new Point(released.x, this.getY());
			changedWidth += (this.getX() - released.x);
			if(released.x >= limitX + OFFSET) {
				changedPoint = new Point(limitX + OFFSET, changedPoint.y);
				changedWidth = OFFSET;
			}
			break;
		case NodeLabel.RIGHT :
			limitX = this.getX();
			changedWidth = (released.x - this.getX());
			if(released.x <= limitX + OFFSET) {
				changedWidth = OFFSET;
			}
			break;
		}
		Constants.setComponent(changedPoint, changedWidth, changedHeight, this);
	}
	
	//�Լ� ȣ�� ������ ��������, �� ���ΰ� �������� �ʹ� �������� �����ΰ� ����
	private int findPressedConnection(Point pressed) {
		int x = pressed.x;
		int y = pressed.y;
		
		//�Ʒ� ������ �ذ��Ϸ��� ���� JLabel�� �ٿ��� �ذ��ϴ°� ���غ��̱� �ϳ� �̹� ���������Ƿ� �̴�� �������д�.
		//offset�� ���� ���� �κ��� NodeLabel �κ��� �ƴϿ��� ������ ��ü�� ������ �ȵǹǷ� �����Ѵ�.
		if(top.x <= x + (OFFSET / 2) && x <= top.x + (OFFSET / 2))
			if(top.y <= y && y <= top.y + (OFFSET / 2))
				return NodeLabel.UP;
		
		if(bottom.x - (OFFSET / 2) <= x && x <= bottom.x + (OFFSET / 2))
			if(bottom.y - (OFFSET / 2) <= y && y <= bottom.y)
				return NodeLabel.DOWN;
		
		if(left.x <= x && x <= left.x + (OFFSET / 2)) 
			if(left.y - (OFFSET / 2) <= y && y <= left.y + (OFFSET / 2))
				return NodeLabel.LEFT;
		
		if(right.x - (OFFSET / 2) <= x && x <= right.x)
			if(right.y - (OFFSET / 2) <= y && y <= right.y + (OFFSET / 2))
				return NodeLabel.RIGHT;
		
		return -1;
	}
	
}
