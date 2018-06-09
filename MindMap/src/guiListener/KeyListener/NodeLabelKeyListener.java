package guiListener.KeyListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import gui.AttributeEditor;
import guiListener.MouseListener.NodeLabelMouseListener;

public class NodeLabelKeyListener extends KeyAdapter {
	private AttributeEditor attrEditor;
	
	NodeLabelKeyListener(AttributeEditor attrEditor){
		this.attrEditor = attrEditor;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//NodeLabelMouseListener mListener = new NodeLabelMouseListener(attrEditor);
		//이건 좀 생각을 해봐야될듯. 넣는게 좋은 생각인지 모르겠다.
		//keyReleased(e);
	}
}
