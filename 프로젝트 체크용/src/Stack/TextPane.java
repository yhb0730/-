package Stack;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;
import javax.swing.*;

public class TextPane extends JPanel{
	TextArea text;
	JButton apply;

	TextPane(MindMapPane mindMap){
		text = new TextArea(20, 20);
		add(text);
		
		apply = new JButton("적용");
		applyClickListener listen = new applyClickListener(text, mindMap);
		apply.addMouseListener(listen);
		add(apply);
	}
}

class applyClickListener extends MouseAdapter{
	MindMapPane mindMap;
	TextArea text;
	
	applyClickListener(TextArea text, MindMapPane mindMap){
		this.mindMap = mindMap;
		this.text = text;
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String[] parse = text.getText().split("\\n");
		if(text.getText() == null || text.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "잘못된 양식입니다.", "양식 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		mindMap.makeTree(parse);
	}
}
