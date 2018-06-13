package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.Stack;

import javax.swing.*;

import org.json.simple.JSONObject;

import dataStructure.Node;
import dataStructure.NodeManager;
import guiListener.MouseListener.ApplyBtnMouseListener;

public class TextEditorPane extends JPanel {
	private JButton title;
	private TextArea textArea;
	private JButton applyBtn;
	private MindMapEditorPane mindMapEditor;
	private MouseAdapter listener;
	
	TextEditorPane(MindMapEditorPane mindMapEditor){
		this.mindMapEditor = mindMapEditor;
		setLayout(null);
		title = new JButton("Text Editor Pane");
		Constants.setComponent(new Point(0, 0), 235, 30, 20, title);
		title.setEnabled(false);
		add(title);
		
		textArea = new TextArea();
		Constants.setComponent(new Point(0, 30), 235, 490, textArea);
		add(textArea);
		
		applyBtn = new JButton("Apply");
		Constants.setComponent(new Point(0, 515), 235, 30, applyBtn);
		listener = new ApplyBtnMouseListener(textArea, mindMapEditor);
		applyBtn.addMouseListener(listener);	
		add(applyBtn);
	}
	
	public String getText() {
		return textArea.getText();
	}
	
	public void setText(String text) {
		textArea.setText(text);
	}
	
	public JButton getButton() {
		return applyBtn;
	}
	
	public MouseAdapter getMouseListener() {
		return listener;
	}
	
	public void setJsonText() {
		Node head = NodeManager.getHead();
		if(head == null)
			return ;
		//json으로 불러온 Tree는 이미 생성때 무결성 검사를 했으므로 다시 검사할 필요 없다.
		StringBuilder str = new StringBuilder("");
		str.append(head.getString() + "\n");
		setJsonTextRecursive(head, str);
		textArea.setText(str.toString());
	}
	
	private void setJsonTextRecursive(Node cur, StringBuilder str) {
		int size = cur.getSize();
		for(int i=0; i < size; ++i) {
			Node child = cur.getChild(i);
			int level = child.getLevel();
			StringBuilder childStr = new StringBuilder("");
			for(int j = 0; j < level; ++j) {
				childStr.append("\t");
			}
			childStr.append(child.getString() + "\n");
			setJsonTextRecursive(child, childStr);
			str.append(childStr);
		}
	}
}

