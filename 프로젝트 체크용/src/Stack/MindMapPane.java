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
		head = new Node(); //가짜 head를 하나 두는게 나을수도 있음
		System.gc(); //사용자가 makeTree를 자주 호출할수록 가비지가 계속 생길거니 이 짓이라도 해야함
		head = head.makeTree(parse);
		if(head == null)
			JOptionPane.showMessageDialog(null, "잘못된 양식입니다.", "양식 오류", JOptionPane.ERROR_MESSAGE);
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
