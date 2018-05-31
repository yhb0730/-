package gui;

import java.awt.*;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
import dataStructure.Node;
import dataStructure.Tree;

public class MindMapEditor extends JScrollPane {
	private JPanel panel;
	private Node head;  //문제가 생김 => 클릭하면 바로 그 객체를 알아야 하는데 이런식으로 루트 구조면 탐색을 해야한다. 심지어 이건 이진트리도 아닌데 ㅅㅂ 부모 노드로 찾을 수 있는 방법이 뭘까?
	private Vector<NodeLabel> nodeArr; //여기다가 저장해야돌것 같다.
	
	MindMapEditor(){
		panel = new JPanel();
		panel.setLayout(null);
		this.getViewport().add(panel);
	}
	
	boolean makeTree(String[] parse) {
		nodeArr.clear();
		head = Tree.makeTree(parse);
		System.gc();
		if(head == null) {
			JOptionPane.showMessageDialog(null, "마인드 맵이 제대로 생성되지 않았습니다.", "프로그램 오류", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	//이렇게 그냥 넣으면 노드간에 누가 자식이고 부모인지 구분이 안된다. 걍 만들면서 넣고 그려야한다.
	NodeLabel makeNodeLabel(Node node) {
		NodeLabel nodeLabel = new NodeLabel(node);
		nodeArr.add(nodeLabel);
		return nodeLabel;
	}
	
	void drawAll() {
		if(head == null) {
			//실행되면 안되는 부분. 혹시 모를 실수를 위해 처리
			JOptionPane.showMessageDialog(null, "head Node가 null입니다.", "실행되서는 안되는 오류", JOptionPane.ERROR_MESSAGE);
		}
		else {
			removeAll();
			//TODO : 진짜로 그리는게 들어가야할 부분. 이거 메소드 이름을 바꿔야할듯? draw를 따로 만들자 
			draw(head, new Point(this.getWidth()/2, this.getHeight()/2));
			updateUI();
		}
	}
	
	void draw(Node node, Point location) {
		/*LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Node cur = queue.peek(); queue.remove();
			for(int next = 0; next < cur.getSize(); ++next) {
				Node nextNode = cur.getChild(next);
				NodeLabel nodeLabel = makeNodeLabel(nextNode);
				Constants.setComponent(new Point(location.x + node.getLevel(), location.y + node.getLevel()), 30, 15, nodeLabel);
				//이거 좌표 지정이 제일 문제. level에 따라 범위도 늘려줘야하고
				nodeLabel.addMouseListener(null); //여기에 클릭하면 attribute쪽에 적는 리스너 생성해야함
				add(nodeLabel);
			}
		}*/
	}
	
	Node getHead(){
		return head;
	}
	
	class NodeLabel extends JLabel{
		private Point nodeSize;
		private Node node;
		
		NodeLabel(Node node){
			this.node = node;
		}
				
		Point getNodeSize() {
			return nodeSize;
		}
		
		void setNodeSize(Point nodeSize) {
			this.nodeSize = nodeSize;
		}
	}
}
