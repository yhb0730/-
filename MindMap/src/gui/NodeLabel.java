package gui;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Vector;

import javax.swing.*;
import dataStructure.*;
import mindMapUtil.MindMapMath;

public class NodeLabel extends JLabel{
	final public static int UP = 0;
	final public static int DOWN = 1;
	final public static int LEFT = 2;
	final public static int RIGHT = 3;
	final public static int OFFSET = 10;
	
	private Node node;
	private Point top;
	private Point bottom;
	private Point left;
	private Point right;
	private Arrow arrow;
	private NodeLabel parentLabel;
	private Vector<NodeLabel> childLabel = new Vector<NodeLabel>();
	
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
	
	public boolean isConnectionPoint(Point point) {
		if(findPressedOutline(point) < 0)
			return false;
		return true;
	}
	
	public void manipulateBorder(Point pressed, Point released) {
		int num = findPressedOutline(pressed);
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
		connectPointInit();
		refreshArrow(true);
	}
	
	//함수 호출 구조가 문제던가, 이 내부가 문제던가 너무 쓸데없는 구조인거 같음
	public int findPressedOutline(Point pressed) {
		int x = pressed.x;
		int y = pressed.y;
		int halfWidth = getWidth() / 2;
		int halfHeight = getHeight() / 2;
		
		//아래 문제를 해결하려면 작은 JLabel을 붙여서 해결하는게 편해보이긴 하나 이미 만들어놨으므로 이대로 내버려둔다.
		//offset이 들어가지 않은 부분은 NodeLabel 부분이 아니여서 리스너 자체가 실행이 안되므로 제외한다.
		if(top.x - halfWidth <= x && x <= top.x + halfWidth)
			if(top.y <= y && y <= top.y + (OFFSET / 2))
				return NodeLabel.UP;
		
		if(bottom.x - halfWidth <= x && x <= bottom.x + halfWidth)
			if(bottom.y - (OFFSET / 2) <= y && y <= bottom.y)
				return NodeLabel.DOWN;
		
		if(left.x <= x && x <= left.x + (OFFSET / 2)) 
			if(left.y - halfHeight <= y && y <= left.y + halfHeight)
				return NodeLabel.LEFT;
		
		if(right.x - (OFFSET / 2) <= x && x <= right.x)
			if(right.y - halfHeight <= y && y <= right.y + halfHeight)
				return NodeLabel.RIGHT;
		
		return -1;
	}
	
	public Point getConnectPointByIndex(int index) {
		switch(index) {
		case UP :
			return getTop();
		case DOWN :
			return getBottom();
		case LEFT :
			return getLeft();
		case RIGHT :
			return getRight();
		default :
			JOptionPane.showMessageDialog(null, "Error Occur!", "Error Message", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public Arrow determineArrow() {
		connectPointInit();
		if(parentLabel == null)
			return null;
		Point parentPoint = parentLabel.getLocation(); 
		Point myPoint = this.getLocation();
		MindMapMath.calculateShortestConnectionPoint(this, parentLabel, myPoint, parentPoint);
		arrow = new Arrow(myPoint, parentPoint);
		return arrow;
	}
	
	public void refreshArrow(boolean isFirstTry) {
		this.connectPointInit();
		if(arrow != null) {
			Point parentPoint = parentLabel.getLocation();
			Point myPoint = this.getLocation();
			MindMapMath.calculateShortestConnectionPoint(this, parentLabel, myPoint, parentPoint);
			arrow.refreshArrow(myPoint, parentPoint);
		}
		
		if(isFirstTry == true) {
			for(int i=0; i < childLabel.size(); ++i) {
				childLabel.get(i).refreshArrow(false);
			}
		}
	}
	
	public Arrow getArrow() {
		return arrow;
	}
	public NodeLabel getParentLabel() {
		return parentLabel;
	}

	public void setParentLabel(NodeLabel parentLabel) {
		this.parentLabel = parentLabel;
	}

	public Vector<NodeLabel> getChildVector(){
		return childLabel;
	}
	
	public void setBottom(Point bottom) {
		this.bottom = bottom;
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
}
