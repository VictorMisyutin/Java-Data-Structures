package Lab12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;

public class Transactions {
    public static final File file = new File("C:\\Users\\misyu\\OneDrive\\Desktop\\Coding\\Java\\Labs\\Lab12\\Transactions.txt"); // stores data file
    
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String userIn = "";
        System.out.println("Press 0 to get data or type the amount of entries you would like to add:");
        userIn = scanner.nextLine();

        if(userIn.equals("0"))
            getData();
        else
            for(int i = 0 ; i < Integer.parseInt(userIn) ; i++){
                writeData(scanner);
            }
    }

    public static void getData(){
        DecimalFormat df = new DecimalFormat("0.00"); // for formatting money
        int numRecords = 0; // stores the total number of records
        float totReward = 0; // stores total reward cash issues
        float totPurchased = 0; // stores total purchased amount
        boolean first = true; // for knowing the first time the while loop is ran
        ArrayList<String> dates = new ArrayList<String>(); // stores all dates of transactions
        HashSet<String> nonMembers = new HashSet<String>(); // stores customer number of all non members
        Scanner fileScanner = null; // create scanner
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) { // loop through each line in data file
                String line = fileScanner.nextLine(); 
                String[] arr = line.split(","); 
                System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2] + ", " + arr[3] + ", " + arr[4] + ", " + arr[5]);
                if(arr[1].equals("No")){ 
                    nonMembers.add(arr[0]); // add non members to the hash map
                }
                if(first) // check if first line
                    first = false;
                else{ // update variables
                    numRecords++;
                    totReward += Float.parseFloat(arr[5]);
                    totPurchased += Float.parseFloat(arr[3]);
                    dates.add(arr[2]);
                }
            }

            String oldest = dates.get(0); // oldest date of transaction
            String mostRecent = dates.get(dates.size()-1); // most recent date of transaction
            String sDate1 = ""; // for iterating through dates
            
            for(int i = 0; i < dates.size() ;i++){
                sDate1 = dates.get(i);
                Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);
                Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(oldest);
                Date date3 = new SimpleDateFormat("MM/dd/yyyy").parse(mostRecent);
                long diff = date2.getTime() - date1.getTime();
                if(diff > 0) // if current date is older than oldest date
                    oldest = sDate1;
                diff = date3.getTime() - date1.getTime();
                if(diff < 0) // if current date is more recent than most recent date
                    mostRecent = sDate1;
            }

            // output info 

            System.out.println("\nNumber of records: " + (numRecords-1));
            System.out.println("Total rewarded cash: " + df.format(totReward));
            System.out.println("Total purchased amount: " + df.format(totPurchased));
            System.out.println("Ratio of rewarded cash to the total customer purchases: " + (totReward / totPurchased));
            System.out.println("Total number of non-members: " + (nonMembers.size()));
            System.out.println("Transaction dates range from: " + oldest + " to " + mostRecent);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            fileScanner.close();
        }
    }

    public static void writeData(Scanner scanner){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
            System.out.println("Please enter the customers number: ");
            String field1 = scanner.nextLine() + ",";
            System.out.println("Enter 1 if this customer is a member and 0 otherwise: ");
            String field2 = (scanner.nextLine().equals("1")? "Yes" : "No")+ ",";
            System.out.println("Please enter the transaction date in the format \"MM/dd/yyyy\": ");
            String field3 = scanner.nextLine() + ",";
            System.out.println("Please enter the purchase amount: ");
            String field4 = scanner.nextLine() + ",";
            System.out.println("Please enter the coupon amount used: ");
            String field5 = scanner.nextLine() + ",";
            System.out.println("Please enter the reward cash issued: ");
            String field6 = scanner.nextLine() + ",";
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(field1);
            bw.write(field2);
            bw.write(field3);
            bw.write(field4);
            bw.write(field5);
            bw.write(field6 + "\n");
            System.out.println("data recorded!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("Transaction added successfully.\n");
    }
}