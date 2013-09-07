import java.awt.Point;


public class Percolation {
	
	private WeightedQuickUnionUF w;
	private boolean [][] s;
	private final int slen;
	private final int last;
	
	public Percolation(int N){
		w = new WeightedQuickUnionUF(N*N + 2);
		s = new boolean[N][N];
		slen = N;
		last = N*N + 1;
	}
	
	public void open(int i, int j){
		
		int loc = coordsToIndex(i,j);
		if(loc == -1) return;
		
		if(i == 0){
			w.union(coordsToIndex(i,j), 0);
		} else if(i == slen - 1){
			w.union(coordsToIndex(i,j), last);
		}
		
		if(isValid(i,j-1) && isOpen(i,j-1))
			w.union(coordsToIndex(i,j-1), loc);
		if(isValid(i,j+1) && isOpen(i,j+1))
			w.union(coordsToIndex(i,j+1), loc);
		if(isValid(i-1,j) && isOpen(i-1,j))
			w.union(coordsToIndex(i-1,j), loc);
		if(isValid(i+1,j) && isOpen(i+1,j))
			w.union(coordsToIndex(i+1,j), loc);
		
		s[i][j] = true;
		
	}
	
	public boolean isOpen(int i, int j){
		return s[i][j];
	}
	
	public boolean isFull(int i, int j){
		return w.connected(0, coordsToIndex(i,j));
	}
	
	public boolean percolates(){
		return w.connected(0, last);
	}
	
	public int coordsToIndex(int i, int j){
		if(!isValid(i,j)) return -1;
		return i*slen + j + 1;
	}
	
	public int[] indexToCoords(int in){
		return new int[]{ (in-1)/slen, (in-1)%slen };
	}
	
	private boolean isValid(int i, int j){
		return (i < slen && i >= 0) && (j < slen && j >= 0);
	}
	
	public void print(){
		for(int i = 0; i < slen; i++){
			for(int j = 0; j < slen; j++){
				if(s[i][j]) System.out.print("o ");
				else System.out.print("x ");
			}
			System.out.println();
		}
		
		System.out.println("" + w.find(0) + " ");
		for(int i = 0; i < last; i++){
			System.out.print("" + w.find(i + 1) + " ");
			if((i+1) % slen == 0) System.out.println();
		}
	}
	
	public static void main(String[] args){
		Percolation p = new Percolation(5);
		p.print();
		System.out.println("\n");
		p.open(0,0);
		p.open(1,0);
		p.open(2,0);
		p.open(2,1);
		p.open(3,1);
		p.open(4,1);
		System.out.println(p.percolates());
		p.print();
	}

}
