
public class Percolation {
	
	private WeightedQuickUnionUF w;
	private boolean [][] s;
	private int slen;
	
	public Percolation(int N){
		w = new WeightedQuickUnionUF(N*N + 2);
		s = new boolean[N][N];
		slen = N;
	}
	
	public void open(int i, int j){
		
	}
	
	public boolean isOpen(int i, int j){
		return s[i][j];
	}
	
	public boolean isFull(int i, int j){
		//TODO fix this shiz - implemented wrong
		return !s[i][j];
	}
	
	public boolean percolates(){
		return w.connected(0, slen*slen-1);
	}
	
	private int coordsToIndex(int i, int j) throws Exception{
		if((i < slen && i >= 0) && (j < slen && j >= 0))
			throw new Exception("Invalid Coordinates");
		return i*slen + j + 1;
	}
	
	public void print(){
		for(int i = 0; i < slen; i++){
			for(int j = 0; j < slen; j++){
				if(s[i][j]) System.out.print("o ");
				else System.out.print("x ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < slen*slen; i++){
			System.out.print("" + w.find(i) + " ");
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
		p.open(3,0);
		p.open(4,0);
		System.out.println(p.percolates());
		System.out.println(p.w.connected(0, 19));
		p.print();
	}

}
