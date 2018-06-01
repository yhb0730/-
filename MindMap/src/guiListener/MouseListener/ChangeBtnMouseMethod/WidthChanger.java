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
		int x = Integer.parseInt(getAttrEditor().getText(getNum()));
		int y = getNodeLabel().getLocation().y;
		getNodeLabel().setNodeSize(new Point(x, y));
	}

}
