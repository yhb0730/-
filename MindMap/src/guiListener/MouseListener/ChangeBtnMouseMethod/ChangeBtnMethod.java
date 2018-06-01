package guiListener.MouseListener.ChangeBtnMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

abstract public class ChangeBtnMethod {
	private int num;
	private NodeLabel nodeLabel;
	private AttributeEditor attrEditor;
	
	public ChangeBtnMethod(int num, AttributeEditor attrEditor) {
		this.num = num;
		this.nodeLabel = attrEditor.getNodeLabel();
		this.attrEditor = attrEditor;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	abstract public void change();

	public NodeLabel getNodeLabel() {
		return nodeLabel;
	}

	public void setNodeLabel(NodeLabel nodeLabel) {
		this.nodeLabel = nodeLabel;
	}

	public AttributeEditor getAttrEditor() {
		return attrEditor;
	}

	public void setAttrEditor(AttributeEditor attrEditor) {
		this.attrEditor = attrEditor;
	}
}
