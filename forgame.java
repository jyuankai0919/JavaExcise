import java.util.Scanner;

public class forgame{
	public static void main(String[] args) {
		
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("plz enter the number floor");
		int floor = myScanner.nextInt();	

		for (int i = 1; i <= floor; i++) {

			for (int k = 1; k <= floor - i; k++ ) {
				// 4
				// 3
				
				// 2
				// 1
				System.out.print(" ");
			}
			
			for (int j = 1; j <= 2 * i - 1; j++) {

				if (j == 1 || j == 2 * i - 1 ||j % 2 !=0) {
				
					System.out.print("*");

					// if (i == floor ) {
					// 		
					// 		System.out.print("*");
					// 	}else{
					// 		System.out.print(" ");
					// 	}

				}else{
					System.out.print(" ");
				}
				
			}

			System.out.print("\n");
		}

	}
}