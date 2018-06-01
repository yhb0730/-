package NodeLabelMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

public class WidthWrapper extends NodeMouseMethod{
	public WidthWrapper(int num, NodeLabel nodeLabel, AttributeEditor attrEditor) {
		super(num, nodeLabel, attrEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		getAttrEditor().setText(getNum(), Integer.toString(getNodeLabel().getWidth()));
	}	
	
}
