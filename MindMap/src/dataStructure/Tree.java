package dataStructure;

import java.util.Stack;

public class Tree {
	static public Node makeTree(String[] parse) {
		Stack<Node> stack = new Stack<Node>();
		int index = 0;
		
		if(parse[0].charAt(0) == '\t')
			return null;
		Node head = new Node(index++, parse[0].replaceAll("[\\r]", ""), 0);
		stack.push(head);
		
		for(int i=1; i < parse.length; ++i) {
			int curChar = 0, level = 0;
			
			while(true) {
				if(parse[i].charAt(curChar++) == '\t') {
					++level;
				}
				else
					break;
			}
		
			boolean isParentExist = false;
			while(!stack.empty()) {
				Node stackNode = stack.pop();
				if(stackNode.getLevel() + 1 == level) {
					isParentExist = true;
					Node newNode = new Node(index++, parse[i].replaceAll("[\\t\\r]", ""), level);
					newNode.setParent(stackNode);
					stackNode.addChild(newNode);
					stack.push(stackNode);
					stack.push(newNode);
					break;
				}
			}
			
			if(!isParentExist){
				return null;
			}
		}
		/****디버깅때만 사용할 함수*******/
		debugtravel(head);
		/*************************/
		return head;
	}
	
	private static void debugtravel(Node node) {
		Node cur = node;
		if(cur.getParent() == null) {
			System.out.println("부모 X");
		}
		else
			System.out.println("부모 = " + cur.getParent().getName());
		System.out.println("인덱스 : " + cur.getIndex() + " 이름 : " + cur.getName() + " level : " + cur.getLevel());
		
		for(int next = 0; next < node.getSize(); ++next) {
			Node target = node.getChild(next);
			Tree.debugtravel(target);
		}
	}
}
