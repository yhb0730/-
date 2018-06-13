package guiListener.MouseListener.ChangeBtnMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

public class HeightChanger extends ChangeBtnMethod{

	public HeightChanger(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		int height = Integer.parseInt(getAttrEditor().getText(getNum()));
		if(height < NodeLabel.OFFSET) {
			height = NodeLabel.OFFSET;
			super.getAttrEditor().setText(getNum(), Integer.toString(NodeLabel.OFFSET));
		}
		getNodeLabel().setHeight(height);
	}
	
}
