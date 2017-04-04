import java.util.Scanner;
import java.math.BigInteger;

public class TestMillerRabin {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Odd Integer you want to check is Prime:");
		String inputN = scanner.nextLine();
		BigInteger n = new BigInteger(inputN);
		BigInteger nMinusOne = n.subtract(BigInteger.ONE);
<<<<<<< HEAD
		//begin here with option A
		System.out.println("Select one of the following options:");
		System.out.println("1: Choose the a you want to use");
		System.out.println("2: Choose number of random a's tested");
		int choice = Integer.parseInt(scanner.nextLine());
		if (choice == 1){
			System.out.println("Choose a random Integer such that it's greater "
					+ "than 1 and less than " + nMinusOne + ":" );
			String inputA = scanner.nextLine();
			MillerRabinPrimeTest test = new MillerRabinPrimeTest(inputN, inputA);
			test.run();
		}
		else if (choice ==2){
			System.out.println("Choose number of random a's to test:");
			int numOfA = scanner.nextInt();
			MillerRabinPrimeTest test = new MillerRabinPrimeTest(inputN);
			test.run(numOfA);
		}
=======
		System.out.println("Choose a random Integer such that it's greater "
				+ "than 1 and less than " + nMinusOne + ":" );
		String inputA = scanner.nextLine();
>>>>>>> refs/remotes/origin/master
		scanner.close();
	}

	
}