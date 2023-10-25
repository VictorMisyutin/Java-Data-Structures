package Lab1;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;
// Programmer: Victor Misyutin
// Todays Date: 8/24/2023
// Lab 1
public class TradeDiscount
{
    public static void main(String[] args)
    {
        
        // declare scanner
        Scanner scanner = new Scanner(System.in);
        
        // inputs
        
            // username 
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
            // item description
        System.out.println("Please enter the item description:");
        String description = scanner.nextLine();
            // list price
        System.out.println("Please enter the list price:");
        double listPrice = scanner.nextDouble();
            // trade discount rate
        System.out.println("Enter trade discount rate:");
        double discountRate = scanner.nextDouble();
        scanner.nextLine(); // fix skipping input
            // salesperson 
        System.out.println("Please enter the Saleperson's name:");
        String salesperson = scanner.nextLine();
        System.out.println("-----------");
        // process (formulas)
        double tradeDiscount = listPrice*discountRate;
        double netPriceAmt = listPrice - tradeDiscount;
        double taxRate  = 0.06075;
        double salesTax = netPriceAmt * taxRate;
        int shippingFee = 75;
        double commisionRate = 0.2;
        double commision = netPriceAmt * commisionRate;
        double grossTotal = netPriceAmt + salesTax + shippingFee;
        
        // close scanner
        scanner.close();
        
        // setup calander and dates
        Date currentDate = new Date();
        String myDateFormat = "MM/dd/yyyy";
        SimpleDateFormat dtFormat = new SimpleDateFormat(myDateFormat);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        Date nextWeek = cal.getTime();
        
        
        // output (and some formatting)
        
        // declare an object that will display two decimal digits
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        System.out.println("The trade discount is only valid for the next 7 days (until " +dtFormat.format(nextWeek) + ")\n");
        System.out.println("Username: " + username);
        System.out.println("Item Description: " + description);
        System.out.println("List Price: " + listPrice);
        System.out.println("Rate: " + discountRate);
        System.out.println("Trade Discount: " + nf.format(tradeDiscount));
        System.out.println("Net amount: " + nf.format(netPriceAmt));
        System.out.println("Sales tax: " +  nf.format(salesTax));
        System.out.println("Total Purchase Amount: " +  nf.format(grossTotal));
        System.out.println("Commision Amount: " +  nf.format(commision));
        System.out.println("Salesperson: " + salesperson);
        System.out.println(" Today's Date is: " + dtFormat.format(currentDate));
        System.out.println(" Programmer: " + " Victor Misyutin ");


    }
}