import java.util.Scanner;
import java.math.BigInteger;

public class MillerRabinPrimeTest {
	public static void main(String[] args){
		
		BigInteger one = BigInteger.ONE;
		BigInteger two = one.add(one);
		
		Scanner scanner = new Scanner(System.in);
		
		//getting the integer you want to check if it is prime
		BigInteger n = BigInteger.ZERO;
		String inputN = "";
		while(true){
			System.out.println("Odd Integer you want to check is Prime:");
			inputN = scanner.nextLine();
		
			n = new BigInteger(inputN);
			if (isOdd(n) == true){
				break;
			}
			System.out.println("Invalid n, please pick an odd number");
		}
		
		//finding m
		BigInteger m = mFinder(n);
		//System.out.println("m is odd = " + isOdd(m));
		
		
		//begin step 2
		//getting the random integer a that is between 1 and n-1
		//might have to chance later to have multiple a's or maybe random?
		System.out.println("Choose a random Integer such that it's greater "
				+ "than 1 and less than (" + inputN + " minus one):" );
		String inputA = scanner.nextLine();
		BigInteger a = new BigInteger(inputA);
		
		//test modpow
		/*BigInteger one = BigInteger.ONE;
		BigInteger two = one.add(one);
		BigInteger three = two.add(one);
		BigInteger test = two.modPow(two, three);
		System.out.println("test = " + test);*/
		
		//begin step 3
		BigInteger b = a.modPow(m, n);
		if (b.equals(BigInteger.ONE))
			System.out.println(b + " is probably prime");
		else
		{
			BigInteger bNext = b.modPow(two, n);
		}
		
		scanner.close();
	}
	
	public static boolean isOdd(BigInteger n){
		return !n.mod(new BigInteger("2")).equals(BigInteger.ZERO);
	}
	
	public static BigInteger mFinder(BigInteger n){
		//need to comment this
		BigInteger one = BigInteger.ONE;
		BigInteger two = one.add(one);
		BigInteger m = BigInteger.ZERO;
		BigInteger temp = BigInteger.ZERO;
		BigInteger nMinusOne = n.subtract(one);
		int k = 0;
		while(true){
			k++;
			temp = nMinusOne.mod(two.pow(k));
			if (temp.equals(BigInteger.ZERO)){
				m = nMinusOne.divide(two.pow(k));
				if (isOdd(m))
					break;
			}
		}
		
		//test lines
		System.out.println("m equal = " + m);
		System.out.println("k equal = " + k);
		
		return m;
	}
}
