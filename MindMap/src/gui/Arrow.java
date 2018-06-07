package gui;

import java.awt.*;
import javax.swing.*;

public class Arrow extends JPanel{
	private Point start;
	private Point end;
	private Color color;
	
	Arrow(){
		this(null, null, Color.BLACK);
	}
	
	Arrow(Point start, Point end){
		this(start, end, Color.BLACK);
	}
	
	Arrow(Point start, Point end, Color color){
		this.start = start;
		this.end = end;
		this.color = color;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(start.x, start.y, end.x, end.y);
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
