package guiListener.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import NodeLabelMouseMethod.*;
import gui.AttributeEditor;
import gui.Constants;
import gui.NodeLabel;

public class NodeLabelMouseListener extends MouseAdapter{
	private NodeLabel nodeLabel;
	private AttributeEditor attrEditor;
	private NodeMouseMethod[] method;
	
	public NodeLabelMouseListener(NodeLabel nodeLabel, AttributeEditor attrEditor){
		this.nodeLabel = nodeLabel;
		this.attrEditor = attrEditor;
		method = new NodeMouseMethod[] {
				 new TextWrapper(Constants.TEXT_ATTRIBUTE, attrEditor),
				 new XWrapper(Constants.X_ATTRIBUTE, attrEditor),
				 new YWrapper(Constants.Y_ATTRIBUTE, attrEditor),
				 new WidthWrapper(Constants.WIDTH_ATTRIBUTE, attrEditor),
				 new HeightWrapper(Constants.HEIGHT_ATTRIBUTE, attrEditor),
				 new ColorWrapper(Constants.COLOR_ATTRIBUTE, attrEditor)};
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(method.length != attrEditor.getLength()) {
			System.out.println("NodeMethod와  attributeEditor의 갯수가 안 맞습니다. 코드 변경 필요");
			return;
		}
		attrEditor.setNodeLabel((NodeLabel)e.getSource());
		//attrEditor.setNodeLabel(nodeLabel);
		for(int i=0; i < method.length; ++i) {
			method[i].write();
		}
	}
}
