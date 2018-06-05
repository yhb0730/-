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
		Constants.setComponent(new Point(240, 0), 180, 30, 20, title); //�������̶� getWidth()�� �ȵȴ�.
		title.setEnabled(false);
		title.setVisible(true);
		add(title);
		
		mindMapEditor = new MindMapEditor(attrEditor);
		Constants.setComponent(new Point(0, 0), Constants.MINDMAP_X_SIZE, Constants.MINDMAP_Y_SIZE, mindMapEditor);
		add(mindMapEditor);
		mindMapEditor.setVisible(true);
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
