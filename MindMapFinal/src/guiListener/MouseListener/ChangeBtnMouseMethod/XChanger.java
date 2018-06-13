package guiListener.MouseListener.ChangeBtnMouseMethod;

import gui.AttributeEditor;
import gui.Constants;

public class XChanger extends ChangeBtnMethod{

	public XChanger(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		int x = Integer.parseInt(getAttrEditor().getText(getNum()));
		if(x < 0 || x >= Constants.SCROLL_X_SIZE) {
			super.getAttrEditor().setText(getNum(), Integer.toString(getNodeLabel().getLocation().x));
			return ;
		}
		int y = this.getNodeLabel().getY();
		getNodeLabel().setLocation(x, y);
	}
	
}
