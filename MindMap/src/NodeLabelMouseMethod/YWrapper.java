package NodeLabelMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

public class YWrapper extends NodeMouseMethod{

	public YWrapper(int num, NodeLabel nodeLabel, AttributeEditor attrEditor) {
		super(num, nodeLabel, attrEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		getAttrEditor().setText(getNum(), Integer.toString(getNodeLabel().getLocation().y));
	}
}
