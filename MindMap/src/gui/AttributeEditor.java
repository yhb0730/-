package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import javax.swing.*;

import guiListener.MouseListener.TextFieldMouseListener;

//이거 관련된 곳에서 num을 뻈음 문제 생기면 그거 볼것

public class AttributeEditor extends JScrollPane {
	final public static int COLOR_ATTR= 5;
	final public static int ATTRIBUTE_NUM = 6;
	private String[] attributeName = new String[] {"TEXT", "X", "Y", "W", "H", "Color"};
	private JPanel panel;
	private AttributeSet[] set;
	private NodeLabel nodeLabel;
	
	AttributeEditor(){
		panel = new JPanel();
		panel.setLayout(null);
		set = new AttributeSet[attributeName.length];
		for(int i=0; i < attributeName.length; ++i) {
			set[i] = new AttributeSet(i, 10, attributeName[i]);
			Constants.setComponent(new Point(5, i * 50), 200, 60, set[i]);
			panel.add(set[i]);
		}
		set[COLOR_ATTR].setAttrEditor(this);
		this.getViewport().add(panel);
	}
		
	public int getLength() {
		return attributeName.length;
	}
	
	public String getText(int num) {
		return set[num].getText();
	}
	
	public void setText(int num, String str) {
		set[num].setText(str);
	}
	
	public void setTextBackgroundColor(int num, Color color) {
		set[num].setTextBackgroundColor(color);
	}
	
	public NodeLabel getNodeLabel() {
		return nodeLabel;
	}
	
	public void setNodeLabel(NodeLabel nodeLabel) {
		this.nodeLabel = nodeLabel;
		set[COLOR_ATTR].setNodeLabel(nodeLabel);
	}
	
	class AttributeSet extends JPanel{
		private int num;
		private JLabel name;
		private JTextField textField;
		private TextFieldMouseListener listener;
		
		private AttributeSet(int num, int size, String name){
			this.num = num;
			this.name = new JLabel(name, SwingConstants.LEFT);
			textField = new JTextField(size);
			if(num == 0) {
				textField.setEditable(false);
			}
			if(name.equals("Color")){
				listener = new TextFieldMouseListener();
				textField.addMouseListener(listener);
			}
			add(this.name);
			add(textField);
		}

		public String getText() {
			return textField.getText();
		}

		public void setText(String str) {
			textField.setText(str);
		}
		
		public void setNodeLabel(NodeLabel nodeLabel) {
			listener.setNodeLabel(nodeLabel);
		}
		
		public void setAttrEditor(AttributeEditor attrEditor) {
			listener.setAttrEditor(attrEditor);
		}
		
		public void setTextBackgroundColor(Color color) {
			textField.setBackground(color);
		}
	}
}
