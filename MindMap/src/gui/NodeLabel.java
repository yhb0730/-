package gui;

import java.awt.*;
import javax.swing.*;
import dataStructure.*;

public class NodeLabel extends JLabel{
	final static int UP = 0;
	final static int DOWN = 1;
	final static int LEFT = 2;
	final static int RIGHT = 3;
	
	private Node node;
	private NodeLabel parent;
	private Arrow arrow;
	private Point top;
	private Point bottom;
	private Point left;
	private Point right;
		
	
	public NodeLabel(Node node, NodeLabel parent){
		this.node = node;
		this.parent = parent;
		setText(node.getString());
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);;
		setOpaque(true);
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.black);
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(arrow.getColor());
		
		
		Point end;
		//arrow를 어떻게 그릴것인가가 문제
		switch(determineArrow()) {
		case NodeLabel.UP :
			break;
		case NodeLabel.DOWN :
			break;
		case NodeLabel.LEFT :
			break;
		case NodeLabel.RIGHT :
			break;
		}
		g.drawLine();
	}
	
	private int determineArrow() {
		return 0;
	}
		
	public void connectPointInit() {
		Point location = getLocation();
		int width = getWidth(), height = getHeight();
		top = new Point(location.x + width / 2, location.y);
		down = new Point(location.x + width / 2, location.y + height);
		left = new Point(location.x, location.y + height / 2);
		right = new Point(location.x + width, location.y + height / 2);
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

	public Point getDown() {
		return down;
	}

	public Point getLeft() {
		return left;
	}

	public Point getRight() {
		return right;
	}
}
