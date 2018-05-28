package Mock.GUI;

import java.awt.*;
import javax.swing.*;

public class AttributeEditor extends JScrollPane{
	JPanel panel;
	String[] attribute = new String[] {"TEXT", "X", "W", "H", "Color"};
	JLabel[] name;
	JTextField[] textField;
	
	AttributeEditor(){
		panel = new JPanel();
		panel.setLayout(null);
		
		name = new JLabel[attribute.length];
		textField = new JTextField[attribute.length];
		
		for(int i=0; i < attribute.length; ++i) {
			name[i] = new JLabel(attribute[i] + ":");
			textField[i]= new JTextField();
			
			name[i].setLocation(5, i * 50);
			name[i].setSize(100, 30);
			textField[i].setLocation(100, i * 50);
			textField[i].setSize(100, 30);
			panel.add(name[i]);
			panel.add(textField[i]);
			
		}
		textField[0].setEditable(false);
		
		this.getViewport().add(panel, null);
	}
}
