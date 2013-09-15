
public class Brute {

	public static void main(String [] args){
		int N = StdIn.readInt();
		Point[] p = new Point[N];
		for(int i = 0; i < N; i++){
			p[0] = new Point(StdIn.readInt(), StdIn.readInt());
		}

		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);

		for(int i = 0; i < N; i++){
			p[i].draw();
			for(int j = i; j < N; j++)
				for(int k = j; k < N; k++)
					for(int l = k; l < N; l++)
						if(p[i].slopeTo(p[j]) == p[i].slopeTo(p[k]) 
						&& p[i].slopeTo(p[j]) == p[i].slopeTo(p[l])){
							System.out.println(p[i] + " -> " + p[j]  + " -> " + p[k] + " -> " + p[l]);
							p[i].drawTo(p[j]);
							p[i].drawTo(p[k]);
							p[i].drawTo(p[l]);
						}
		}
	}

}
