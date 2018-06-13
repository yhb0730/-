package dataStructure;

import java.awt.Point;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import gui.Constants;
import gui.NodeLabel;

public class JsonNode {
	final static String NAME = "name";
	final static String LEVEL = "level";
	final static String X = "x";
	final static String Y = "y";
	final static String WIDTH = "width";
	final static String HEIGHT = "height";
	final static String CHILD = "child";
	
	public static JSONObject makeJsonNode() {
		Node head = NodeManager.getHead();
		if(head == null)
			return null;
		int size = head.getSize();
		JSONObject jsonNode = new JSONObject();
		jsonNode.put(NAME, head.getString());
		jsonNode.put(LEVEL, head.getLevel());
		jsonNode.put(X, head.getMyNodeLabel().getLocation().x);
		jsonNode.put(Y, head.getMyNodeLabel().getLocation().y);
		jsonNode.put(WIDTH, head.getMyNodeLabel().getWidth());
		jsonNode.put(HEIGHT, head.getMyNodeLabel().getHeight());
		JSONArray childList = new JSONArray();
		for(int i=0; i < size; ++i) {
			Node childNode = head.getChild(i);
			JSONObject json = makeRecursiveNode(childNode);
			childList.add(json);
		}
		jsonNode.put(CHILD, childList);
		System.out.println(jsonNode);
		return jsonNode;
	}
	
	private static JSONObject makeRecursiveNode(Node cur) {
		JSONObject jsonNode = new JSONObject();
		jsonNode.put(NAME, cur.getString());
		jsonNode.put(LEVEL, cur.getLevel());
		jsonNode.put(X, cur.getMyNodeLabel().getLocation().x);
		jsonNode.put(Y, cur.getMyNodeLabel().getLocation().y);
		jsonNode.put(WIDTH, cur.getMyNodeLabel().getWidth());
		jsonNode.put(HEIGHT, cur.getMyNodeLabel().getHeight());
		JSONArray childList = new JSONArray();
		int size = cur.getSize();
		for(int i=0; i < size; ++i) {
			Node childNode = cur.getChild(i);
			JSONObject json = makeRecursiveNode(childNode);
			childList.add(json);
		}
		jsonNode.put(CHILD, childList);
		return jsonNode;
	}
	
	public static void readJsonNode(JSONObject object) {
		String name = (String)object.get(NAME);
		int level = (int)object.get(LEVEL);
		int x = (int)object.get(X);
		int y = (int)object.get(Y);
		int width = (int)object.get(WIDTH);
		int height = (int)object.get(HEIGHT);
		NodeManager.setHead(new Node(0, name, level));
		Node head = NodeManager.getHead();
		NodeLabel nodeLabel = new NodeLabel(head, null);
		Constants.setComponent(new Point(x, y), width, height, nodeLabel);
		head.setMyNodeLabel(nodeLabel);
		
		JSONArray list = (JSONArray)object.get(CHILD);
		Iterator<JSONObject> iterator = list.iterator();
		while(iterator.hasNext()) {
			JSONObject nextObject = iterator.next();
			head.addChild(readRecursiveNode(nextObject, nodeLabel));
		}
	}
	
	private static Node readRecursiveNode(JSONObject object, NodeLabel parent) {
		String name = (String)object.get(NAME);
		int level = (int)object.get(LEVEL);
		int x = (int)object.get(X);
		int y = (int)object.get(Y);
		int width = (int)object.get(WIDTH);
		int height = (int)object.get(HEIGHT);
		Node child = new Node(name, level);
		NodeLabel nodeLabel = new NodeLabel(child, parent);
		Constants.setComponent(new Point(x,y), width, height, nodeLabel);
		child.setMyNodeLabel(nodeLabel);
		Vector<NodeLabel> childVector = parent.getChildVector();
		childVector.add(nodeLabel);
		
		
		JSONArray list = (JSONArray)object.get(CHILD);
		Iterator<JSONObject> iterator = list.iterator();
		while(iterator.hasNext()) {
			JSONObject nextObject = iterator.next();
			child.addChild(readRecursiveNode(nextObject, nodeLabel));
			
		}
		return child;
	}
}
