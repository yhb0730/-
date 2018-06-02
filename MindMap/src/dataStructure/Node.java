package dataStructure;

import java.awt.Point;
import java.util.Vector;

import gui.Constants;

public class Node {
	//Node를 구별할 수 있는 PK가 필요 => 만드는 방식이 깊이 우선 탐색 방식이니까 만들면서 점수 번호 부여한 뒤 해당 노드의 자식의 범위를 저장하는 방식이 가장 현실적일듯? (B*tree 마냥)
	//대신 깊이 우선 방식으로 만들면 나중에 삭제 기능 생성시 지옥을 볼 수 있음
	private int index;
	private int maxIndex; //minIndex는 자기 자신이다(깊이 기반 탐색이므로)
	private int level;
	private String string;
	private Node parent;
	private Vector<Node> child = new Vector<Node>();

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
}
