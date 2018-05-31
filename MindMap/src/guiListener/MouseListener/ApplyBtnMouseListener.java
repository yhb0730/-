package guiListener.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import dataStructure.Tree;
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
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String[] parse = textArea.getText().split("\\n");
		if(textArea.getText() == null || textArea.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "잘못된 양식입니다.", "양식 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		boolean isMakeRight= mindMapEditor.makeTree(parse);
		if(isMakeRight)
			mindMapEditor.draw();
	}
}
