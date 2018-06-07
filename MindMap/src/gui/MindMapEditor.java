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
	
	static int range = 10;
	
	MindMapEditor(AttributeEditor attrEditor){
		this.attrEditor = attrEditor;
		panel = new JPanel();
		panel.setLayout(null);
		
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.getViewport().add(panel, null);
	}
	
	boolean makeTree(String[] parse) {
		if(!nodeArr.isEmpty()) {
			removeAllLabel();
			nodeArr.removeAllElements();
		}
		if(NodeManager.makeTree(parse) == null) {
			JOptionPane.showMessageDialog(null, "���ε� ���� ����� �������� �ʾҽ��ϴ�.", "���α׷� ����", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void removeAllLabel() {
		for(int i=0; i < nodeArr.size(); ++i) {
		try {
			panel.remove(nodeArr.get(i).getArrow());
		}catch(NullPointerException e) {
			;
		}
			panel.remove(nodeArr.get(i));
		}
	}
	
	//�̷��� �׳� ������ ��尣�� ���� �ڽ��̰� �θ����� ������ �ȵȴ�. �� ����鼭 �ְ� �׷����Ѵ�.
	NodeLabel makeNodeLabel(Node node, NodeLabel parent) {
		NodeLabel nodeLabel = new NodeLabel(node, parent);
		attrEditor.setNodeLabel(nodeLabel); //���⸦ �� �ؼ� �����. �߿�(6��2��) �̰� ���� �����༭ NodeLabelMouseMethod���� nodeLabel��  null�� �Ǽ� ��. ���� �ڵ�� nodeLabel�� �Ѱ���� ������ �̰� �ϴ°� �����
		MouseAdapter listener = new NodeLabelMouseListener(attrEditor);
		nodeLabel.addMouseListener(listener);
		nodeLabel.addMouseMotionListener(listener); //motionListener�� mouseListener�� ����. Dragged�� motionListener�̴�.
		node.setMyNodeLabel(nodeLabel);
		nodeArr.add(nodeLabel);
		attrEditor.setNodeLabel(null); //�ƹ��͵� ���õ��� ���� ä change ��ư ������ �۵� ���ϵ��� �ϱ� ���� ���� �ڵ�. NodeLabelMouseListener�� �߸��� ���� ������ �������� �̺��� �����ϰ� �ذ��� �� �ִ� ����� �������� �ʴ´�.
		return nodeLabel;
	}
	
	public void drawAll() {
		if(NodeManager.getHead() == null) {
			//����Ǹ� �ȵǴ� �κ�. Ȥ�� �� �Ǽ��� ���� ó��
			JOptionPane.showMessageDialog(null, "head Node�� null�Դϴ�.", "����Ǽ��� �ȵǴ� ����", JOptionPane.ERROR_MESSAGE);
		}
		else {
			draw(NodeManager.getHead(), new Point(300, 300));
			getParent().revalidate();
			getParent().repaint();
			panel.revalidate();
			panel.repaint();
		}
	}
	
	public void repaintUI() {
		removeAllLabel();
		for(int i=0; i < nodeArr.size(); ++i) {
			panel.add(nodeArr.get(i));
			try {
				panel.add(nodeArr.get(i).getArrow());
			}catch(NullPointerException e) {
				//�ֻ��� ���� arrow�� ����
			}
		}
		getParent().revalidate();
		getParent().repaint();
		panel.revalidate();
		panel.repaint();
	}
	
	void draw(Node node, Point location) {
	
		Queue<Node> queue = new LinkedList<Node>();
		NodeLabel nodeLabel = makeNodeLabel(node, null);
		Constants.setComponent(new Point(location.x + node.getLevel() * 10 + range, location.y + node.getLevel() * 10 + range), Constants.NODE_X_SIZE, Constants.NODE_Y_SIZE, nodeLabel);
		panel.add(nodeLabel);
		queue.add(node);
		while(!queue.isEmpty()) {
			Node cur = queue.peek(); queue.remove();
			
			for(int next = 0; next < cur.getSize(); ++next) {
				Node nextNode = cur.getChild(next);
				nodeLabel = makeNodeLabel(nextNode, cur.getMyNodeLabel());
				Constants.setComponent(new Point(location.x + node.getLevel() * 100 + range, location.y + node.getLevel() * 10 + range), Constants.NODE_X_SIZE, Constants.NODE_Y_SIZE, nodeLabel);
				range += 10;
				panel.add(nodeLabel);
				queue.add(nextNode);
			}
		}
	}

	public void drawArrow(NodeLabel nodeLabel) {
		Arrow arrow = new Arrow();
		NodeLabel parent = nodeLabel.getParentLabel();
		Point start = nodeLabel.getLocation();
		Point end = parent.getLocation();
		arrow.setStart(start);
		arrow.setEnd(end);
		nodeLabel.setArrow(arrow);
		panel.add(arrow);
	}

}

