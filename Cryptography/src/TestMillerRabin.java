//This is the program that will execute the test and request input for the program. 

import java.util.Scanner;
import java.math.BigInteger;

public class TestMillerRabin {
	public static void main(String args[]){
		
		//Here it setting up to receive input for what odd number you want to check is prime
		Scanner scanner = new Scanner(System.in);
		System.out.println("Odd Integer you want to check is Prime:");
		String inputN = scanner.nextLine();
		//This is the variable 'n' that will be tested if it is prime
		BigInteger n = new BigInteger(inputN);

		//choose to run the test with two options
		//first option allows user to select the 'a' they want to use for test
		//second option allows user to select amount of random integers selected to run test
		System.out.println("Select one of the following options:");
		System.out.println("1: Choose the a you want to use");
		System.out.println("2: Choose number of random a's tested");
		int choice = Integer.parseInt(scanner.nextLine());
		//Begin first option
		if (choice == 1){
			//Get n-1 to be able to ask for an 'a' in range of 1 to n-1
			BigInteger nMinusOne = n.subtract(BigInteger.ONE);
			//Get input for what 'a' you want to use
			System.out.println("Choose a random Integer such that it's greater "
					+ "than 1 and less than " + nMinusOne + ":" );
			String inputA = scanner.nextLine();
			//Create new object for test with n and a
			MillerRabinPrimeTest test = new MillerRabinPrimeTest(inputN, inputA);
			//Begin running test
			test.run();
		}
		//Begin second option
		else if (choice ==2){
			//Get the number of random a's that you want used
			System.out.println("Choose number of random a's to test:");
			int numOfA = scanner.nextInt();
			//Create new object for test with just n. 
			MillerRabinPrimeTest test = new MillerRabinPrimeTest(inputN);
			//being running of test with number of A's you want used. 
			test.run(numOfA);
		}

		scanner.close();
	}

	
}