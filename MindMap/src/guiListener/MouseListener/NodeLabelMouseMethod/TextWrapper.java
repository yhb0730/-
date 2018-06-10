package guiListener.MouseListener.NodeLabelMouseMethod;

import gui.AttributeEditor;

public class TextWrapper extends NodeMouseMethod{
	public TextWrapper(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		getAttrEditor().setText(getNum(), getNodeLabel().getNode().getString());
	}
	
}
