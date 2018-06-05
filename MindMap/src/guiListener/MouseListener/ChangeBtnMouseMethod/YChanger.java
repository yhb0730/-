package guiListener.MouseListener.ChangeBtnMouseMethod;

import gui.AttributeEditor;

public class YChanger extends ChangeBtnMethod{

	public YChanger(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		int x = getNodeLabel().getX();
		int y = Integer.parseInt(getAttrEditor().getText(getNum()));
		getNodeLabel().setLocation(x,y);
	}

}
