package dataStructure;

import java.awt.Point;
import java.util.Vector;

import gui.Constants;
import gui.NodeLabel;

public class Node {
	//Node�� ������ �� �ִ� PK�� �ʿ� => ����� ����� ���� �켱 Ž�� ����̴ϱ� ����鼭 ���� ��ȣ �ο��� �� �ش� ����� �ڽ��� ������ �����ϴ� ����� ���� �������ϵ�? (B*tree ����)
	//��� ���� �켱 ������� ����� ���߿� ���� ��� ������ ������ �� �� ����
	private int index;
	private int maxIndex; //minIndex�� �ڱ� �ڽ��̴�(���� ��� Ž���̹Ƿ�)
	private int level;
	private String string;
	private Node parent;
	private Vector<Node> child = new Vector<Node>();
	//�־��� ���������� ���⿡ NodeLabel�� �ִ� ���ۿ� ����.
	NodeLabel myNodeLabel;
	NodeLabel parentLabel;
	
	public Node(){
		this(-1, "dummy", -1);
	}
	
	public Node(int index, String string, int level){
		this.index = index;
		this.maxIndex = index;
		this.string = string;
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
		if(this.parent != null)
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

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
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
	
	public NodeLabel getMyNodeLabel() {
		return myNodeLabel;
	}

	public void setMyNodeLabel(NodeLabel myNodeLabel) {
		this.myNodeLabel = myNodeLabel;
	}

	
	public NodeLabel getParentLabel() {
		return parentLabel;
	}

	public void setParentLabel(NodeLabel parentLabel) {
		this.parentLabel = parentLabel;
	}

}
