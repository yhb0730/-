package gui;

import java.awt.*;
import javax.swing.*;

import dataStructure.Node;

public class MindMapEditorPane extends JPanel{
	private JButton title;
	private MindMapEditor mindMapEditor;
	
	MindMapEditorPane(){
		setLayout(null);
		
		title = new JButton("Mind Map Pane");
		Constants.setComponent(new Point(240, 0), 180, 30, 20, title); //생성전이라 getWidth()가 안된다.
		title.setEnabled(false);
		add(title);
		
		mindMapEditor = new MindMapEditor();
		Constants.setComponent(new Point(0, 0), 650, 548, mindMapEditor);
		add(mindMapEditor);
	}
	
	public boolean makeTree(String[] parse) {
		return mindMapEditor.makeTree(parse);
	}
	
	public void draw() {
		mindMapEditor.drawAll();
	}
	
	public Node getHead() {
		return mindMapEditor.getHead();
	}
}
