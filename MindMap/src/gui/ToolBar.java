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
	private Image[] btnImage;
	final private String[] toolTip = new String[] {
			"새로운 파일을 만듭니다.",
			"다른 파일을 불러옵니다.",
			"현재 파일을 저장합니다.",
			"현재 파일을 다른 이름으로 저장합니다.",
			"현재 MindMapPane의 그림을 JPG형태로 저장합니다.",
			"프로그램을 종료합니다.",
			"TextEditor 부분의 내용을 적용합니다.",
			"Attribute 부분의 내용으로 노드를 변경합니다." };
	
	@Override
	void init() {
		// TODO Auto-generated method stub
		//imageInit();
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
			toolBtn[i].setToolTipText(toolTip[i]);
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
