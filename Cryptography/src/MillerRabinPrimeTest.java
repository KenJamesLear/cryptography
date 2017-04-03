import java.math.BigInteger;
import java.util.Random;

public class MillerRabinPrimeTest {
	private BigInteger n;
	private BigInteger a;
	private BigInteger nMinusOne;
	private static BigInteger zero = BigInteger.ZERO;
	private static BigInteger one = BigInteger.ONE;
	private static BigInteger two = one.add(one);
	
	public MillerRabinPrimeTest(String inputN, String inputA){
		n = new BigInteger(inputN);
		a = new BigInteger(inputA);
		nMinusOne = n.subtract(one);
	}
	
	public MillerRabinPrimeTest(String inputN){
		n = new BigInteger(inputN);
		nMinusOne = n.subtract(one);
	}
	
	
	public void run(){
		boolean result = false;
		
		BigInteger m = mFinder(n);
		BigInteger b = a.modPow(m, n);
		int bNumber = 0;
		
		//special case to ask about
		BigInteger nMinusOnedivTwo = (n.subtract(one)).divide(two);
		BigInteger specialCase = a.modPow(nMinusOnedivTwo, n);
		System.out.println("Special case: " + specialCase);
		
		System.out.println("B"+ bNumber + " = " + b + " mod " + n);
		if ((b.equals(BigInteger.ONE)) || (b.equals(nMinusOne)))
			result = true;
		else	
		{
			//int test = 0;
			while(true){
				bNumber++;
				BigInteger bNext = b.modPow(two, n);
				System.out.println("B"+ bNumber + " = " + bNext + " mod " + n);
				//special case to ask about
				if (bNext.equals(b)){
					break;
				}
				//special case to ask about
				if(bNext.equals(specialCase)){
					break;
				}
				if (bNext.equals(one)){
					break;
				}
				else if (bNext.equals(nMinusOne)){
					result = true;
					break;
				}
				else{
					b = bNext;
				}
				//test++;
			}
		}
		
		if (result){
			System.out.println(n + " is probably prime");
		}
		else{
			System.out.println(n + " is composite and gcd(" + n + "," + b.subtract(one) + ")" + 
					"is a non-trivial factor");
		}
	}
	
	public void run(int numOfA){
		
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
		System.out.println("m equal = " + m);
		//System.out.println("k equal = " + k);
		
		return m;
	}
	
}	
	
