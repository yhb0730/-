package guiListener.MouseListener;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import gui.AttributeEditor;
import gui.Constants;
import gui.NodeLabel;

public class TextFieldMouseListener extends MouseAdapter{
	NodeLabel nodeLabel;
	AttributeEditor attrEditor;
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(nodeLabel != null && attrEditor != null) {
			try {
				Color newColor = JColorChooser.showDialog(null, "Dialog Title", nodeLabel.getBackground());
				Color reverseColor =  new Color(255 - newColor.getRed(), 255 - newColor.getGreen(), 255 - newColor.getBlue());
				nodeLabel.setBackground(reverseColor);
				int red = newColor.getRed();
				int green = newColor.getGreen();
				int blue = newColor.getBlue();
				attrEditor.setText(AttributeEditor.COLOR_ATTR, "0x" + red + green + blue);
				attrEditor.setTextBackgroundColor(AttributeEditor.COLOR_ATTR, newColor);
				Constants.IS_CHANGED = true;
			}catch(NullPointerException exception) {
				;
			}
		}
	}

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
