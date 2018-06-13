package guiListener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import gui.*;

public class ChangeOptionActionListener extends OptionActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		AttributeEditorPane attrEditor = super.getAttrEditor();
		Constants.IS_CHANGED = true;
		JButton btn = attrEditor.getChangeBtn();
		MouseEvent e = new MouseEvent(btn, 0, 0, 0, 0, 0, 0, false, MouseEvent.BUTTON1);
		attrEditor.getMyMouseListener().mouseClicked(e);
	}
	
	@Override
	public TextEditorPane getTextEditor() {
		return super.getTextEditor();
	}

	@Override
	public void setTextEditor(TextEditorPane textEditor) {
		super.setTextEditor(textEditor);
	}

	@Override
	public MindMapEditorPane getMindMapEditor() {
		return super.getMindMapEditor();
	}

	@Override
	public void setMindMapEditor(MindMapEditorPane mindMapEditor) {
		super.setMindMapEditor(mindMapEditor);
	}

	@Override
	public AttributeEditorPane getAttrEditor() {
		return super.getAttrEditor();
	}

	@Override
	public void setAttrEditor(AttributeEditorPane attrEditor) {
		super.setAttrEditor(attrEditor);
	}

}
