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
		panel.setPreferredSize(new Dimension(Constants.SCROLL_X_SIZE, Constants.SCROLL_Y_SIZE)); //Scrollpane은  미니멈, 맥시멈, setSize를 전부 무시해버린다. preferred만 작용
		
		title = new JButton("Mind Map Pane");
		Constants.setComponent(new Point(Constants.SCROLL_X_SIZE / 2 - 50, 0), 180, 30, 20, title);
		title.setEnabled(false);
		panel.add(title);
		
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getViewport().add(panel, null);
		this.getViewport().setViewPosition(new Point(Constants.MINDMAP_X_SIZE - 450, Constants.MINDMAP_Y_SIZE - 350)); //순서가 add 뒤에 와야한다.		
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
			JOptionPane.showMessageDialog(null, "마인드 맵이 제대로 생성되지 않았습니다.", "프로그램 오류", JOptionPane.ERROR_MESSAGE);
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
	
	//이렇게 그냥 넣으면 노드간에 누가 자식이고 부모인지 구분이 안된다. 걍 만들면서 넣고 그려야한다.
	NodeLabel makeNodeLabel(Node node, NodeLabel parent) {
		NodeLabel nodeLabel = new NodeLabel(node, parent);
		if(parent != null) {
			parent.getChildVector().add(nodeLabel);
		}
		attrEditor.setNodeLabel(nodeLabel); //여기를 안 해서 고생함. 중요(6월2일) 이걸 먼저 안해줘서 NodeLabelMouseMethod에서 nodeLabel이  null이 되서 들어감. 기존 코드는 nodeLabel을 넘겨줬기 때문에 이걸 하는걸 까먹음
		MouseAdapter listener = new NodeLabelMouseListener(attrEditor, this);
		nodeLabel.addMouseListener(listener);
		nodeLabel.addMouseMotionListener(listener); //motionListener와 mouseListener는 별개. Dragged는 motionListener이다.
		node.setMyNodeLabel(nodeLabel);
		nodeVector.add(nodeLabel);
		attrEditor.setNodeLabel(null); //아무것도 선택되지 않은 채 change 버튼 눌리면 작동 안하도록 하기 위해 만든 코드. NodeLabelMouseListener의 잘못된 구조 때문에 들어간거지만 이보다 간단하게 해결할 수 있는 방법은 존재하지 않는다.
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
			//실행되면 안되는 부분. 혹시 모를 실수를 위해 처리
			JOptionPane.showMessageDialog(null, "head Node가 null입니다.", "실행되서는 안되는 오류", JOptionPane.ERROR_MESSAGE);
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
		nodeLabel.connectPointInit(); //먼저 init가 안되기때문
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

}

