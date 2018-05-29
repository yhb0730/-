package Stack;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
	TextPane textPane;
	MindMapPane mindMap;
	
	Frame(){
		setTitle("Stack ¿¬½À");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
	
		mindMap = new MindMapPane();
		
		textPane = new TextPane(mindMap);
		//textPane.setLocation(0, 0);
		//textPane.setSize(800, 500);
		//add(textPane);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, textPane, mindMap);
		split.setLocation(0, 0);
		split.setSize(1000, 600);
		add(split);
		
		setSize(1000, 600);
		setVisible(true);
	}
}
