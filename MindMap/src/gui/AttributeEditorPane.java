package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;

import javax.swing.*;

import guiListener.MouseListener.ChangeBtnMouseListener;

public class AttributeEditorPane extends JPanel{
	private JButton title;
	private AttributeEditor attributeEditor;
	private JButton changeBtn;
	
	AttributeEditorPane(){
		setLayout(null);
		
		title = new JButton("Attribute Pane");
		Format.setComponent(new Point(0, 0), 235, 30, 20, title);
		title.setEnabled(false);
		add(title);
		
		attributeEditor = new AttributeEditor();
		Format.setComponent(new Point(0, 30), 235, 350, attributeEditor);
		add(attributeEditor);
		
		changeBtn = new JButton("º¯°æ");
		{
			MouseAdapter listener = new ChangeBtnMouseListener(attributeEditor);
			changeBtn.addMouseListener(listener);
		}
		Format.setComponent(new Point(0, 380), 235, 30, changeBtn);
		add(changeBtn);
	}
}
