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
	private Node head;  //������ ���� => Ŭ���ϸ� �ٷ� �� ��ü�� �˾ƾ� �ϴµ� �̷������� ��Ʈ ������ Ž���� �ؾ��Ѵ�. ������ �̰� ����Ʈ���� �ƴѵ� ���� �θ� ���� ã�� �� �ִ� ����� ����?
	private Vector<NodeLabel> nodeArr; //����ٰ� �����ؾߵ��� ����.
	
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
			JOptionPane.showMessageDialog(null, "���ε� ���� ����� �������� �ʾҽ��ϴ�.", "���α׷� ����", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	//�̷��� �׳� ������ ��尣�� ���� �ڽ��̰� �θ����� ������ �ȵȴ�. �� ����鼭 �ְ� �׷����Ѵ�.
	NodeLabel makeNodeLabel(Node node) {
		NodeLabel nodeLabel = new NodeLabel(node);
		nodeArr.add(nodeLabel);
		return nodeLabel;
	}
	
	void drawAll() {
		if(head == null) {
			//����Ǹ� �ȵǴ� �κ�. Ȥ�� �� �Ǽ��� ���� ó��
			JOptionPane.showMessageDialog(null, "head Node�� null�Դϴ�.", "����Ǽ��� �ȵǴ� ����", JOptionPane.ERROR_MESSAGE);
		}
		else {
			removeAll();
			//TODO : ��¥�� �׸��°� ������ �κ�. �̰� �޼ҵ� �̸��� �ٲ���ҵ�? draw�� ���� ������ 
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
				//�̰� ��ǥ ������ ���� ����. level�� ���� ������ �÷�����ϰ�
				nodeLabel.addMouseListener(null); //���⿡ Ŭ���ϸ� attribute�ʿ� ���� ������ �����ؾ���
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
