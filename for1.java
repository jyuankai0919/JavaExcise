public class for1 {
	public static void main(String[] args) {
		

		int count = 0; //demand's number
		int sum = 0; //totle of demand
		int start = 1; //for start
		int end = 5000; // for end
		int c = 5 ; //if's condition

		for (int i = start; i <= end; i++) {
			
			if (i % c == 0 ) {
				System.out.println("i=" + i);
				count+=1;
				sum = sum + i;
			}
		}
		System.out.println("no." + count );
		System.out.println("totle:" + sum );



	}

}