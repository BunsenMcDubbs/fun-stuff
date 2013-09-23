
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

		// 0 -> N-1 (N items)
		for(int i = 0; i < N; i++){
			Map m = new Map(N-1); // N-1 items (excludes i)
			// insert into map
			for(int j = 0; j < i; j++){
				m.m[j] = new Node(p[i].slopeTo(p[j]), p[j]);
			}
			for(int j = i+1; j < N; j++){
				m.m[j-1] = new Node(p[i].slopeTo(p[j]), p[j]);
			}

			// sort map
			sort(m);

			for(int j = 0; j < N-1-2; j++){
				if(m.m[j].compareTo(m.m[j+1]) == 0)
					if(m.m[j+1].compareTo(m.m[j+2]) == 0){
						// match
						StdOut.println(p[i] + " -> " + m.m[j].p + " -> " 
								+ m.m[j+1].p + " -> " + m.m[j+2].p);
					}
					else j++;
			}
		}

	}

	private static void sort(Map m){
		sort(m.m, m.m.clone(), 0, m.m.length-1);
	}

	private static void sort(Node[] n, Node[] aux, int start, int end){

//		System.out.println("start " + start + " end " + end);

		if(end - start == 1){
			if(n[start].compareTo(n[end]) > 0){
				Node temp = n[start];
				n[start] = n[end];
				n[end] = temp;
			}
			return;
		} else if (end <= start) return;

		int mid = (start + end)/2;
		sort(n, aux, start, mid);
		sort(n, aux, mid + 1, end);

//		System.out.println("return start " + start + " end " + end);

		// swap nodes
		Node[] temp = aux;
		aux = n;
		n = temp;

		// merge
		for(int i = start, j = end/2 + 1, ind = start; ind <= end; ind++){
			if(i > end/2) { // if i is complete
				n[ind] = aux[j++];
				continue;
			} else if (j > end){ // if j is complete
				n[ind] = aux[i++];
				continue;
			}
			
			if(j >= 98) 
				System.out.println("poop");
			
			if(aux[i].key < aux[j].key){
				n[ind] = aux[i++];
			} else{
				n[ind] = aux[j++];
			}
		}

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
