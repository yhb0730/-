package gui;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JLabel;
import dataStructure.Node;

public class NodeLabel extends JLabel{
		private Point nodeSize;
		private Node node;
		
		public NodeLabel(Node node){
			this.node = node;
			this.setText(node.getString());
			this.setOpaque(true);
			this.setBackground(Color.BLUE);
		}
				
		public Point getNodeSize() {
			return nodeSize;
		}
		
		public void setNodeSize(Point nodeSize) {
			this.nodeSize = nodeSize;
			this.setSize(nodeSize.x, nodeSize.y);
		}
		
		public Node getNode() {
			return node;
		}
		
		public void setNode(Node node) {
			this.node = node;
		}
}
