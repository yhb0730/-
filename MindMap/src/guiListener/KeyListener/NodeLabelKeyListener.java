package guiListener.KeyListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import gui.AttributeEditor;

public class NodeLabelKeyListener extends KeyAdapter {
	private AttributeEditor attrEditor;
	
	NodeLabelKeyListener(AttributeEditor attrEditor){
		this.attrEditor = attrEditor;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//NodeLabelMouseListener mListener = new NodeLabelMouseListener(attrEditor);
		//�̰� �� ������ �غ��ߵɵ�. �ִ°� ���� �������� �𸣰ڴ�.
		//keyReleased(e);
	}
}
