package gui;

import java.awt.*;
import javax.swing.*;

public class MindMapEditorPane extends JPanel{
	private JButton title;
	private MindMapEditor mindMapEditor;
	
	MindMapEditorPane(){
		setLayout(null);
		
		title = new JButton("Mind Map Pane");
		Format.setComponent(new Point(140, 0), 180, 30, 20, title);
		title.setEnabled(false);
		add(title);
		
		mindMapEditor = new MindMapEditor();
		Format.setComponent(new Point(0, 0), 500, 500, mindMapEditor);
		add(mindMapEditor);
	}
}
