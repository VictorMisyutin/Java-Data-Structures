/**
 * A virtual park
 * 
 * @author Your Name Goes Here
 */
import java.util.Scanner;

public class Park {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the first dog?");
        String dog1 = scanner.nextLine();

        System.out.println("What is the name of the second dog?");
        String dog2 = scanner.nextLine();
        String[] dogs = new String[4];
        dogs[0] = dog1;
        dogs[1] = dog2;
        for(int i=0; i<2; i++) {
            Dog x=new Dog(dogs[i]);
            x.speak();
            x.play();
           
        }
        dogs[2] = "Katniss";
        dogs[3] = "Yeobie";
        Squirrel y = new Squirrel(dogs[3]);
        y.speak();
        y.play();
        Cat k = new Cat(dogs[2]);
        k.speak();
        k.play();


    }
    
}
