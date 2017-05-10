//Program that actually computes and executes the Miller Rabin Primality test
//test line

import java.math.BigInteger;
import java.util.Random;
import java.util.LinkedList;
import java.util.Random;

public class MillerRabinPrimeTest {
	//creation of global variables that are used in various functions of the test
	private static BigInteger n;
	private static BigInteger a;
	private static BigInteger nMinusOne;
	private static BigInteger bForDisplay;
	private static BigInteger zero = BigInteger.ZERO;
	private static BigInteger one = BigInteger.ONE;
	private static BigInteger two = one.add(one);
	
	//Creation of test object with n and a being known
	public MillerRabinPrimeTest(String inputN, String inputA){
		n = new BigInteger(inputN);
		a = new BigInteger(inputA);
		nMinusOne = n.subtract(one);
	}
	
	//Creation of test object with n known and a is unknown
	//a has a default value of one here
	public MillerRabinPrimeTest(String inputN){
		n = new BigInteger(inputN);
		nMinusOne = n.subtract(one);
		a = one;
	}
	
	//Running the test with 'a' value assumed to be known, by default is one
	public void run(){
		boolean result;
		result = calculate();
		displayResult(result, 1);
	}
	
	public void run(int numOfA){
		boolean result[] = new boolean[numOfA];
		for (int i = 0; i < numOfA; i++){
		 a = randomize(n);
		 System.out.println("----- New test -----");
		 result[i]=calculate();
		 System.out.println(result[i]);
		}
		boolean finalResult = areAllTrue(result);
		 displayResult(finalResult, 2);
	}
	
	public static boolean areAllTrue(boolean[] array)
	{
	    for(boolean b : array) if(!b) return false;
	    return true;
	}
	
	private static boolean isOdd(BigInteger n){
		// checks if 0 = n (mod 2) and returns opposite result
		//if the statement is true then n is even meaning not odd and vice versa
		return !n.mod(new BigInteger("2")).equals(BigInteger.ZERO);
	}
	
	private static BigInteger mFinder(BigInteger n){
		//set variable that will be used
		BigInteger m = zero;
		BigInteger temp = zero;
		BigInteger nMinusOne = n.subtract(one);
		int k = 0;
		//loops through until if finds an m where 2^k * m = n where m is odd
		while(true){
			k++;
			temp = nMinusOne.mod(two.pow(k));
			if (temp.equals(zero)){
				m = nMinusOne.divide(two.pow(k));
				//breaks if m is odd
				if (isOdd(m))
					break;
			}
		}
		
		return m;
	}
	
	private void displayResult(boolean result, int code){
		if (result){
			System.out.println(n + " is probably prime");
		}
		//else say that n is composite and show the non-trivial factor
		else if(!result && code == 1){
			System.out.println(n + " is composite and gcd(" + n + "," + bForDisplay.subtract(one) + ")" + 
					"is a non-trivial factor");
		}
		else {
			System.out.println(n + " is composite");
		}
	}
	
	private BigInteger randomize(BigInteger max){
		BigInteger result = zero;	
		Random rnd = new Random();
		do {
		    result = new BigInteger(n.bitLength(), rnd);
		} while ((result.compareTo(n) >= 0) || (result.signum() != 1));
		return result;
	}
	
	
	private boolean calculate(){
		// things result is false until proven otherwise, thus default is false
				boolean result = false;
				
				//determine what m could be by using m finder
				BigInteger m = mFinder(n);
				//calculate what the first b should be by using b = a^m (mod n)
				BigInteger b = a.modPow(m, n);
				//this is a counter to currently show what number b we are using 
				int bNumber = 0;
				
				System.out.println("n = " + n);
				System.out.println("a = " + a);
				System.out.println("m = " + m);
				
				//special case
				//Checking to see find value of  a^((n-1)/2) 
				//While in main loop of algorithm, if this value = current b value then n is composite
				/*BigInteger nMinusOnedivTwo = (n.subtract(one)).divide(two);
				BigInteger specialCase = a.modPow(nMinusOnedivTwo, n);
				//test line to see special case output
				System.out.println("Special case: " + specialCase);*/
				
				//Print out first b and it's value
				System.out.println("B"+ bNumber + " = " + b + " mod " + n);
				//If first b equals 1 or -1 (which is n-1) then result is true
				if ((b.equals(BigInteger.ONE)) || (b.equals(nMinusOne)))
					//set result to true because n is prime in this case
					result = true;
				//else the test continues
				else	
				{
					//make a list to hold all bValues so that we can compare to see if there is an infinite loop 
					//while running the test, thus meaning the n is composite
					LinkedList<BigInteger> bValues = new LinkedList<BigInteger>();
					while(true){
						//raise the interval of the bNumber
						bNumber++;
						//get the next b by having it equal previous b^2 mod n
						bValues.add(b);
						BigInteger bNext = b.modPow(two, n);
						//Print out result of the new b number
						System.out.println("B"+ bNumber + " = " + bNext + " mod " + n);
						//If the next b value is the same as a previous b value, then break out of loop
						//if current b equal one break out of loop
						if (bNext.equals(one)){
							break;
						}
						//if b equals -1 (being the same as n-1), break out of loop
						else if (bNext.equals(nMinusOne)){
							//set result to true because it is prime in this case
							result = true;
							break;
						}
						else if (bValues.contains(bNext))
						{
							break;
						}
						//If bNext equals the special case value, break out of loop
						/*else if(bNext.equals(specialCase)){
							break;
						}*/
						
						//if current b equal one break out of loop
						else if (bNext.equals(one)){
							break;
						}
						//if b equals -1 (being the same as n-1), break out of loop
						else if (bNext.equals(nMinusOne)){
							//set result to true because it is prime in this case
							result = true;
							break;
						}
						//if everything is false then loop to the next b
						else{
							b = bNext;
						}
						
					}
					bForDisplay = b;
				}
				return result;
	}
	
	
}	
	
