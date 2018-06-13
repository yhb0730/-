package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;

import org.json.simple.JSONObject;

import dataStructure.Node;
import dataStructure.NodeManager;
import guiListener.MouseListener.NodeLabelMouseListener;

public class MindMapEditor extends JScrollPane {
	private JButton title;
	private AttributeEditor attrEditor;
	private JPanel panel;
	private Vector<NodeLabel> nodeVector = new Vector<NodeLabel>();
	private Vector<Arrow> arrowVector = new Vector<Arrow>();
	
	static int range = 10;
	
	MindMapEditor(AttributeEditor attrEditor){
		this.attrEditor = attrEditor;
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(Constants.SCROLL_X_SIZE, Constants.SCROLL_Y_SIZE)); //Scrollpane��  �̴ϸ�, �ƽø�, setSize�� ���� �����ع�����. preferred�� �ۿ�
		
		title = new JButton("Mind Map Pane");
		Constants.setComponent(new Point(Constants.SCROLL_X_SIZE / 2 - 50, 0), 180, 30, 20, title);
		title.setEnabled(false);
		panel.add(title);
		
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getViewport().add(panel, null);
		this.getViewport().setViewPosition(new Point(Constants.MINDMAP_X_SIZE - 450, Constants.MINDMAP_Y_SIZE - 350)); //������ add �ڿ� �;��Ѵ�.		
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	boolean makeTree(String[] parse) {
		if(!nodeVector.isEmpty()) {
			removeAllLabel();
			nodeVector.removeAllElements();
			arrowVector.removeAllElements();
		}
		if(NodeManager.makeTree(parse) == null) {
			return false;
		}
		return true;
	}
	
	public void removeAllLabel() {
		for(int i=0; i < nodeVector.size(); ++i) {
			panel.remove(nodeVector.get(i));
		}
		for(int i=0; i < arrowVector.size(); ++i) {
			panel.remove(arrowVector.get(i));
		}
		getParent().revalidate();
		getParent().repaint();
		panel.revalidate();
		panel.repaint();
	}
	
	//�̷��� �׳� ������ ��尣�� ���� �ڽ��̰� �θ����� ������ �ȵȴ�. �� ����鼭 �ְ� �׷����Ѵ�.
	NodeLabel makeNodeLabel(Node node, NodeLabel parent) {
		NodeLabel nodeLabel = new NodeLabel(node, parent);
		if(parent != null) {
			parent.getChildVector().add(nodeLabel);
		}
		attrEditor.setNodeLabel(nodeLabel); //���⸦ �� �ؼ� �����. �߿�(6��2��) �̰� ���� �����༭ NodeLabelMouseMethod���� nodeLabel��  null�� �Ǽ� ��. ���� �ڵ�� nodeLabel�� �Ѱ���� ������ �̰� �ϴ°� �����
		MouseAdapter listener = new NodeLabelMouseListener(attrEditor, this);
		nodeLabel.addMouseListener(listener);
		nodeLabel.addMouseMotionListener(listener); //motionListener�� mouseListener�� ����. Dragged�� motionListener�̴�.
		node.setMyNodeLabel(nodeLabel);
		nodeVector.add(nodeLabel);
		attrEditor.setNodeLabel(null); //�ƹ��͵� ���õ��� ���� ä change ��ư ������ �۵� ���ϵ��� �ϱ� ���� ���� �ڵ�. NodeLabelMouseListener�� �߸��� ���� ������ �������� �̺��� �����ϰ� �ذ��� �� �ִ� ����� �������� �ʴ´�.
		return nodeLabel;
	}
	
	public void repaintUI() {
		removeAllLabel();
		for(int i=0; i < nodeVector.size(); ++i) {
			panel.add(nodeVector.get(i));
		}
		for(int i=0; i < arrowVector.size(); ++i) {
			panel.add(arrowVector.get(i));
		}
		getParent().revalidate();
		getParent().repaint();
		panel.revalidate();
		panel.repaint();
	}
	
	public void drawAll() {
		if(NodeManager.getHead() == null) {
			//����Ǹ� �ȵǴ� �κ�. Ȥ�� �� �Ǽ��� ���� ó��
			JOptionPane.showMessageDialog(null, "head Node�� null�Դϴ�.", "����Ǽ��� �ȵǴ� ����", JOptionPane.ERROR_MESSAGE);
		}
		else {
			range = 10;
			draw(NodeManager.getHead(), new Point(Constants.SCROLL_X_SIZE / 2, Constants.SCROLL_Y_SIZE / 2));
			getParent().revalidate();
			getParent().repaint();
			panel.revalidate();
			panel.repaint();
		}
	}

	void draw(Node node, Point location) {
		Queue<Node> queue = new LinkedList<Node>();
		NodeLabel nodeLabel = makeNodeLabel(node, null);
		Constants.setComponent(new Point(location.x, location.y), Constants.NODE_X_SIZE, Constants.NODE_Y_SIZE, nodeLabel);
		nodeLabel.connectPointInit(); //���� init�� �ȵǱ⶧��
		panel.add(nodeLabel);
		//queue.add(node);
		
		NodeLabel rootLabel = nodeLabel;
		double degree = 360.0 / (double)node.getSize();
		double curDegree = 0;
		for(int i=0; i < node.getSize(); ++i) {
			Node levelOneNode = node.getChild(i);
			nodeLabel = makeNodeLabel(levelOneNode, rootLabel);
			Constants.setComponent(new Point((int)(location.x + 150 * Math.cos(curDegree)), (int)(location.y + 150 * Math.sin(curDegree))), Constants.NODE_X_SIZE, Constants.NODE_Y_SIZE, nodeLabel);
			curDegree += degree;
			queue.add(levelOneNode);
			Arrow arrow = nodeLabel.determineArrow();
			Constants.setComponent(new Point(0, 0), Constants.SCROLL_X_SIZE, Constants.SCROLL_Y_SIZE, arrow);
			arrowVector.add(arrow);
			panel.add(arrow);
			panel.add(nodeLabel);
		}
		
		while(!queue.isEmpty()) {
			Node cur = queue.remove();
			degree = 360.0 / (double)cur.getSize();
			curDegree = degree;
			for(int next = 0; next < cur.getSize(); ++next) {
				Node nextNode = cur.getChild(next);
				nodeLabel = makeNodeLabel(nextNode, cur.getMyNodeLabel());
				Point parentLocation = cur.getMyNodeLabel().getLocation();
				Constants.setComponent(new Point((int)(parentLocation.x + 80 * Math.cos(curDegree)), (int)(parentLocation.y + 80 * Math.sin(curDegree))), Constants.NODE_X_SIZE, Constants.NODE_Y_SIZE, nodeLabel);
				queue.add(nextNode);
				Arrow arrow = nodeLabel.determineArrow();
				Constants.setComponent(new Point(0, 0), Constants.SCROLL_X_SIZE, Constants.SCROLL_Y_SIZE, arrow);
				arrowVector.add(arrow);
				panel.add(arrow);
				panel.add(nodeLabel);
				curDegree += degree;
			}
		}
	}
	
	NodeLabel makeNodeLabel(Node node) {
		NodeLabel nodeLabel = node.getMyNodeLabel();
		attrEditor.setNodeLabel(nodeLabel); //���⸦ �� �ؼ� �����. �߿�(6��2��) �̰� ���� �����༭ NodeLabelMouseMethod���� nodeLabel��  null�� �Ǽ� ��. ���� �ڵ�� nodeLabel�� �Ѱ���� ������ �̰� �ϴ°� �����
		MouseAdapter listener = new NodeLabelMouseListener(attrEditor, this);
		nodeLabel.addMouseListener(listener);
		nodeLabel.addMouseMotionListener(listener); //motionListener�� mouseListener�� ����. Dragged�� motionListener�̴�.
		node.setMyNodeLabel(nodeLabel);
		nodeVector.add(nodeLabel);
		attrEditor.setNodeLabel(null); //�ƹ��͵� ���õ��� ���� ä change ��ư ������ �۵� ���ϵ��� �ϱ� ���� ���� �ڵ�. NodeLabelMouseListener�� �߸��� ���� ������ �������� �̺��� �����ϰ� �ذ��� �� �ִ� ����� �������� �ʴ´�.
		return nodeLabel;
	}

	public void drawJson(JSONObject obj) {
		removeAllLabel();
		nodeVector.removeAllElements();
		arrowVector.removeAllElements();
		Queue<Node> queue = new LinkedList<Node>();
		Node head = NodeManager.getHead();
		NodeLabel nodeLabel = makeNodeLabel(head);
		nodeLabel.connectPointInit();
		panel.add(nodeLabel);
		
		queue.add(head);
		
		while(!queue.isEmpty()) {
			Node cur = queue.remove();
			for(int next = 0; next < cur.getSize(); ++next) {
				Node nextNode = cur.getChild(next);
				nodeLabel = makeNodeLabel(nextNode);
				queue.add(nextNode);
				Arrow arrow = nodeLabel.determineArrow();
				Constants.setComponent(new Point(0, 0), Constants.SCROLL_X_SIZE, Constants.SCROLL_Y_SIZE, arrow);
				arrowVector.add(arrow);
				panel.add(arrow);
				panel.add(nodeLabel);
			}
		}
		getParent().revalidate();
		getParent().repaint();
		panel.revalidate();
		panel.repaint();
	}
}

