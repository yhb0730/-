package NodeLabelMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

public class TextWrapper extends NodeMouseMethod{
	public TextWrapper(int num, NodeLabel nodeLabel, AttributeEditor attrEditor) {
		super(num, nodeLabel, attrEditor);
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		getAttrEditor().setText(getNum(), getNodeLabel().getNode().getString());
	}
	
}
