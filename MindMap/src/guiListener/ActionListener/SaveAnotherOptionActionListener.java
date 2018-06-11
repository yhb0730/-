package guiListener.ActionListener;

import java.awt.event.ActionEvent;

import gui.*;
import mindMapUtil.FileManipulator;

public class SaveAnotherOptionActionListener extends OptionActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FileManipulator file = new FileManipulator();
		file.save();
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
