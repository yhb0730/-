package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import javax.swing.*;

import guiListener.MouseListener.ApplyBtnMouseListener;

public class TextEditorPane extends JPanel {
	private JButton title;
	private TextArea textArea;
	private JButton applyBtn;
	
	TextEditorPane(){
		setLayout(null);
		title = new JButton("Text Editor Pane");
		Format.setComponent(new Point(0, 0), 235, 30, 20, title);
		title.setEnabled(false);
		add(title);
		
		textArea = new TextArea();
		Format.setComponent(new Point(0, 30), 235, 350, textArea);
		add(textArea);
		
		applyBtn = new JButton("Àû¿ë");
		Format.setComponent(new Point(0, 380), 235, 30, applyBtn);
		{
			MouseAdapter listener = new ApplyBtnMouseListener(textArea);
			applyBtn.addMouseListener(listener);	
		}
		add(applyBtn);
	}
	
	String getText() {
		return textArea.getText();
	}
}

