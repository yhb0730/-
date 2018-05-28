package Mock.GUI;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
	JMenuBar menuBar;
	TextEditorPanel textEditor;
	MindMapEditorPanel MindMapEditor;
	AttributeEditorPanel AttributeEditor;
	ToolBar tool;
	
	public Frame(){
		setTitle("Mocking");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(null);
	
		menuBar = new JMenuBar();
		menuBar.setLocation(0,0);
		menuBar.setSize(1000, 30);
		JMenu file = new JMenu("File");
		file.add(new JMenuItem("open"));
		menuBar.add(file);
		JMenu edit = new JMenu("Edit");
		edit.add(new JMenuItem("Copy"));
		menuBar.add(edit);
		add(menuBar);
		
		tool = new ToolBar();
		tool.setSize(100, 40);
		tool.setLocation(0, 30);
		add(tool);
		
		textEditor = new TextEditorPanel();
		JSplitPane leftSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, textEditor, null);
		leftSplit.setLocation(0, 100);
		leftSplit.setSize(250, 420);
		add(leftSplit);
		
		MindMapEditor = new MindMapEditorPanel(); 
		AttributeEditor = new AttributeEditorPanel();
		MindMapEditor.setMinimumSize(new Dimension(200, 100));
		AttributeEditor.setMinimumSize(new Dimension(100, 100)); //??? 왜 그냥은 작동 안하고 미니멈으로만 작동하냐고
		JSplitPane rightSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, MindMapEditor, AttributeEditor);
		rightSplit.setLocation(250, 100);
		rightSplit.setSize(700, 420);
		//rightSplit.getRightComponent().setPreferredSize(new Dimension(200, 300));;
		rightSplit.getLeftComponent().setPreferredSize(new Dimension(450, 400));
		add(rightSplit);
		
		setSize(1000, 600);
		setVisible(true);
	}
}
