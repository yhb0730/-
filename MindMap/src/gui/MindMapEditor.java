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
			JOptionPane.showMessageDialog(null, "마인드 맵이 제대로 생성되지 않았습니다.", "프로그램 오류", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	//이렇게 그냥 넣으면 노드간에 누가 자식이고 부모인지 구분이 안된다. 걍 만들면서 넣고 그려야한다.
	NodeLabel makeNodeLabel(Node node) {
		NodeLabel nodeLabel = new NodeLabel(node);
		attrEditor.setNodeLabel(nodeLabel); //여기를 안 해서 고생함. 중요(6/2) 이걸 먼저 안해줘서 NodeLabelMouseMethod에서 nodeLabel이  null이 되서 들어감. 기존 코드는 nodeLabel을 넘겨줬기 때문에 이걸 하는걸 까먹음
		MouseAdapter listener = new NodeLabelMouseListener(nodeLabel, attrEditor);
		nodeLabel.addMouseListener(listener);
		nodeArr.add(nodeLabel);
		return nodeLabel;
	}
	
	public void drawAll() {
		if(NodeManager.getHead() == null) {
			//실행되면 안되는 부분. 혹시 모를 실수를 위해 처리
			JOptionPane.showMessageDialog(null, "head Node가 null입니다.", "실행되서는 안되는 오류", JOptionPane.ERROR_MESSAGE);
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
				//이거 좌표 지정이 제일 문제. level에 따라 범위도 늘려줘야하고
				nodeLabel.addMouseListener(null); //여기에 클릭하면 attribute쪽에 적는 리스너 생성해야함
				add(nodeLabel);
			}
		}*/
	}
}
