package Stack;

import java.util.Stack;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Node {
	int x, y, size, level;
	String name;
	Node parent;
	Vector<Node> child = new Vector<Node>();
	
	Node(){
		this("dummy", -1); //headNode
	}
	
	Node(String name, int level){
		this.name = name;
		this.level = level;
	}
	
	void addChild(Node child) {
		this.child.add(child);
	}
	
	Node makeTree(String[] parse) {
		Stack<Node> stack = new Stack<Node>();
		
		if(parse[0].charAt(0) == '\t')
			return null;
		Node head = new Node(parse[0].replaceAll("[\\r]", ""), 0);
		stack.push(head);
		
		for(int i=1; i < parse.length; ++i) {
			int cur = 0, level = 0;
			
			while(true) {
				if(parse[i].charAt(cur++) == '\t') {
					++level;
				}
				else
					break;
			}
			
			boolean isExist = false;
			while(!stack.empty()) {
				Node node = stack.pop();
				if(node.level + 1 == level) {
					isExist = true;
					Node newNode = new Node(parse[i].replaceAll("[\\t\\r]", ""), level);  //new line = '\r'+'\n'?, '\n'를 기준으로 파싱했으니 '\r'만 남은건지 뭔지 모르겠음
					newNode.parent = node;
					node.addChild(newNode);
					stack.push(node);
					stack.push(newNode);
					break;
				}
			}
			
			if(!isExist) { //stack.empty()로 검사 안하는건 마지막 문장 때 문제 요소가 있어서
				return null;
			}
		}
		return head;
	}
	
	void travel() {
		Node cur = this;
		if(cur.parent == null) {
			System.out.print("부모 X ");
		}
		else
			System.out.print("부모 = " + cur.parent.name);  
		System.out.println(" 이름 : " + cur.name + " level : " + cur.level);
		for(int i=0; i < child.size(); ++i) {
			cur = child.get(i);
			cur.travel();
		}
	}
}
