/**
 * 1.2.16 API Implementation for Rational numbers
 * @author andrew
 *
 */
public class Rational {
	
	private final int num, den;
	
	/**
	 * Instantiates a new Rational object. Numerator and
	 * denominator of the object are guaranteed to have no
	 * common factors.
	 * @param numerator of the rational number
	 * @param denominator of the rational number
	 */
	public Rational(int numerator, int denominator){
		if(denominator < 0)
			numerator *= -1;
		int gcd = gcd(numerator, denominator);
		this.num = numerator / gcd;
		this.den = Math.abs(denominator) / gcd;
	}
	
	/**
	 * Returns a new Rational object with the sum of this
	 * Rational and the Rational b
	 * @param b - Rational to be added to this
	 * @return new Rational object with the sum
	 */
	public Rational plus(Rational b){
//		int lcd = lcd (this, b);
		int ar = b.den, br = den;
		int newNum = num * ar + b.num * br;
		return new Rational (newNum, ar * br);
	}
	
	/**
	 * Returns a new Rational object with the difference
	 * between this Rational object and b
	 * @param b - Rational number to be subtracted from this
	 * @return new Rational object with the difference
	 */
	public Rational minus(Rational b){
		return plus(new Rational(-b.num, b.den));
	}
	
	/**
	 * Returns a new Rational object with the result of
	 * multiplying this Rational and Rational b
	 * @param b
	 * @return
	 */
	public Rational times(Rational b){
		return new Rational(num * b.num, den * b.den);
	}
	
	/**
	 * Returns a new Rational object with the quotient of
	 * this Rational and divisor Rational b
	 * @param b - divisor
	 * @return
	 */
	public Rational dividedBy (Rational b){
		return times(new Rational(b.den, num));
	}
	
	public boolean equals(Object that){
		Rational b = (Rational) that;
		return num == b.num && den == b.den;
	}
	
	public String toString(){
		return "" + num + "/" + den;
	}
	
	/**
	 * Finds the least common denominator between two rational
	 * numbers
	 * @param a
	 * @param b
	 * @return
	 */
	public static int lcd(Rational a, Rational b){
		int denA = a.den, denB = b.den;
		int min = denA < denB ? denA : denB, max = denA * denB;
		int i = min;
		while (i <= max && i % denA == 0 && i % denB == 0) i++;
		return i;
	}
	
	/**
	 * Returns the greatest common denominator between two numbers
	 * @param p
	 * @param q
	 * @return
	 */
	public static int gcd(int p, int q){
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}
	
	/**
	 * Unit testing
	 * @param args
	 */
	public static void main(String[] args){
		Rational a = new Rational(4,3),
				b = new Rational(5,5);
		System.out.println("" + a + " + " + b + " = " + a.dividedBy(b));
	}

}
