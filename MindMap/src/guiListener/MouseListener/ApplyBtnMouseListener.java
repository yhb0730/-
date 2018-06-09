package guiListener.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;


import dataStructure.NodeManager;
import gui.Constants;
import gui.MindMapEditor;
import gui.MindMapEditorPane;
import gui.TextArea;

public class ApplyBtnMouseListener extends MouseAdapter{
	TextArea textArea;
	MindMapEditorPane mindMapEditor;
	
	public ApplyBtnMouseListener(TextArea textArea, MindMapEditorPane mindMapEditor){
		this.textArea = textArea;
		this.mindMapEditor = mindMapEditor;
	}
	
	//attributeSet을 초기화 해야되는가에 대한 문제점이 존재
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() != MouseEvent.BUTTON1)
			return ;
		
		String[] parse = textArea.getText().split("\\n");
		if(textArea.getText() == null || textArea.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "잘못된 양식입니다.", "양식 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(mindMapEditor.makeTree(parse)) {
			Constants.IS_CHANGED = true;
			mindMapEditor.draw();
		}
		else
			JOptionPane.showMessageDialog(null, "MindMap이 생성되지 않았습니다.", "양식 오류", JOptionPane.ERROR_MESSAGE);
	}
}
