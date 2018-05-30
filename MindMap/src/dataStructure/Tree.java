package dataStructure;

import java.util.Stack;

public class Tree {
	private Node head;
	
	public Node makeTree(String[] parse) {
		Stack<Node> stack = new Stack<Node>();
		
		if(parse[0].charAt(0) == '\t')
			return null;
		head = new Node(parse[0].replaceAll("[\\r]", ""), 0);
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
					Node newNode = new Node(parse[i].replaceAll("\r", ""), level);
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
		return head;
	}
}
