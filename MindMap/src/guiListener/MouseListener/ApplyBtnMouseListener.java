package guiListener.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import dataStructure.Tree;
import gui.TextArea;

public class ApplyBtnMouseListener extends MouseAdapter{
	TextArea textArea;
	//TO DO : MindMap�ʿ� �׷��� �ϴ� �װ� �޾ƿ;���
	
	public ApplyBtnMouseListener(TextArea textArea){
		this.textArea = textArea;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String[] parse = textArea.getText().split("\\n");
		if(textArea.getText() == null || textArea.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�߸��� ����Դϴ�.", "��� ����", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

}
