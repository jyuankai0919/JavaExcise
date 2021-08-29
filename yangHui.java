public class yangHui {
	public static void main(String[] args) {
		
		/*
		1
		1 1
		1 2 1
		1 3 3 1
		1 4 6 4 1
		1 5 10 10 5 1
		......
		*/
		int arr[][] = new int[30][];

		for (int i = 0 ; i < arr.length; i++) {
			arr[i] = new int[i + 1];

			for ( int j = 0; j < arr[i].length; j++ ) {
				
				if (j == 0 || j == arr[i].length-1) {
					
					arr[i][j] = 1 ;

				}else{

					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				}
				System.out.print(arr[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}