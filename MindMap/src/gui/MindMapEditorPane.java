package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;

import javax.swing.*;

import dataStructure.Node;
import guiListener.MouseListener.ChangeBtnMouseListener;

public class MindMapEditorPane extends JPanel{
	private JButton title;
	private MindMapEditor mindMapEditor;
	private AttributeEditor attrEditor;
	
	
	MindMapEditorPane(AttributeEditor attrEditor){
		setLayout(null);
		this.attrEditor = attrEditor;
		title = new JButton("Mind Map Pane");
		Constants.setComponent(new Point(240, 0), 180, 30, 20, title); //생성전이라 getWidth()가 안된다.
		title.setEnabled(false);
		add(title);
		
		mindMapEditor = new MindMapEditor(attrEditor);
		Constants.setComponent(new Point(0, 0), 650, 548, mindMapEditor);
		add(mindMapEditor);
	}
	
	public MindMapEditor getMindMapEditor() {
		return this.mindMapEditor;
	}
	
	public boolean makeTree(String[] parse) {
		return mindMapEditor.makeTree(parse);
	}
	
	public void draw() {
		mindMapEditor.drawAll();
	}
}
