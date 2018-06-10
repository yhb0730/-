package gui;

import java.awt.event.ActionListener;
import javax.swing.*;

import guiListener.ActionListener.*;

public class MenuBar extends OptionBar{
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem[] menuItem;
	
	void init() {
		menubar = new JMenuBar();
		menu = new JMenu("Options");
		menuItem = new JMenuItem[OptionBar.OPTION_NUM];
		for(int i=0; i < OptionBar.OPTION_NUM; ++i) {
			OptionActionListener listener = super.getListener(i);
			listener.setTextEditor(super.getTextEditor());
			listener.setMindMapEditor(super.getMindMapEditor());
			listener.setAttrEditor(super.getAttrEditor());
			menuItem[i] = new JMenuItem(super.getOptionName(i));
			menuItem[i].addActionListener(listener);
			menu.add(menuItem[i]);
		}
		menubar.add(menu);
	}
	
	JMenuBar getMenu() {
		return menubar;
	}
}
