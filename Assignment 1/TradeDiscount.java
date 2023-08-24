import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
// Programmer: Sammy Student
public class TradeDiscount
{
    public static void main(String[] args)
    {
        // declare an object that will display two decimal digits
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        // declare an object that will display the current date
        Date myDate = new Date();
        String myDateFormat = "MM/dd/yyyy";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter list price");
        int listPrice = scanner.nextInt();
        System.out.println("Enter trade discount rate");
        String rateString = scanner.nextLine();

        SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat);
        System.out.println("Today's Date is: " +
        dtToday.format(myDate));
        // display the name of the programmer
        System.out.println(" Programmer: " + " Victor Misyutin ");
        // display a test value to show that two decimals are obtained
        System.out.println(" Net amount: " + nf.format(2.575));
    }
}