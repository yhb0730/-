package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dataStructure.Node;

public class NodeLabel extends JLabel{
		private Node node;
		
		public NodeLabel(Node node){
			this.node = node;
			this.setText(node.getString());
			this.setHorizontalAlignment(JLabel.CENTER);
			this.setVerticalAlignment(JLabel.CENTER);;
			this.setOpaque(true);
			this.setBackground(Color.LIGHT_GRAY);
			this.setForeground(Color.black);
		}
		
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
