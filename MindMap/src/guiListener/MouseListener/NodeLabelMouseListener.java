package guiListener.MouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import NodeLabelMouseMethod.*;
import gui.AttributeEditor;
import gui.NodeLabel;

public class NodeLabelMouseListener extends MouseAdapter{
	private NodeLabel nodeLabel;
	private AttributeEditor attrEditor;
	
	public NodeLabelMouseListener(NodeLabel nodeLabel, AttributeEditor attrEditor){
		this.nodeLabel = nodeLabel;
		this.attrEditor = attrEditor;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		NodeMouseMethod[] method = new NodeMouseMethod[] {
				new TextWrapper(0, nodeLabel, attrEditor),
				new XWrapper(1, nodeLabel, attrEditor),
				new YWrapper(2, nodeLabel, attrEditor),
				new WidthWrapper(3, nodeLabel, attrEditor),
				new HeightWrapper(4, nodeLabel, attrEditor),
				new ColorWrapper(5, nodeLabel, attrEditor)};
		
		if(method.length != attrEditor.getLength()) {
			System.out.println("NodeMethod와  attributeEditor의 갯수가 안 맞습니다. 코드 변경 필요");
			return;
		}
		
		attrEditor.setNodeLabel(nodeLabel);
		for(int i=0; i < method.length; ++i) {
			method[i].write();
		}
	}
}
