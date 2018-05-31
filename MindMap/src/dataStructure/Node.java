package dataStructure;

import java.awt.Point;
import java.util.Vector;

import gui.Constants;

public class Node {
	//Node�� ������ �� �ִ� PK�� �ʿ� => ����� ����� ���� �켱 Ž�� ����̴ϱ� ����鼭 ���� ��ȣ �ο��� �� �ش� ����� �ڽ��� ������ �����ϴ� ����� ���� �������ϵ�? (B*tree ����)
	//��� ���� �켱 ������� ����� ���߿� ���� ��� ������ ������ �� �� ����
	private int index;
	private int maxIndex; //minIndex�� �ڱ� �ڽ��̴�(���� ��� Ž���̹Ƿ�)
	private int level;
	private String name;
	private Node parent;
	private Vector<Node> child = new Vector<Node>();

	public Node(){
		this(-1, "dummy", -1);
	}
	
	public Node(int index, String name, int level){
		this.index = index;
		this.maxIndex = index;
		this.name = name;
		this.level = level;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getMaxIndex() {
		return maxIndex;
	}
	
	public void setMaxIndex(int maxIndex) {
		this.maxIndex = Math.max(this.maxIndex, maxIndex);
		this.parent.setMaxIndex(this.maxIndex);
	}

	public void addChild(Node child) {
		this.child.add(child);
		this.setMaxIndex(child.getMaxIndex());
	}
	
	public Node getChild(int num) {
		return child.get(num);
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
	
	public int getSize() {
		return child.size();
	}
}
