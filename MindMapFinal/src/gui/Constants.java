package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Constants {
	//650 548
	static public final int MINDMAP_X_SIZE = 650;
	static public final int MINDMAP_Y_SIZE = 548;
	static public final int SCROLL_X_SIZE = 1000;
	static public final int SCROLL_Y_SIZE = 1000;
	
	static public final int NODE_X_SIZE = 30;
	static public final int NODE_Y_SIZE = 30;
	
	static public final int FRAME_X_SIZE = 1200;
	static public final int FRAME_Y_SIZE = 730;
	
	static public final int TEXT_ATTRIBUTE = 0;
	static public final int X_ATTRIBUTE = 1;
	static public final int Y_ATTRIBUTE = 2;
	static public final int WIDTH_ATTRIBUTE = 3;
	static public final int HEIGHT_ATTRIBUTE = 4;
	static public final int COLOR_ATTRIBUTE = 5;

	static public boolean IS_CHANGED = false;
	
	public static void setComponent(Point point, int sizeX, int sizeY, JComponent component) {
		setComponent(point, sizeX, sizeY, 10, component);
	}
	
	public static void setComponent(Point point, int sizeX, int sizeY, int fontSize, JComponent component) {
		component.setLocation(point);
		//component.setPreferredSize(new Dimension(sizeX, sizeY));
		component.setSize(sizeX, sizeY);
		component.setFont(new Font("Arial", Font.PLAIN, fontSize));
	}
}
