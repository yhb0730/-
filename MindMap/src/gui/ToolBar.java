package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import guiListener.ActionListener.*;

public class ToolBar extends OptionBar{
	private JPanel panel;
	final private JToolBar toolbar = new JToolBar();
	private JButton[] toolBtn;
	private Image[] btnImage;;
	
	@Override
	void init() {
		// TODO Auto-generated method stub
		imageInit();
		panel = new JPanel();
		toolBtn = new JButton[super.OPTION_NUM];
		for(int i=0; i < super.OPTION_NUM; ++i) {
			OptionActionListener listener = super.getListener(i);
			listener.setTextEditor(super.getTextEditor());
			listener.setMindMapEditor(super.getMindMapEditor());
			listener.setAttrEditor(super.getAttrEditor());
			toolBtn[i] = new JButton(super.getOptionName(i));
			//toolBtn[i] = new JButton();
			//toolBtn[i].setIcon(new ImageIcon(btnImage[i]));
			toolBtn[i].addActionListener(listener);
			toolbar.add(toolBtn[i]);
			toolbar.addSeparator();
		}
		//toolbar.setFloatable(false);
		panel.add(toolbar);
	}
	
	//https://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton
	private void imageInit() {
		String[] imageName = new String[] {"new_icon.png", "open_icon.png", "save_icon.png", "save_other_icon.png", "close_icon.png", "apply_icon.png", "change_icon.png"};
		
		for(int i=0; i < super.OPTION_NUM; ++i) {
			try {
				//btnImage[i] = ImageIO.read(new File("/resources/" + imageName[i]));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "이미지가 손상되거나 없습니다. 폴더를 확인해주세요.", "Error Message", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	JToolBar getToolBar() {
		return toolbar;
	}
	
	JPanel getToolBarPanel(){
		return panel;
	}
}
