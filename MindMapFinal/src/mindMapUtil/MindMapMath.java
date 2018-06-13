package mindMapUtil;

import java.awt.Point;

import gui.NodeLabel;

public class MindMapMath {
	//참조 : https://stackoverflow.com/questions/9970281/java-calculating-the-angle-between-two-points-in-degrees
	static public float getAngle(Point first, Point second) {
		float angle = (float)Math.toDegrees(Math.atan2(second.y - first.y, second.x - first.x));
		
		if(angle < 0) {
			angle += 360;
		}
		
		return angle;
	}
	
	//사용하지 않을 계획
	static public void calculateConnectionPoint(NodeLabel child, NodeLabel parent, Point childPoint, Point parentPoint) {
		float angle = MindMapMath.getAngle(parentPoint, childPoint);
		
		if(0 <= angle && angle <= 60) {
			parentPoint.x = parent.getRight().x;
			parentPoint.y = parent.getRight().y;
			childPoint.x = child.getLeft().x;
			childPoint.y = child.getLeft().y;
		}
		else if(60 < angle && angle <= 120) {
			parentPoint.x = parent.getBottom().x;
			parentPoint.y = parent.getBottom().y;
			childPoint.x = child.getTop().x;
			childPoint.y = child.getTop().y;
		}
		else if(120 < angle && angle <= 210) {
			parentPoint.x = parent.getLeft().x;
			parentPoint.y = parent.getLeft().y;
			childPoint.x = child.getRight().x;
			childPoint.y = child.getRight().y;
		}
		else if(210 < angle && angle <= 300) {
			parentPoint.x = parent.getTop().x;
			parentPoint.y = parent.getTop().y;
			childPoint.x = child.getBottom().x;
			childPoint.y = child.getBottom().y;
		}
		else if(300 < angle && angle <= 360) {
			parentPoint.x = parent.getRight().x;
			parentPoint.y = parent.getRight().y;
			childPoint.x = child.getLeft().x;
			childPoint.y = child.getLeft().y;
		}
	}
	
	static public void calculateShortestConnectionPoint(NodeLabel child, NodeLabel parent, Point childPoint, Point parentPoint) {
		Point[] childArr = new Point[] {child.getTop(), child.getBottom(), child.getLeft(), child.getRight()};
		Point[] parentArr = new Point[] {parent.getTop(), parent.getBottom(), parent.getLeft(), parent.getRight()};
		double minDistance = Double.MAX_VALUE;
		Point parentMin = null;
		Point childMin = null;
		
		for(int i=0; i < childArr.length; ++i) {
			for(int j=0; j < parentArr.length; ++j) {
				double distance = getDistance(childArr[i], parentArr[j]);
				if(distance < minDistance) {
					childMin = childArr[i];
					parentMin = parentArr[j];
					minDistance = distance;
				}
			}
		}
		childPoint.x = childMin.x; childPoint.y = childMin.y;
		parentPoint.x = parentMin.x; parentPoint.y = parentMin.y;
	}
	
	static public double getDistance(Point first, Point second) {
		double x = first.getX() - second.getX();
		double y = first.getY() - second.getY();
		
		return Math.sqrt(x * x + y * y);
	}
}
