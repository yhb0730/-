package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Format {
	static void setComponent(Point point, int sizeX, int sizeY, JComponent component) {
		setComponent(point, sizeX, sizeY, 10, component);
	}
	
	static void setComponent(Point point, int sizeX, int sizeY, int fontSize, JComponent component) {
		component.setLocation(point);
		component.setSize(sizeX, sizeY);
		component.setFont(new Font("Arial", Font.PLAIN, fontSize));
	}
}
