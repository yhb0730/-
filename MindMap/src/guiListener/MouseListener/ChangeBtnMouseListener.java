package guiListener.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui.*;
import guiListener.MouseListener.ChangeBtnMouseMethod.*;

public class ChangeBtnMouseListener extends MouseAdapter{
	private AttributeEditor attributeEditor;
	private MindMapEditor mindMapEditor;
	private ChangeBtnMethod[] method;
	
	public ChangeBtnMouseListener(AttributeEditor attributeEditor, MindMapEditor mindMapEditor){
		this.attributeEditor = attributeEditor;
		this.mindMapEditor = mindMapEditor;
		method = new ChangeBtnMethod[]{
				 new XChanger(Constants.X_ATTRIBUTE, attributeEditor),
				 new YChanger(Constants.Y_ATTRIBUTE, attributeEditor),
				 new WidthChanger(Constants.WIDTH_ATTRIBUTE, attributeEditor),
				 new HeightChanger(Constants.HEIGHT_ATTRIBUTE, attributeEditor),
				 new ColorChanger(Constants.COLOR_ATTRIBUTE, attributeEditor)
		};
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i < method.length; ++i) {
			method[i].change();
		}
		mindMapEditor.repaintUI();
	}
}
