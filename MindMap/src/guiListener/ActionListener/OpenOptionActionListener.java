package guiListener.ActionListener;

import java.awt.event.ActionEvent;

import dataStructure.JsonNode;
import gui.*;

public class OpenOptionActionListener extends OptionActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		//json 파일을 읽어와서 Frame.obj를 대체해야한다.
		JsonNode.readJsonNode(Frame.obj);
		super.getTextEditor().setJsonText(); //정상작동 확인
		super.getMindMapEditor().getMindMapEditor().drawJson(Frame.obj);
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
