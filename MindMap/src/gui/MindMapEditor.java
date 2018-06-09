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
		Constants.setComponent(new Point(240, 0), 180, 30, 20, title);
		title.setEnabled(false);
		panel.add(title);
		
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getViewport().add(panel, null);
	}
	
	boolean makeTree(String[] parse) {
		if(!nodeVector.isEmpty()) {
			removeAllLabel();
			nodeVector.removeAllElements();
			arrowVector.removeAllElements();
		}
		if(NodeManager.makeTree(parse) == null) {
			JOptionPane.showMessageDialog(null, "���ε� ���� ����� �������� �ʾҽ��ϴ�.", "���α׷� ����", JOptionPane.ERROR_MESSAGE);
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
			draw(NodeManager.getHead(), new Point(300, 300));
			getParent().revalidate();
			getParent().repaint();
			panel.revalidate();
			panel.repaint();
		}
	}

	void draw(Node node, Point location) {
		Queue<Node> queue = new LinkedList<Node>();
		NodeLabel nodeLabel = makeNodeLabel(node, null);
		Constants.setComponent(new Point(location.x + node.getLevel() * 10 + range, location.y + node.getLevel() * 10 + range), Constants.NODE_X_SIZE, Constants.NODE_Y_SIZE, nodeLabel);
		nodeLabel.connectPointInit(); //���� init�� �ȵǱ⶧��
		panel.add(nodeLabel);
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node cur = queue.remove();
			for(int next = 0; next < cur.getSize(); ++next) {
				Node nextNode = cur.getChild(next);
				nodeLabel = makeNodeLabel(nextNode, cur.getMyNodeLabel());
				Constants.setComponent(new Point(location.x + node.getLevel() * 100 + range * 5, location.y + node.getLevel() * 10 + range), Constants.NODE_X_SIZE, Constants.NODE_Y_SIZE, nodeLabel);
				range += 10;
				queue.add(nextNode);
				Arrow arrow = nodeLabel.determineArrow();
				Constants.setComponent(new Point(0, 0), 1000, 1000, arrow);
				arrowVector.add(arrow);
				panel.add(arrow);
				panel.add(nodeLabel);
			}
		}
	}

}

