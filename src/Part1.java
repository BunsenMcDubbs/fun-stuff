

public class Part1 {
	
	/**
	 * 1.1.20 static recursive method that computes the value of ln(N!)
	 * @param n - precondition: n must be a positive number
	 * @return 
	 */
	public static double p20(int n){
		if(n == 1) return 0;
		double logn = Math.log(n), loge = Math.log(Math.E);
		double x = logn/loge;
		return x + p20(n-1);
	}
	
	/**
	 * 1.1.27 - Calculate binomial distribution
	 * @param N - trials
	 * @param k - successes
	 * @param p - probability of success
	 * @return
	 */
	public static double binomial(int N, int k, double p){
		if ((N == 0) && (k == 0)) return 1.0;
		if ((N < 0) || (k < 0)) return 0.0;
		
		double [][] values = new double[N][k];
		
		values[0][0] = 1d;
		for(int i = 1; i < N; i++)
			values[i][0] = 0d;
		
		return (1-p) * binomial(N-1, k, p, values) + p * binomial(N-1, k-1, p, values);
	}
	
	public static double binomial(int N, int k, double p, double[][] values){
		if (N == 0 && k == 0) return values[N][k];
		if (N == 0) return 0;
		if (k == 0) {
			values[N][k] = (1-p) * binomial(N-1, k, p, values);
			return values[N][k];
		}
		return (1-p) * binomial(N-1, k, p, values) + p * binomial(N-1, k-1, p, values);
	}
	
	/**
	 * 1.1.30 - Write a code fragment that creates an N-by-N boolean array
	 * a[][] such that a[i][j] is true if i and j are relatively prime
	 * and false otherwise
	 * @param r - rows
	 * @param c - columns
	 * @return r x c boolean array
	 */
	public static boolean[][] primeArray(int r, int c){
		boolean[][] a = new boolean[r][c];
		
		int square = r < c ? r : c;
		
		for(int i = 0; i < square; i++)
			for(int j = 0; j < square/2; j++){
				boolean b = relPrime(i+1, j+1);
				a[i][j] = b; a[j][i] = b;
			}
		
		if (r < c)
			for(int i = 0; i < r; i++)
				for(int j = square; j < c; j++)
					a[i][j] = relPrime(i+1, j+1);
		else if(c < r)
			for(int i = square; i < r; i++)
				for(int j = 0; j < c; j++)
					a[i][j] = relPrime(i+1, j+1);
		
		for(int i = 0; i < (r < c ? r : c); i++)
			a[i][i] = true;
		
		return a;
	}
	
	public static boolean relPrime(int x, int y){
		int min = x < y? x : y;
		for(int i = 2; i <= min; i++)
			if ( x % i == 0 && y % i == 0) return true;
		return false;
	}
	
	/**
	 * 1.2.6 Checks of s and t are circular shifts of one another
	 * @param s - first string
	 * @param t - second string
	 * @return
	 */
	public static boolean circShift(String s, String t){
		
		if (s.length() != t.length()) return false;
		if (s.equals(t)) return true;
		int shift = 0;
		for(int i = s.length(); i >= 0 && shift == 0; i--)
			if(s.indexOf(t.substring(0, i)) != -1) shift = i;
		return shift != 0 && s.charAt(0) == t.charAt(shift);
		
	}
	
	public static void main (String [] args){
		
		String s = "AABCDEFG";
		String t = "ABCDEFGA";
		
		System.out.println(circShift(s,t));
		
	}

}
