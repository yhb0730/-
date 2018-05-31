package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import javax.swing.*;

public class AttributeEditor extends JScrollPane {
	private String[] attributeName = new String[] {"TEXT", "X", "W", "H", "Color"};
	private MouseAdapter[] adapter = new MouseAdapter[] {null, null, null, null, null};
	private JPanel panel;
	private AttributeSet[] set;
	
	AttributeEditor(){
		panel = new JPanel();
		panel.setLayout(null);
		set = new AttributeSet[attributeName.length];
		for(int i=0; i < attributeName.length; ++i) {
			set[i] = new AttributeSet(i, 10, attributeName[i]);
			Constants.setComponent(new Point(5, i * 50), 200, 60, set[i]);
			set[i].addListener(adapter[i]);
			panel.add(set[i]);
		}
		this.getViewport().add(panel);
	}
	
	class AttributeSet extends JPanel{
		private int num;
		private JLabel name;
		private JTextField textField;
		
		private AttributeSet(int num, int size, String name){
			this.num = num;
			this.name = new JLabel(name, SwingConstants.LEFT);
			this.textField = new JTextField(size);
			if(num == 0) {
				textField.setEditable(false);
			}
			add(this.name);
			add(this.textField);
		}
		
		private void addListener(MouseAdapter listener) {
			textField.addMouseListener(listener);
		}

		public String getText() {
			return textField.getText();
		}

		public void setText(String str) {
			textField.setText(str);
		}
	}
}
