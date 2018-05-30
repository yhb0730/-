package dataStructure;

import java.awt.Point;
import java.util.Vector;

public class Node {
	private Point point;
	private int size;
	private int level;
	private String name;
	private Node parent;
	private Vector<Node> child = new Vector<Node>();
	
	public Node(){
		this("dummy", -1);
	}
	
	public Node(String name, int level){
		this.name = name;
		this.level = level;
	}

	public void addChild(Node child) {
		this.child.add(child);
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Vector<Node> getChild() {
		return child;
	}

	public void setChild(Vector<Node> child) {
		this.child = child;
	}
}
