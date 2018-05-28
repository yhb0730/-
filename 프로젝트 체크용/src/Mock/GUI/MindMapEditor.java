package Mock.GUI;

import java.awt.*;
import javax.swing.*;

public class MindMapEditor extends JScrollPane{
	JPanel panel;
	MindMapEditor(){
		panel = new JPanel();
		panel.setLayout(null);
		this.getViewport().add(panel, null);
		addNode("?");
	}
	
	void addNode(String s) {
		JLabel label = new JLabel(s);
		label.setLocation(100, 200);
		label.setSize(100, 200);
		panel.add(label);
		
	}
}
