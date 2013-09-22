
public class Fast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);

		String filename = args[0];
		In in = new In(filename);
		int N = in.readInt();
		Point[] p = new Point[N];
		for (int i = 0; i < N; i++) {
			int x = in.readInt();
			int y = in.readInt();
			p[i] = new Point(x, y);
			p[i].draw();
		}
		
		for(int i = 0; i < N; i++){
			Map m = new Map(N-1);
			boolean skip = false;
			for(int j = 0; j < N-1; j++){
				if(j == i) { skip = true; continue; }
				if(skip) m.m[j-1] = new Node(p[i].slopeTo(p[j]), p[j]);
			}

		}

	}
	
	private static class Map{
		
		public Node[] m;
		public Map(int N){
			m = new Node[N];
		}
		
	}
	
	private static class Node{
		public final double key;
		public final Point p;
		
		public Node(double key, Point p){
			this.key = key;
			this.p = p;
		}
	}

}
