import java.util.ArrayList;


public class Solver {
	
	private MinPQ<Node> n;
	private int moves;
	
	public Solver(Board initial){
		moves = 0;

		n = new MinPQ<Node>();
		Node init = new Node(initial.manhattan() + moves(), initial, null);
		n.insert(init);
		
		solve();
	}
	
	private void solve(){
		
		Node curr = n.delMin();
		
		if (moves++ == 0) return;
		
		ArrayList<Board> neighbors = (ArrayList<Board>) curr.b.neighbors();
		for(int i = 0; i < neighbors.size(); i++){
			if(neighbors.get(i).equals(curr.prev.b)) continue;
			Board x = neighbors.get(i);
			n.insert(new Node(x.manhattan() + moves, x, curr));
		}
		
	}
	
	public boolean isSolvable(){
		return moves() != -1;
	}
	
	public int moves(){
		return moves;
	}
	
	public Iterable<Board> solution(){
		return null;
	}
	
	private class Node implements Comparable <Node>{
		
		Integer k; // priority - key
		Board b; // board - value
		
		Node prev;
		
		public Node(int priority, Board board, Node previous){
			k = priority;
			b = board;
			prev = previous;
		}

		@Override
		public int compareTo(Node other) {
			return other.k.compareTo(k);
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
