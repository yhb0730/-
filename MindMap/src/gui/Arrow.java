package gui;

import java.awt.*;
import javax.swing.*;

public class Arrow extends JComponent{
	private Point start;
	private Point end;

	Arrow(Point start, Point end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
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
	
	public void refreshArrow(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
}
