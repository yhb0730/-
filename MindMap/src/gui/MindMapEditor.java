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
			JOptionPane.showMessageDialog(null, "마인드 맵이 제대로 생성되지 않았습니다.", "프로그램 오류", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void removeAllLabel() {
		for(int i=0; i < nodeArr.size(); ++i) {
			panel.remove(nodeArr.get(i));
		}
		getParent().revalidate();
		getParent().repaint();
		panel.revalidate();
		panel.repaint();
	}
	
	//이렇게 그냥 넣으면 노드간에 누가 자식이고 부모인지 구분이 안된다. 걍 만들면서 넣고 그려야한다.
	NodeLabel makeNodeLabel(Node node, NodeLabel parent) {
		NodeLabel nodeLabel = new NodeLabel(node, parent);
		attrEditor.setNodeLabel(nodeLabel); //여기를 안 해서 고생함. 중요(6월2일) 이걸 먼저 안해줘서 NodeLabelMouseMethod에서 nodeLabel이  null이 되서 들어감. 기존 코드는 nodeLabel을 넘겨줬기 때문에 이걸 하는걸 까먹음
		MouseAdapter listener = new NodeLabelMouseListener(attrEditor);
		nodeLabel.addMouseListener(listener);
		nodeLabel.addMouseMotionListener(listener); //motionListener와 mouseListener는 별개. Dragged는 motionListener이다.
		node.setMyNodeLabel(nodeLabel);
		nodeArr.add(nodeLabel);
		attrEditor.setNodeLabel(null); //아무것도 선택되지 않은 채 change 버튼 눌리면 작동 안하도록 하기 위해 만든 코드. NodeLabelMouseListener의 잘못된 구조 때문에 들어간거지만 이보다 간단하게 해결할 수 있는 방법은 존재하지 않는다.
		return nodeLabel;
	}
	
	public void drawAll() {
		if(NodeManager.getHead() == null) {
			//실행되면 안되는 부분. 혹시 모를 실수를 위해 처리
			JOptionPane.showMessageDialog(null, "head Node가 null입니다.", "실행되서는 안되는 오류", JOptionPane.ERROR_MESSAGE);
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

}

