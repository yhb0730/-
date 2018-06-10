package guiListener.MouseListener.ChangeBtnMouseMethod;

import java.awt.Color;

import gui.AttributeEditor;

public class ColorChanger extends ChangeBtnMethod{
	Color color;
	
	
	public ColorChanger(int num, AttributeEditor attrEditor) {
		super(num, attrEditor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		//getNodeLabel().setBackground(color);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
}
