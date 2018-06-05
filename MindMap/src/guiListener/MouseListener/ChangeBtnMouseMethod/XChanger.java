package guiListener.MouseListener.ChangeBtnMouseMethod;

import gui.AttributeEditor;

public class XChanger extends ChangeBtnMethod{

	public XChanger(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		int x = Integer.parseInt(getAttrEditor().getText(getNum()));
		int y = this.getNodeLabel().getY();
		getNodeLabel().setLocation(x, y);
	}
	
}
