package gui;

import java.awt.*;
import javax.swing.*;

public class TextArea extends JScrollPane{
	private JTextArea textArea;
	
	TextArea(){
		textArea = new JTextArea(20, 8);
		this.getViewport().add(textArea, null);
	}

	public void setText(String str) {
		textArea.setText(str);
	}

	public String getText() {
		return textArea.getText();
	}
}
