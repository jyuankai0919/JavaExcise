import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        System.out.println("終於可以打中文了");
        MyTools myTools = new MyTools();
        int[] arr = {10, -11, 20, 0, 34, 50};

        Scanner myScanner = new Scanner(System.in);

        myTools.bubble(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}

class MyTools {

    public void bubble(int[] arr) {
        //冒泡排序
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
