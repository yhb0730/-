package Mock.GUI;

import java.awt.*;
import javax.swing.*;

public class TextEditorPanel extends JPanel{
	JButton title;
	TextEditor textEditor;
	JButton applyButton;
	
	TextEditorPanel(){
		this.setLayout(null);
		title = new JButton("Text Editor Pane");
		title.setLocation(0, 0);
		title.setSize(235, 30);
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setEnabled(false);
		add(title);
		
		textEditor = new TextEditor();
		textEditor.setLocation(0, 30);
		textEditor.setSize(235, 350);
		add(textEditor);
		
		applyButton = new JButton("Àû¿ë");
		applyButton.setLocation(0, 380);
		applyButton.setSize(235, 30);
		add(applyButton);
	}
}
