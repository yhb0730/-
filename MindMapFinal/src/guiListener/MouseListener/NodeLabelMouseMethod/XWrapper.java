package guiListener.MouseListener.NodeLabelMouseMethod;

import gui.AttributeEditor;

public class XWrapper extends NodeMouseMethod{

	public XWrapper(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		getAttrEditor().setText(getNum(), Integer.toString(getNodeLabel().getLocation().x));
	}

	
}
