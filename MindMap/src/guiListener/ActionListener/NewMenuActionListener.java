package guiListener.ActionListener;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.*;

public class NewMenuActionListener extends OptionActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AttributeEditor attrEditor = super.getAttrEditor().getAttributeEditor();
		MindMapEditorPane mindMapEditor = super.getMindMapEditor();
		TextEditorPane textEditor = super.getTextEditor();
		textEditor.setText(null);
		mindMapEditor.getMindMapEditor().removeAllLabel();
		for(int i=0; i < AttributeEditor.ATTRIBUTE_NUM; ++i) {
			attrEditor.setText(i, null);
		}
		attrEditor.setTextBackgroundColor(AttributeEditor.COLOR_ATTR, Color.WHITE);
		attrEditor.setNodeLabel(null);
		Constants.IS_CHANGED = false;
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
