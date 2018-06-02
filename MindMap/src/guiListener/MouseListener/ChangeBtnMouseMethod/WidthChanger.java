package guiListener.MouseListener.ChangeBtnMouseMethod;

import java.awt.Point;

import gui.AttributeEditor;
import gui.NodeLabel;

public class WidthChanger extends ChangeBtnMethod{

	public WidthChanger(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		int width = Integer.parseInt(getAttrEditor().getText(getNum()));
		getNodeLabel().setWidth(width);
	}

}
