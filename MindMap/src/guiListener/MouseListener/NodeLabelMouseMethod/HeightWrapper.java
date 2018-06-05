package guiListener.MouseListener.NodeLabelMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

public class HeightWrapper extends NodeMouseMethod{
	public HeightWrapper(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		getAttrEditor().setText(getNum(), Integer.toString(getNodeLabel().getHeight()));
	}
}
