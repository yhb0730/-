package guiListener.MouseListener.ChangeBtnMouseMethod;

import gui.AttributeEditor;

public class HeightChanger extends ChangeBtnMethod{

	public HeightChanger(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		int height = Integer.parseInt(getAttrEditor().getText(getNum()));
		getNodeLabel().setHeight(height);
	}
	
}
