
public class Board {

	private final int [][] b;

	public Board(int[][] blocks){
		if(blocks.length != blocks[0].length){ throw new IllegalArgumentException(); }
		b = blocks;
	}

	public int dimension(){
		return b.length;
	}

	public int hamming(){
		int hamming = 0; // out of place blocks
		int N = b.length;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(i == N-1 && j == N-1) break;
				if((i * N + j + 1) != b[i][j]) hamming++;
			}
		}
		return hamming;
	}

	public int manhattan(){
		return -1;
	}

	public boolean isGoal(){
		return hamming() == 0;
	}

	public Board twin(){
		return null;
	}

	public boolean equals(Object y){
		return false;
	}

	public Iterable<Board> neighbors(){
		// TODO need Point class for finding empty spot
		return null;
	}

	public String toString(){
		return "";
	}

	private Board swap (/* TODO need to implement points/location */){
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
