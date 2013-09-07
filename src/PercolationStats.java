
public class PercolationStats {
	
	private final int T, N, NN;
	private int[] trials;
	private double mean, stdev, conLo, conHi;
	private boolean m, st, cL, cH;
	
	public PercolationStats(int N, int T){
		
		this.N = N;
		this.T = T;
		NN = N*N;
		trials = new int[T];
		
		simulate();
		
	}
	
	private void simulate(){
		for(int i = 0; i < T; i++){ //Each trial
			Percolation p = new Percolation(N);
			int os = 0; //opened spots
			
			while(!p.percolates()){
				int[] loc;
				do{
					int s = (int)(Math.random() * NN);
					loc = p.indexToCoords(s);
				} while(p.isOpen(loc[0], loc[1]));
				p.open(loc[0], loc[1]);
				os++;
			}
			trials[i] = os;
		}
	}
	
	public double mean(){
		if(m) return mean;
		m = true;
		mean = 0;
		for(int i:trials) mean += (double)i/(double)T;
		return mean;
	}
	
	public double stddev(){
		if(st) return stdev;
		st = true;
		double mean = mean();
		double var = 0;
		for(int i:trials) var += Math.pow(((double)i - mean), 2);
		var /= T-1;
		stdev = Math.sqrt(var);
		return stdev;
	}
	
	public double confidenceLo(){
		if(cL) return conLo;
		cL = true;
		double mean = mean();
		double stddev = stddev();
		return mean - (1.96 * stddev)/Math.sqrt(T);
	}
	
	public double confidenceHi(){
		if(cH) return conHi;
		cH = true;
		double mean = mean();
		double stddev = stddev();
		conHi = mean + (1.96 * stddev)/Math.sqrt(T);
		return conHi;
	}
	
	public static void main(String [] args){
		if(args.length == 2){
			PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			
		}
	}
	

}
