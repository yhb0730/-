package guiListener.MouseListener.NodeLabelMouseMethod;

import java.awt.Color;

import gui.AttributeEditor;

public class ColorWrapper extends NodeMouseMethod{
	public ColorWrapper(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
	}
	
	@Override
	public void write() {
		int red = getNodeLabel().getBackground().getRed();
		int green = getNodeLabel().getBackground().getGreen();
		int blue = getNodeLabel().getBackground().getBlue();
		
		String redString = Integer.toString(red);
		String greenString = Integer.toString(getNodeLabel().getBackground().getGreen());
		String blueString = Integer.toString(getNodeLabel().getBackground().getBlue());
		getAttrEditor().setText(getNum(), "0x" + redString + greenString + blueString);
		getAttrEditor().setTextBackgroundColor(AttributeEditor.COLOR_ATTR, new Color(255 - red, 255 - green, 255 - blue)); //이미 바뀐 뒤에 실행되는거라 반전 시켜줘야함
	}
}
