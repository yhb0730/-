package Stack;

import java.awt.*;
import java.util.Stack;
import javax.swing.*;


public class MindMapPane extends JPanel {
	Node head;
	
	MindMapPane(){
		setLayout(null);
	}
	
	void makeTree(String[] parse) {
		head = new Node(); //��¥ head�� �ϳ� �δ°� �������� ����
		System.gc(); //����ڰ� makeTree�� ���� ȣ���Ҽ��� �������� ��� ����Ŵ� �� ���̶� �ؾ���
		head = head.makeTree(parse);
		if(head == null)
			JOptionPane.showMessageDialog(null, "�߸��� ����Դϴ�.", "��� ����", JOptionPane.ERROR_MESSAGE);
		else {
			//head.travel();
			removeAll();
			draw(head, getWidth() / 2, 0);
			updateUI();
		}
	}
	
	void draw(Node cur, int x, int y) {
		JButton button = new JButton(cur.name);
		button.setLocation(x, y);
		button.setSize(50, 30);
		
		add(button);
		System.out.println(y);
		
		int childNum = cur.child.size();
		
		for(int i=0; i < childNum / 2; ++i) {
			Node target = cur.child.get(i);
			draw(target, x - (x / 2) - (50 * i), (cur.level + 1) * 80);
		}
		
		/*if(childNum % 2 == 1) {
			Node target = cur.child.get(childNum / 2);
			draw(target, x, (cur.level + 1 * 80));
		}*/
		
		for(int i=childNum / 2; i < childNum; ++i) {
			Node target = cur.child.get(i);
			draw(target, x + ((x / 2) - (50 * (childNum - i))), (cur.level + 1) * 80);
		}
		/*for(int i=0; i < childNum / 2; ++i) {
			Node target = cur.child.get(i);
			draw(target, x - 70 * (childNum / 2 - i + 1) * target.level, y + 80);
		}
		for(int i= childNum/2; i < childNum; ++i) {
			Node target = cur.child.get(i);
			draw(target, x + 70 * (i-childNum/2 + 1) * target.level, y + 80);
		}*/
	}
}
