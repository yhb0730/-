package guiListener.MouseListener;

import java.awt.event.MouseAdapter;

import gui.*;

public class ChangeBtnMouseListener extends MouseAdapter{
	AttributeEditor attributeEditor;
	
	public ChangeBtnMouseListener(AttributeEditor attributeEditor){
		this.attributeEditor = attributeEditor;
	}
}
