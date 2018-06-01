package NodeLabelMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

public class HeightWrapper extends NodeMouseMethod{
	public HeightWrapper(int num, NodeLabel nodeLabel, AttributeEditor attrEditor) {
		super(num, nodeLabel, attrEditor);
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		getAttrEditor().setText(getNum(), Integer.toString(getNodeLabel().getHeight()));
	}
}
