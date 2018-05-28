package Mock.GUI;

import java.awt.*;
import javax.swing.*;

public class ToolBar extends JPanel{
	JToolBar toolBar;
	
	ToolBar(){
		toolBar = new JToolBar("Tool Bar");
		JButton save = new JButton("save");
		JButton load = new JButton("load");
		toolBar.add(save);
		toolBar.add(load);
		add(toolBar);
	}
}
