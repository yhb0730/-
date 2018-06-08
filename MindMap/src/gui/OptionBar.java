package gui;

import java.awt.*;
import javax.swing.*;

import guiListener.ActionListener.*;

public abstract class OptionBar extends JComponent {
	final private String[] optionName = new String[] {"새로 만들기", "열기", "저장", "다른 이름으로 저장", "닫기", "적용", "변경"};
	final private OptionActionListener[] listener = new OptionActionListener[] {
			new NewMenuActionListener(),
			new OpenOptionActionListener(),
			new SaveOptionActionListener(),
			new SaveAnotherOptionActionListener(),
			new CloseOptionActionListener(),
			new ApplyOptionActionListener(),
			new ChangeOptionActionListener()}; 
	final static int OPTION_NUM = 7;
	private TextEditorPane textEditor;
	private MindMapEditorPane mindMapEditor;
	private AttributeEditorPane attrEditor;
	
	abstract void init();
	
	String getOptionName(int num) {
		return optionName[num];
	}
	
	OptionActionListener getListener(int num) {
		return listener[num];
	}
	
	public TextEditorPane getTextEditor() {
		return textEditor;
	}


	public void setTextEditor(TextEditorPane textEditor) {
		this.textEditor = textEditor;
	}


	public MindMapEditorPane getMindMapEditor() {
		return mindMapEditor;
	}


	public void setMindMapEditor(MindMapEditorPane mindMapEditor) {
		this.mindMapEditor = mindMapEditor;
	}


	public AttributeEditorPane getAttrEditor() {
		return attrEditor;
	}


	public void setAttrEditor(AttributeEditorPane attrEditor) {
		this.attrEditor = attrEditor;
	}

}
