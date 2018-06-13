package guiListener.MouseListener.ChangeBtnMouseMethod;

import gui.AttributeEditor;
import gui.Constants;

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
		if(y < 0 || y >= Constants.SCROLL_Y_SIZE) {
			super.getAttrEditor().setText(getNum(), Integer.toString(getNodeLabel().getLocation().y));
			return ;
		}
		getNodeLabel().setLocation(x,y);
	}

}
