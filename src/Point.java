/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

	// compare points by slope
	public final Comparator<Point> SLOPE_ORDER = new SlopeCompare(this);       // YOUR DEFINITION HERE

	private final int x;                              // x coordinate
	private final int y;                              // y coordinate
	
	private class SlopeCompare implements Comparator<Point>{
		
		Point p;
		
		public SlopeCompare(Point p){
			this.p = p;
		}
		
		@Override
		public int compare(Point a, Point b) {
			return (int) (p.slopeTo(a) - p.slopeTo(b));
		}
		
	}

	// create the point (x, y)
	public Point(int x, int y) {
		/* DO NOT MODIFY */
		this.x = x;
		this.y = y;
	}

	// plot this point to standard drawing
	public void draw() {
		/* DO NOT MODIFY */
		StdDraw.point(x, y);
	}

	// draw line between this point and that point to standard drawing
	public void drawTo(Point that) {
		/* DO NOT MODIFY */
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	// slope between this point and that point
	public double slopeTo(Point that) {
		if(that.compareTo(this) == 0) return Double.NEGATIVE_INFINITY;
		else if(that.x == x) return Double.POSITIVE_INFINITY;
		return (double)(that.y - y) / (that.x - x);
	}

	// is this point lexicographically smaller than that one?
	// comparing y-coordinates and breaking ties by x-coordinates
	public int compareTo(Point that) {
		if(y < that.y || (y == that.y && x < that.x)) return -1;
		else if(y > that.y || (y == that.y && x > that.x)) return 1;
		return 0;
	}

	// return string representation of this point
	public String toString() {
		/* DO NOT MODIFY */
		return "(" + x + ", " + y + ")";
	}

	// unit test
	public static void main(String[] args) {
	}
}