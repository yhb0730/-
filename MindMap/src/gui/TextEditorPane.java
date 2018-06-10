package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import javax.swing.*;

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
}

