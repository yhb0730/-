package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
import dataStructure.Node;
import dataStructure.NodeManager;
import guiListener.MouseListener.NodeLabelMouseListener;

public class MindMapEditor extends JScrollPane {
	private AttributeEditor attrEditor;
	private JPanel panel;
	private Vector<NodeLabel> nodeArr = new Vector<NodeLabel>();
	
	MindMapEditor(AttributeEditor attrEditor){
		this.attrEditor = attrEditor;
		panel = new JPanel();
		panel.setLayout(null);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.getViewport().add(panel);
	}
	
	boolean makeTree(String[] parse) {
		if(!nodeArr.isEmpty())
			nodeArr.removeAllElements();

		if(NodeManager.makeTree(parse) == null) {
			JOptionPane.showMessageDialog(null, "���ε� ���� ����� �������� �ʾҽ��ϴ�.", "���α׷� ����", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	//�̷��� �׳� ������ ��尣�� ���� �ڽ��̰� �θ����� ������ �ȵȴ�. �� ����鼭 �ְ� �׷����Ѵ�.
	NodeLabel makeNodeLabel(Node node) {
		NodeLabel nodeLabel = new NodeLabel(node);
		attrEditor.setNodeLabel(nodeLabel); //���⸦ �� �ؼ� �����. �߿�(6/2) �̰� ���� �����༭ NodeLabelMouseMethod���� nodeLabel��  null�� �Ǽ� ��. ���� �ڵ�� nodeLabel�� �Ѱ���� ������ �̰� �ϴ°� �����
		MouseAdapter listener = new NodeLabelMouseListener(nodeLabel, attrEditor);
		nodeLabel.addMouseListener(listener);
		nodeArr.add(nodeLabel);
		return nodeLabel;
	}
	
	public void drawAll() {
		if(NodeManager.getHead() == null) {
			//����Ǹ� �ȵǴ� �κ�. Ȥ�� �� �Ǽ��� ���� ó��
			JOptionPane.showMessageDialog(null, "head Node�� null�Դϴ�.", "����Ǽ��� �ȵǴ� ����", JOptionPane.ERROR_MESSAGE);
		}
		else {
			removeAll();
			draw(NodeManager.getHead(), new Point(300, 300));
			updateUI();
		}
	}
	
	public void repaintUI() {
		removeAll();
		for(int i=0; i < nodeArr.size(); ++i) {
			add(nodeArr.get(i));
		}
		updateUI();
	}
	
	void draw(Node node, Point location) {
		NodeLabel nodeLabel = makeNodeLabel(node);
		Constants.setComponent(new Point(location), Constants.NODE_X_SIZE, Constants.NODE_Y_SIZE, nodeLabel);
		add(nodeLabel);
		if(nodeLabel.getNode().getChild(0) != null)
		{
			NodeLabel childNode = makeNodeLabel(nodeLabel.getNode().getChild(0));
			Constants.setComponent(new Point(-300, 100), Constants.NODE_X_SIZE, Constants.NODE_Y_SIZE, childNode);
			add(childNode);
		}

		/*Queue<Node> queue = new LinkedList<Node>();
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
}
