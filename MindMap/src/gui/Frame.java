package gui;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
	private TextEditorPane textEditor;
	private MindMapEditorPane MindMapEditor;
	private AttributeEditorPane AttributeEditor;
	
	public Frame() {
		setTitle("MindMap Application v0.01");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(null);
		
		textEditor = new TextEditorPane();
		//여기부터
		setSize(1000, 600);
		setVisible(true);
	}
}
