import java.math.BigInteger;

public class MillerRabinPrimeTest {
	private BigInteger n;
	private BigInteger a;
	private static BigInteger zero = BigInteger.ZERO;
	private static BigInteger one = BigInteger.ONE;
	private static BigInteger two = one.add(one);
	private static BigInteger negativeOne = one.subtract(two);
	
	
	public MillerRabinPrimeTest(String inputN, String inputA){
		n = new BigInteger(inputN);
		a = new BigInteger(inputA);
	}
	
	
	public void run(){
		boolean result = false;
		
		BigInteger m = mFinder(n);
		BigInteger b = a.modPow(m, n);
		int bNumber = 0;
		System.out.println("B"+ bNumber + " = " + b + " mod " + n);
		if ((b.equals(BigInteger.ONE)) || (b.equals(negativeOne)))
			result = true;
		else	
		{
			while(true){
				bNumber++;
				BigInteger bNext = b.modPow(two, n);
				System.out.println("B"+ bNumber + " = " + bNext + " mod " + n);
				if (bNext.equals(one)){
					break;
				}
				else if (bNext.equals(negativeOne)){
					result = true;
					break;
				}
				else{
					b = bNext;
				}
			}
		}
		
		if (result){
			System.out.println(n + " is probably prime");
		}
		else{
			System.out.println(n + " is probably composite");
		}
	}
	
	private static boolean isOdd(BigInteger n){
		return !n.mod(new BigInteger("2")).equals(BigInteger.ZERO);
	}
	
	private static BigInteger mFinder(BigInteger n){
		//need to comment this
		BigInteger m = zero;
		BigInteger temp = zero;
		BigInteger nMinusOne = n.subtract(one);
		int k = 0;
		while(true){
			k++;
			temp = nMinusOne.mod(two.pow(k));
			if (temp.equals(zero)){
				m = nMinusOne.divide(two.pow(k));
				if (isOdd(m))
					break;
			}
		}
		
		//test lines
		//System.out.println("m equal = " + m);
		//System.out.println("k equal = " + k);
		
		return m;
	}
	
}	
	
