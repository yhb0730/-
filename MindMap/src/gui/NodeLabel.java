package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JLabel;
import dataStructure.Node;

public class NodeLabel extends JLabel{
		//private int width;
		//private int height;
		private Node node;
		
		public NodeLabel(Node node){
			this.node = node;
			this.setText(node.getString());
			this.setOpaque(true);
			this.setBackground(Color.lightGray);
		}

		/*@Override
		public void setSize(int x, int y) {
			this.width = x;
			this.height = y;
			super.setSize(width, height);
		}*/
		
		public int getWidth() {
			return this.getSize().width;
		}


		public void setWidth(int width) {
			setSize(width, getHeight());
		}


		public int getHeight() {
			return this.getSize().height;
		}


		public void setHeight(int height) {
			setSize(getWidth(), height);
			//setPreferredSize(new Dimension(getWidth(), height));
		}


		public Node getNode() {
			return node;
		}
		
		public void setNode(Node node) {
			this.node = node;
		}
}
