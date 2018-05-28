package Mock.GUI;

import java.awt.*;
import javax.swing.*;

public class MindMapEditorPanel extends JPanel{
	JButton title;
	MindMapEditor mindMapEditor;
	
	MindMapEditorPanel(){
		this.setLayout(null);
	
		title = new JButton("Mind Map Pane");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setLocation(140, 0);
		title.setSize(180, 30);
		title.setEnabled(false);
		add(title);
	
		mindMapEditor = new MindMapEditor();
		mindMapEditor.setLocation(0, 0);
		mindMapEditor.setSize(500, 500);
		add(mindMapEditor);
		//신기하게 아래에 있는게 덮혀씌워진다. 대체 왜?
	}
}
