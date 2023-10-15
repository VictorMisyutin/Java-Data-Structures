import java.text.NumberFormat; 
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.Scanner; 
public class GrossPay 
{
    public static void main(String[] args){
        // Create variables
        String name;
        String flatRateIn;
        boolean flatRate;
        double grossPay;
        double medicareTax;
        double FICATax;
        double FITTax;
        double netPay;
        int numItems;
        int tempNumItems;

        final double FLAT_RATE_PAY = 7.5;
        final double PAY_LEVEL_ONE_RATE = 7.15;
        final double PAY_LEVEL_TWO_RATE = 7.45;
        final double PAY_LEVEL_THREE_RATE = 7.95;
        final double PAY_LEVEL_FOUR_RATE = 8.4;
        final double MEDICARE_RATE = 0.0145;
        final double FICA_RATE = 0.0620;
        final double FIT_RATE = 0.25;

        Scanner scanner = new Scanner(System.in);
        
        // get user input
        System.out.println("Please enter the employees name: ");
        name = scanner.nextLine();
        System.out.println("Would you like to use a flat rate: (y/n)");
        flatRateIn = scanner.nextLine();

        // process

        if(flatRateIn.equals("y")){
            flatRate = true;
            System.out.println("You have chosen the flat rate $7.50");
        }
        else{
            flatRate = false;
            System.out.println("You have chosen the diferential pay schedule\n");
        }
        System.out.println("Please enter the number of items produced by the employee:");
        numItems = scanner.nextInt();
        tempNumItems = numItems;
        scanner.close();
        
        // CAN I USE A SWITCH STATEMENT HERE
        
        if (tempNumItems <= 112 && !flatRate){
            grossPay = tempNumItems*PAY_LEVEL_ONE_RATE;
        }
        else if(tempNumItems <= 150 && !flatRate){
            grossPay = 112*PAY_LEVEL_ONE_RATE;
            tempNumItems -= 112;
            grossPay += tempNumItems*PAY_LEVEL_TWO_RATE;
        }
        else if(tempNumItems <=217 && !flatRate){
            grossPay = 112*PAY_LEVEL_ONE_RATE;
            grossPay += 38*PAY_LEVEL_TWO_RATE;
            tempNumItems -= 150;
            grossPay += tempNumItems*PAY_LEVEL_THREE_RATE;
        }
        else if(!flatRate){
            grossPay = 112*PAY_LEVEL_ONE_RATE;
            grossPay += 38*PAY_LEVEL_TWO_RATE;
            grossPay += 67*PAY_LEVEL_THREE_RATE;
            tempNumItems -= 217;
            grossPay += tempNumItems*PAY_LEVEL_FOUR_RATE;
        }
        else{
            grossPay = numItems*FLAT_RATE_PAY;
        }

        medicareTax = grossPay * MEDICARE_RATE;
        FICATax = grossPay * FICA_RATE;
        FITTax = grossPay * FIT_RATE;
        netPay = grossPay - medicareTax - FICATax - FITTax;

        // OUTPUT

        // declare an object that will display two decimal digits 
        NumberFormat nf = NumberFormat.getCurrencyInstance(); 
        // declare an object that will display the current date 
        Date myDate = new Date(); 
        String myDateFormat = "MM/dd/yyyy"; 
        SimpleDateFormat dtToday = new 
        SimpleDateFormat(myDateFormat); 
        System.out.println("-----------------------------------");
        System.out.println("Employee Name:                " + name);
        System.out.println("Items Produced:               " + numItems);
        System.out.println("Current Gross Pay:            " + nf.format(grossPay));
        System.out.println("Current flatRate choice is:   " + flatRateIn);
        System.out.println("Medicare tax:                 " + nf.format(medicareTax));
        System.out.println("FICA tax:                     " + nf.format(FICATax));
        System.out.println("Federal tax:                  " + nf.format(FITTax));
        System.out.println("Your net pay is:              " + nf.format(netPay));
        System.out.println("Today's Date is: " + dtToday.format(myDate)); 
        // display the name of the programmer 
        System.out.println("Programmer: " + " Victor Misyutin "); 
        // display a dummy value to show that two decimals are obtained 
    }    
}
