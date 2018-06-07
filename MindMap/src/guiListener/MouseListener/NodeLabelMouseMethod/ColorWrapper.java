package guiListener.MouseListener.NodeLabelMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

public class ColorWrapper extends NodeMouseMethod{
	public ColorWrapper(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
	}
	
	@Override
	public void write() {
		String red = Integer.toString(getNodeLabel().getBackground().getRed());
		String green = Integer.toString(getNodeLabel().getBackground().getGreen());
		String blue = Integer.toString(getNodeLabel().getBackground().getBlue());
		getAttrEditor().setText(getNum(), "0x" + red + green + blue);
		getAttrEditor().setTextBackgroundColor(AttributeEditor.COLOR_ATTR, getNodeLabel().getBackground());
	}
}
