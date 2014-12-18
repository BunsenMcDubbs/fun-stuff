import java.math.BigInteger;
import java.util.ArrayList;

public class p10 {

	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int max = Integer.parseInt(args[0]);
		for (int i = 2; i < max; i++) {
			boolean prime = true;
			int halfI = i / 2;
			for (int j = 0; j < primes.size() && primes.get(j) <= halfI && prime; j++) {
				if (i % primes.get(j) == 0 ) { prime = false; }
			}
			if (prime) {
				primes.add(i);
			}
		}
		
		//for (int i = 0; i < primes.size();) {
		//	for (int j = 0; j < 10 && i + j < primes.size(); j++) {
		//		System.out.printf("%10d", primes.get(i + j));
		//	}
		//	i += 10;
		//	System.out.println();
		//}
		
		// This didn't work because the sum was greater than the size of an integer
		// Integer overflow!
		//int sum = 0;
		//for (int prime : primes) {
		//	sum += prime;
		//}
		//System.out.println(sum);

		BigInteger sum = new BigInteger("0");
		for (int prime : primes) {
			sum = sum.add(new BigInteger("" + prime));
		}
		System.out.println(sum);
		System.out.println(primes.size());
	}
} 
