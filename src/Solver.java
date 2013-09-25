
public class Solver {
	
	private MinPQ<Board> nodes;
	
	public Solver(Board initial){
		nodes = new MinPQ<Board>();
		
	}
	
	public boolean isSolvable(){
		return moves() != -1;
	}
	
	public int moves(){
		return -1;
	}
	
	public Iterable<Board> solution(){
		return null;
	}
	
	private class Node implements Comparable <Node>{
		
		Comparable k;
		Board b;
		
		public Node(Comparable key, Board board){
			k = key;
			b = board;
		}

		@Override
		public int compareTo(Node o) {
			return o.k.compareTo(k);
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
