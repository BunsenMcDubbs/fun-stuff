
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
	
	public static void main (String[] args){
		wQuickUnionUF a = new wQuickUnionUF(10);
		a.union(4,6);
		a.union(3,4);
		System.out.println(a.connected(3, 6));
		System.out.println(a.count());
	}

}
