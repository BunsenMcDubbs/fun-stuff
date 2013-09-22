
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
			// insert into map
			boolean skip = false;
			for(int j = 0; j < N-1; j++){
				if(j == i) { skip = true; continue; }
				if(skip) m.m[j-1] = new Node(p[i].slopeTo(p[j]), p[j]);
			}
			
			// sort map
			sort(m);
			
			for(int j = 0; j < N-1-2; j++){
				if(m.m[j].compareTo(m.m[j+1]) == 0)
					if(m.m[j+1].compareTo(m.m[j+2]) == 0){
						// match
						StdOut.println(p[i] + " -> " + m.m[j].p + " -> " + m.m[j+1].p + " -> " + m.m[j+2].p);
					}
					else j++;
			}
		}

	}
	
	private static void sort(Map m){
		
	}
	
	private static class Map{
		
		public Node[] m;
		public Map(int N){
			m = new Node[N];
		}
		
	}
	
	private static class Node implements Comparable<Node>{
		public final double key;
		public final Point p;
		
		public Node(double key, Point p){
			this.key = key;
			this.p = p;
		}

		@Override
		public int compareTo(Node o) {
			if( key < o.key ) return -1;
			else if ( key == o.key ) return 0;
			return 1;
		}
	}

}
