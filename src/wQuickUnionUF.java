
public class wQuickUnionUF {
	
	private int[] sz, a;
	private int count;
	
	public wQuickUnionUF(int N){
		sz = new int[N];
		for(int i = 0; i < N; i++)
			sz[i] = 1;
		a = new int[N];
		for(int i = 0; i < N; i++)
			a[i] = i;
		count = N;
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public void union(int p, int q){
		int i = find(p), j = find(q);
		if(i == j) return;
		if(sz[i] > sz[j]){
			a[j] = i;
			sz[i] += sz[j];
		}
		else{
			a[i] = j;
			sz[j] += sz[i];
		}
		count--;
	}
	
	public int find(int p){
		a[p] = a[a[p]];
		while (a[p] != p)
			p = a[p];
		return p;
	}
	
	public int count(){
		return count;
	}
	
	//    8-2 4-9 6-3 9-6 0-8 0-1 1-9 4-7 2-5 
	public static void main (String[] args){
		wQuickUnionUF a = new wQuickUnionUF(10);
		a.union(8,2);
		a.union(4,9);
		a.union(6,3);
		a.union(9,6);
		a.union(0,8);
		a.union(0,1);
		a.union(1,9);
		a.union(4,7);
		a.union(2,5);
		
		for(int i = 0; i < 10; i++){
			System.out.print("" + a.a[i] + " ");
		}

	}

}
