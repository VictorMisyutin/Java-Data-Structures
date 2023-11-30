/**
 * Explore using arrays
 * 
 * @author Your Name Goes Here
 */
import java.util.Scanner;
public class Arrays {
     /**
     * The main function is the implementation of our program.
     * 
     * @param args The command line arguments, unused
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many numbers would you like to enter into your array?");
        int num1 = scanner.nextInt();
        int[] arr = new int[num1];

        for(int i=0; i<num1; i++) {
            System.out.println("Enter an int: ");
            int x = scanner.nextInt();
            arr[i] = x;

        }
        scanner.close();
        //int num2 = scanner.nextInt();
        //int[] arr = new int[num1];
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);

        }
        // TODO: implement your solution here
    }

}