
public class Brute {

	public static void main(String [] args){
		
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		
		String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] p = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            p[i] = new Point(x, y);
            p[i].draw();
        }

		for(int i = 0; i < N; i++){
			for(int j = i+1; j < N; j++){
				
				double ij = p[i].slopeTo(p[j]);
				for(int k = j+1; k < N; k++){
				
					double jk = p[j].slopeTo(p[k]);
					if(ij != jk) {
						continue;
					}
					for(int l = k+1; l < N; l++){
					
						double kl = p[k].slopeTo(p[l]);
						if(ij == kl){
							StdOut.println(p[i] + " -> " + p[j]  + " -> " + p[k] + " -> " + p[l]);
							p[i].drawTo(p[j]);
							p[i].drawTo(p[k]);
							p[i].drawTo(p[l]);
						}
					}
				}
			}
		}
	}

}
