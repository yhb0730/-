package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;

import javax.swing.*;

import dataStructure.Node;
import guiListener.MouseListener.ChangeBtnMouseListener;

public class MindMapEditorPane extends JPanel{
	private MindMapEditor mindMapEditor;
	private AttributeEditor attrEditor;
	
	
	MindMapEditorPane(AttributeEditor attrEditor){
		setLayout(null);
		this.attrEditor = attrEditor;
	
		mindMapEditor = new MindMapEditor(attrEditor);
		Constants.setComponent(new Point(0, 0), Constants.MINDMAP_X_SIZE, Constants.MINDMAP_Y_SIZE, mindMapEditor);
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
