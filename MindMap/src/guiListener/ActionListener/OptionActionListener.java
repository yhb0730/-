package guiListener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.*;

public class OptionActionListener implements ActionListener {
	private TextEditorPane textEditor;
	private MindMapEditorPane mindMapEditor;
	private AttributeEditorPane attrEditor;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public TextEditorPane getTextEditor() {
		return textEditor;
	}

	public void setTextEditor(TextEditorPane textEditor) {
		this.textEditor = textEditor;
	}

	public MindMapEditorPane getMindMapEditor() {
		return mindMapEditor;
	}

	public void setMindMapEditor(MindMapEditorPane mindMapEditor) {
		this.mindMapEditor = mindMapEditor;
	}

	public AttributeEditorPane getAttrEditor() {
		return attrEditor;
	}

	public void setAttrEditor(AttributeEditorPane attrEditor) {
		this.attrEditor = attrEditor;
	}
	
	
}
