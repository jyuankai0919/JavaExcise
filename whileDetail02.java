// test01

// public class whileDetail02 {
// 	public static void main(String[] args) {
		
// 		int  i =  1;


// 		int sum = 0; 
// 		do{

// 			if (i % 5 == 0 && i % 3 != 0) {

// 				System.out.println("no." + i);
// 				sum = sum + i;

// 			}
// 			i++;

// 		}while(i <= 200);

// 	System.out.println("sum:" + sum);


// 	}
// }


// test02
import java.util.Scanner;
public class whileDetail02 {

	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		char ans = ' ';

		do{

			System.out.println("Do you pay back the money?");
			System.out.println("(y/n)");
			ans = myScanner.next().charAt(0);
			System.out.println("his ans is :" + ans );

		}while(ans != 'y');

		System.out.println("he paid it back~");

	}
}
