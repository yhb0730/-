package guiListener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

import gui.*;

public class CloseOptionActionListener extends OptionActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(Constants.IS_CHANGED) {
			int input = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "종료 확인", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
			if(input == 0) { //yes
				System.exit(0);
			}
		}
		else
			System.exit(0);
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
