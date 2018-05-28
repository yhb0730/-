package JTool;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
	Frame(){
		setTitle("Toolbar test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JToolBar tool = new JToolBar("Tool");
		JButton button = new JButton("add");
		add(tool);
		tool.add(button);
		setSize(300, 300);
		setVisible(true);
	}
}
