package guiListener.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;


import gui.Constants;
import gui.MindMapEditorPane;
import gui.TextArea;

public class ApplyBtnMouseListener extends MouseAdapter{
	TextArea textArea;
	MindMapEditorPane mindMapEditor;
	
	public ApplyBtnMouseListener(TextArea textArea, MindMapEditorPane mindMapEditor){
		this.textArea = textArea;
		this.mindMapEditor = mindMapEditor;
	}
	
	//attributeSet�� �ʱ�ȭ �ؾߵǴ°��� ���� �������� ����
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() != MouseEvent.BUTTON1)
			return ;
		
		String[] parse = textArea.getText().split("\\n");
		if(textArea.getText() == null || textArea.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�߸��� ����Դϴ�.", "��� ����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(mindMapEditor.makeTree(parse)) {
			Constants.IS_CHANGED = true;
			mindMapEditor.draw();
		}
		else
			JOptionPane.showMessageDialog(null, "MindMap�� �������� �ʾҽ��ϴ�.", "��� ����", JOptionPane.ERROR_MESSAGE);
	}
}
