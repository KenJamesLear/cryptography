import java.util.Scanner;

public class TestMillerRabin {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Odd Integer you want to check is Prime:");
		String inputN = scanner.nextLine();
		scanner.close();
		System.out.println("Choose a random Integer such that it's greater "
				+ "than 1 and less than (" + inputN + " minus one):" );
		String inputA = scanner.nextLine();
		
		MillerRabinPrimeTest test = new MillerRabinPrimeTest(inputN, inputA);
		
	}

	
}