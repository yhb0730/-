package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Constants {
	static public final int NODE_X_SIZE = 30;
	static public final int NODE_Y_SIZE = 30;
	
	static void setComponent(Point point, int sizeX, int sizeY, JComponent component) {
		setComponent(point, sizeX, sizeY, 10, component);
	}
	
	static void setComponent(Point point, int sizeX, int sizeY, int fontSize, JComponent component) {
		component.setLocation(point);
		component.setSize(sizeX, sizeY);
		component.setFont(new Font("Arial", Font.PLAIN, fontSize));
	}
}
