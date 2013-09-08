
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
		
		if(i == 1){
			w.union(coordsToIndex(i,j), 0);
		} else if(i == slen){
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
		
		i--; j--;
		s[i][j] = true;
		
	}
	
	public boolean isOpen(int i, int j){
		if(!isValid(i,j)) throw new IndexOutOfBoundsException("" + i + ", " + j);
		i--; j--;
		return s[i][j];
	}
	
	public boolean isFull(int i, int j){
		if(!isValid(i,j)) throw new IndexOutOfBoundsException();
		return w.connected(0, coordsToIndex(i,j));
	}
	
	public boolean percolates(){
		return w.connected(0, last);
	}
	
	private int coordsToIndex(int i, int j){
		if(!isValid(i,j)) throw new IndexOutOfBoundsException("" + i + ", " + j);
		i--; j--;
		return i*slen + j + 1;
	}
	
	private boolean isValid(int i, int j){
		i--; j--;
		return (i < slen && i >= 0) && (j < slen && j >= 0);
	}
	
	private void print(){
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
		Percolation p = new Percolation(1);
//		p.open(1,1);
		System.out.println(p.isOpen(1,1));
		p.print();
	}

}
