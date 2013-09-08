
public class PercolationStats {
	
	private final int T, N, NN;
	private int[] trials;
	private double mean, stdev, conLo, conHi;
	private boolean m, st, cL, cH;
	
	public PercolationStats(int N, int T){
		
		if(N <= 0 || T <= 0) throw new IllegalArgumentException();
		
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
				int x,y;
				do{
					x = ((int)(Math.random() * N)) + 1;
					y = ((int)(Math.random() * N)) + 1;
				} while(p.isOpen(x, y));
				p.open(x, y);
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
		mean /= (double)NN;
		return mean;
	}
	
	public double stddev(){
		if(st) return stdev;
		st = true;
		double mean = mean();
		double var = 0;
		for(int i:trials) var += Math.pow(((double)i/(double)NN - mean), 2);
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
			System.out.println("mean\t" + "= " + ps.mean());
			System.out.println("stddev\t" + "= " + ps.stddev());
			System.out.println("95% confidence interval\t" + "= " + ps.confidenceLo() + ". " + ps.confidenceHi());
		}
	}
	

}
