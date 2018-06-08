package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import guiListener.ActionListener.*;

public class ToolBar extends OptionBar{
	private JPanel panel;
	final private JToolBar toolbar = new JToolBar();
	private JButton[] toolBtn;
	
	@Override
	void init() {
		// TODO Auto-generated method stub
		panel = new JPanel();
		toolBtn = new JButton[super.OPTION_NUM];
		for(int i=0; i < super.OPTION_NUM; ++i) {
			OptionActionListener listener = super.getListener(i);
			listener.setTextEditor(super.getTextEditor());
			listener.setMindMapEditor(super.getMindMapEditor());
			listener.setAttrEditor(super.getAttrEditor());
			toolBtn[i] = new JButton(super.getOptionName(i));
			toolBtn[i].addActionListener(listener);
			toolbar.add(toolBtn[i]);
			toolbar.addSeparator();
		}
		toolbar.setFloatable(false);
		panel.add(toolbar);
	}
	
	JToolBar getToolBar() {
		return toolbar;
	}
	
	JPanel getToolBarPanel(){
		return panel;
	}
}
