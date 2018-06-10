package guiListener.MouseListener;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import gui.AttributeEditor;
import gui.Constants;
import gui.NodeLabel;
import guiListener.MouseListener.ChangeBtnMouseMethod.ColorChanger;

public class TextFieldMouseListener extends MouseAdapter{
	NodeLabel nodeLabel;
	AttributeEditor attrEditor;
	ColorChanger colorChanger;
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(nodeLabel != null && attrEditor != null) {
			try {
				Color newColor = JColorChooser.showDialog(null, "Dialog Title", nodeLabel.getBackground());
				int red = newColor.getRed();
				int green = newColor.getGreen();
				int blue = newColor.getBlue();
				Color reverseColor = new Color(255 - red, 255 - green, 255 - blue);
				nodeLabel.setBackground(reverseColor);
				attrEditor.setText(AttributeEditor.COLOR_ATTR, "0x" + red + green + blue);
				attrEditor.setTextBackgroundColor(AttributeEditor.COLOR_ATTR, newColor);
				//colorChanger.setColor(reverseColor);
				Constants.IS_CHANGED = true;
			}catch(NullPointerException exception) {
				;
			}
		}
	}
	
	public void setColorChanger(ColorChanger colorChanger) {
		this.colorChanger = colorChanger;
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
