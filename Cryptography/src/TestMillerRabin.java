import java.util.Scanner;
import java.math.BigInteger;

public class TestMillerRabin {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Odd Integer you want to check is Prime:");
		String inputN = scanner.nextLine();
		BigInteger n = new BigInteger(inputN);
		BigInteger nMinusOne = n.subtract(BigInteger.ONE);
		System.out.println("Choose a random Integer such that it's greater "
				+ "than 1 and less than " + nMinusOne + ":" );
		String inputA = scanner.nextLine();
		scanner.close();
		MillerRabinPrimeTest test = new MillerRabinPrimeTest(inputN, inputA);
		test.run();
		
	}

	
}