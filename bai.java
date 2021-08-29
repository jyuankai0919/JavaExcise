public class bai {

	public static void main(String[] args) {
		
		Tower tower = new Tower();
		tower.move(11,'1','2','3');
		


	}
}

class Tower{

	int sum = 0 ;

	public void move(int num , char a, char b, char c){
		
		if (num == 1 ) {
			System.out.print(a + "->" + c + " ");
			System.out.println(sum += 1);

		}else{

			move( num - 1, a, c, b);

			System.out.print(a + "->" + c + " ");
			System.out.println(sum += 1);

			move( num - 1, b, a, c);
		}
	}

}