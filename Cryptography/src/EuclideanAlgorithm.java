import java.util.Scanner;



public class EuclideanAlgorithm {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while (true){
			System.out.print("First GCD number:");
			int xVar = scanner.nextInt();
			if (xVar == 0)
				break;
			System.out.print("Second GCD number:");
			int afterModVar = scanner.nextInt();
			
			int higher, lower;
			if (xVar > afterModVar){
				higher = xVar;
				lower = afterModVar;
			}
			else{
				higher = afterModVar;
				lower = xVar;
			}
			String GCDOutput = higher + " ";
			
			while (lower != 0){
				int temp = higher%lower;
				higher = lower;
				lower = temp;
				GCDOutput += higher + " ";
			}
			GCDOutput += lower;
			System.out.println(GCDOutput);
			System.out.println("GCD is " + higher);
			
		}
		
		scanner.close();
		System.out.println("Exiting Program");
	}
}
