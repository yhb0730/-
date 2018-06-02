package NodeLabelMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

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
