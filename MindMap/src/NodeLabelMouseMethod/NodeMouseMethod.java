package NodeLabelMouseMethod;

import gui.AttributeEditor;
import gui.NodeLabel;

abstract public class NodeMouseMethod {
	private int num;
	private NodeLabel nodeLabel;
	private AttributeEditor attrEditor;
	
	public NodeMouseMethod(int num, AttributeEditor attrEditor) {
		this.num = num;
		this.nodeLabel = attrEditor.getNodeLabel();
		this.attrEditor = attrEditor;
	}
	
	abstract public void write();

	int getNum() {
		return num;
	}
	
	void setNum(int num) {
		this.num = num;
	}
	
	NodeLabel getNodeLabel() {
		return nodeLabel;
	}

	void setNodeLabel(NodeLabel nodeLabel) {
		this.nodeLabel = nodeLabel;
	}

	AttributeEditor getAttrEditor() {
		return attrEditor;
	}

	void setAttrEditor(AttributeEditor attrEditor) {
		this.attrEditor = attrEditor;
	}

	
}
