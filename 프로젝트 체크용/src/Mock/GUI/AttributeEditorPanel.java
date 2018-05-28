package Mock.GUI;

import java.awt.*;
import javax.swing.*;

public class AttributeEditorPanel extends JPanel{
	JButton title;
	AttributeEditor attributeEditor;
	JButton changeButton;
	
	AttributeEditorPanel(){
		this.setLayout(null);
		
		//�̰� �԰��� �Ź� �Է��ؾ��ϴ°� ���Ű����� �޼ҵ带 ������� Format Ŭ������ ������� �ؾ��� ��
		title = new JButton("Attribute Pane");
		title.setLocation(0, 0);
		title.setSize(235, 30);
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setEnabled(false);
		add(title);
		
		attributeEditor = new AttributeEditor();
		attributeEditor.setLocation(0, 30);
		attributeEditor.setSize(235, 350);
		add(attributeEditor);
		
		changeButton = new JButton("����");
		changeButton.setLocation(0,380);
		changeButton.setSize(235, 30);
		add(changeButton);
	}
}
