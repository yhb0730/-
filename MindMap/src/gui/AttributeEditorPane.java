package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;

import javax.swing.*;

import guiListener.MouseListener.ChangeBtnMouseListener;

public class AttributeEditorPane extends JPanel{
	private JButton title;
	private AttributeEditor attributeEditor;
	private JButton changeBtn;
	private MouseAdapter listener;
	
	AttributeEditorPane(){
		setLayout(null);
		
		title = new JButton("Attribute Pane");
		Constants.setComponent(new Point(0, 0), 235, 30, 20, title);
		title.setEnabled(false);
		add(title);
		
		attributeEditor = new AttributeEditor();
		Constants.setComponent(new Point(0, 30), 235, 480, attributeEditor);
		add(attributeEditor);
		
		changeBtn = new JButton("Change");
		Constants.setComponent(new Point(0, 515), 235, 30, changeBtn);
		add(changeBtn);
	}
	
	public void addMouseListener(MindMapEditor mindMapEditor) {
		listener = new ChangeBtnMouseListener(attributeEditor, mindMapEditor);
		changeBtn.addMouseListener(listener);
	}
	
	public MouseAdapter getMyMouseListener() {
		return listener;
	}
	
	public AttributeEditor getAttributeEditor() {
		return this.attributeEditor;
	}
	
	public JButton getChangeBtn() {
		return this.changeBtn;
	}
}
