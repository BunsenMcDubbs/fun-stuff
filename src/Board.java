import java.util.ArrayList;


public class Board {

	private final int [][] b;
	private final int N;
	public static final int EMPTY = 0;

	public Board(int[][] blocks){
		if(blocks.length != blocks[0].length){ throw new IllegalArgumentException(); }
		b = blocks;
		N = b.length;
	}

	public int dimension(){
		return b.length;
	}

	public int hamming(){
		int hamming = 0; // out of place blocks
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(i == N-1 && j == N-1) break;
				if((i * N + j + 1) != b[i][j]) hamming++;
			}
		}
		return hamming;
	}

	
	public int manhattan(){
		int manhattan = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++){
				int val = b[i][j] - 1;
				if(val == EMPTY - 1) continue; // found empty spot
				int x = val / N, y = val % N;
				manhattan += Math.abs(i - x) + Math.abs(j - y);
			}
		return manhattan;
	}

	public boolean isGoal(){
		return hamming() == 0;
	}

	public Board twin(){
		return swapClone(new Point2D(0,0), new Point2D(0,1));
	}

	public boolean equals(Object y){
		Board other = (Board)y;
		if(other.b.length != b.length) return false;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(b[i][j] != other.b[i][j]) return false;
		return true;
	}

	public Iterable<Board> neighbors(){
		Point2D empty = null;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if (b[i][j] == EMPTY) empty = new Point2D(i, j);

		ArrayList<Board> neighbors = new ArrayList<Board>();

		int x = (int) empty.x(), y = (int) empty.y();
		for(int i = -1; i <= 1; i++)
			for(int j = -1; j <= 1; j++)
				if(isValid(x + i, y + j)) neighbors.add(swapClone(empty, new Point2D(x + i, y + j)));

		return neighbors;
	}

	private boolean	isValid(Point2D p){
		return isValid((int)p.x(), (int)p.y());
	}

	private boolean isValid(int i, int j){
		return (i >= 0 && i < N && j >= 0 && j < N);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(N + "\n");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				s.append(String.format("%2d ", b[i][j]));
			}
			s.append("\n");
		}
		return s.toString();
	}

	private Board swapClone (Point2D a, Point2D b){
		Board newb = (Board) this.clone();
		int ax = (int)a.x(), ay = (int) a.y(), bx = (int)b.x(), by = (int)b.y();
		int aval = newb.b[ax][ay];
		int bval = newb.b[bx][by];
		newb.b[ax][ay] = bval;
		newb.b[bx][by] = aval;
		return newb;
	}

	public Object clone(){
		return (Object) new Board(b.clone());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] b = {{1,8,3},
				{4,5,6},
				{7,0,2}};
		Board bb = new Board(b);
		System.out.println(bb);
		System.out.println("Manhattan " + bb.manhattan());
		System.out.println("Hamming " + bb.hamming());
	}

}
