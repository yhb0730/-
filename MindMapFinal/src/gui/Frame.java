package gui;

import java.awt.*;
import javax.swing.*;

import org.json.simple.JSONObject;

public class Frame extends JFrame{
	private MenuBar menubar;
	private ToolBar toolbar;
	private TextEditorPane textEditor;
	private MindMapEditorPane mindMapEditor;
	private AttributeEditorPane attributeEditor;
	private JSplitPane leftSplit;
	private JSplitPane rightSplit;
	
	public static JSONObject obj = null;
	
	public Frame() {
		setTitle("MindMap Application v0.01");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(null);
		
		attributeEditor = new AttributeEditorPane();
		mindMapEditor = new MindMapEditorPane(attributeEditor.getAttributeEditor());
		attributeEditor.addMouseListener(mindMapEditor.getMindMapEditor());
		mindMapEditor.setMinimumSize(new Dimension(200, 100));
		attributeEditor.setMinimumSize(new Dimension(100, 100));
		rightSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mindMapEditor, attributeEditor);
		Constants.setComponent(new Point(250, 100), 900, 550, rightSplit);
		rightSplit.getLeftComponent().setPreferredSize(new Dimension(650, 500));
		rightSplit.setEnabled(false);
		add(rightSplit);
		
		textEditor = new TextEditorPane(mindMapEditor);
		leftSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, textEditor, null);
		leftSplit.setEnabled(false);
		Constants.setComponent(new Point(0, 100), 250,  550, leftSplit);
		add(leftSplit);
		
		menubar = new MenuBar();
		menubar.setTextEditor(textEditor);
		menubar.setMindMapEditor(mindMapEditor);
		menubar.setAttrEditor(attributeEditor);
		menubar.init();
		this.setJMenuBar(menubar.getMenu());
		
		toolbar = new ToolBar();
		toolbar.setTextEditor(textEditor);
		toolbar.setMindMapEditor(mindMapEditor);
		toolbar.setAttrEditor(attributeEditor);
		toolbar.init();
		
		JPanel toolPanel = toolbar.getToolBarPanel();
		Constants.setComponent(new Point(0, 0), Constants.FRAME_X_SIZE - 650, 50, toolPanel);
		container.add(toolPanel, BorderLayout.PAGE_START);
		
		setSize(Constants.FRAME_X_SIZE, Constants.FRAME_Y_SIZE);
		setVisible(true);
	}
}
