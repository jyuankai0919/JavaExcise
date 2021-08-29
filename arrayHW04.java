import java.util.Scanner;

public class arrayHW04 {
	public static void main(String[] args) {
	/*
	[10,12,45,90] + 23 -> [10,12,23,45,90]
	*/
	Scanner myScanner = new Scanner(System.in);
	System.out.println("plz enter a figure");

	int a = myScanner.nextInt();

	int arr[] = {10,12,45,90,90,100,800,7777};

	int arr2[] = new int[arr.length+1];
	int index = -1;

	//judged the new number's rank
	for (int i  = 0; i < arr.length; i++) {
		
		if(a <= arr[i]){
			
			index = i;
			break;
		}
	}
	if(index == -1){

			index = arr.length;
		}

	for ( int i = 0 ; i < arr2.length; i++) {
		
		if (i == index) {
			arr2[i] = a;
		}else if( i > index){
			arr2[i] = arr[i-1];
		}else{
			arr2[i] = arr[i];
		}
		System.out.print(arr2[i]+" ");
	}







	}
}