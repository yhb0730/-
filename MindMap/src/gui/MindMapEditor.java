package gui;

import java.awt.*;
import javax.swing.*;

import dataStructure.Node;
import dataStructure.Tree;

public class MindMapEditor extends JScrollPane {
	private JPanel panel;
	private Tree head;
	
	MindMapEditor(){
		panel = new JPanel();
		panel.setLayout(null);
		this.getViewport().add(panel);
	}
	
}
