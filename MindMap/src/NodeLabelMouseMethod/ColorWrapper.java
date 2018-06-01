package NodeLabelMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

public class ColorWrapper extends NodeMouseMethod{
	public ColorWrapper(int num, NodeLabel nodeLabel, AttributeEditor attrEditor) {
		super(num, nodeLabel, attrEditor);
	}
	
	@Override
	public void write() {
		String red = Integer.toString(getNodeLabel().getBackground().getRed());
		String green = Integer.toString(getNodeLabel().getBackground().getGreen());
		String blue = Integer.toString(getNodeLabel().getBackground().getBlue());
		getAttrEditor().setText(getNum(), "0x" + red + green + blue);
	}
}
