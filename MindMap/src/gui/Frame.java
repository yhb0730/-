package gui;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
	private TextEditorPane textEditor;
	private MindMapEditorPane MindMapEditor;
	private AttributeEditorPane AttributeEditor;
	private JSplitPane leftSplit;
	private JSplitPane rightSplit;
	
	public Frame() {
		setTitle("MindMap Application v0.01");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(null);
		
		MindMapEditor = new MindMapEditorPane();
		AttributeEditor = new AttributeEditorPane();
		MindMapEditor.setMinimumSize(new Dimension(200, 100));
		AttributeEditor.setMinimumSize(new Dimension(100, 100));
		rightSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, MindMapEditor, AttributeEditor);
		Constants.setComponent(new Point(250, 100), 900, 550, rightSplit);
		rightSplit.getLeftComponent().setPreferredSize(new Dimension(650, 500));
		add(rightSplit);
		
		textEditor = new TextEditorPane(MindMapEditor);
		leftSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, textEditor, null);
		Constants.setComponent(new Point(0, 100), 250,  550, leftSplit);
		add(leftSplit);
		
		setSize(1200, 700);
		setVisible(true);
	}
}
