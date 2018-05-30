package guiListener.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import dataStructure.Tree;
import gui.TextArea;

public class ApplyBtnMouseListener extends MouseAdapter{
	TextArea textArea;
	//TO DO : MindMap쪽에 그려야 하니 그거 받아와야함
	
	public ApplyBtnMouseListener(TextArea textArea){
		this.textArea = textArea;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String[] parse = textArea.getText().split("\\n");
		if(textArea.getText() == null || textArea.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "잘못된 양식입니다.", "양식 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

}
