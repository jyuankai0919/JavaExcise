import java.util.Scanner;
public class Input {

	public static void main(String[] args){

	Scanner myScanner = new Scanner(System.in);

	System.out.println("mame");
	String name = myScanner.next();

	System.out.println("age");
    int age = myScanner.nextInt();

    System.out.println("salary");
	double sal = myScanner.nextDouble();

	System.out.println("imformation");
	System.out.println("name=" + name + "\t" + "age=" + age + "\t" + "salary=" + sal);
	
	}

}





