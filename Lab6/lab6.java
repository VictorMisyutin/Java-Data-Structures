// Program Writer: Victor Misyutin
import java.util.Scanner;
import java.io.*;
public class lab6 {
    public static void main (String[] args) throws IOException{
        // declare a Scanner class object
        Scanner sc = new Scanner(System.in);
        // assign a file name and declare the file objects
        String myFile = "C:\\Users\\misyu\\OneDrive\\Desktop\\New folder\\data.txt";
        FileWriter file;
        file = new FileWriter(myFile);
        PrintWriter outfile = new PrintWriter(file);       
        // assign a file name and declare the file objects
        String dataFile = "C:\\Users\\misyu\\OneDrive\\Desktop\\New folder\\data.txt";
        String line = "";
        String csv = ",";
        FileReader fileIn = new FileReader(dataFile);
        BufferedReader br = new BufferedReader(fileIn);
        // variable for the number of records in the data table
        int numRecords = 0;
        // variables for the fields of the data table
        String strName = "";
        double dblCost = 0;
        int intQuantity = 0;
        char chrLocation = '\0';
        // input the number of records to be processed
        // WRITE THE DATA
        System.out.println("How many records are for processing?");
        numRecords = sc.nextInt();
        for (int i = 1; i <= numRecords; i++){
            // obtain user input
            sc.nextLine();
            System.out.println("item description");
            strName = sc.nextLine();
            System.out.println("item cost");
            dblCost = sc.nextDouble();
            System.out.println("item quantity");
            intQuantity = sc.nextInt();
            System.out.println("item location");
            chrLocation = sc.next().charAt(0);
            // write the data to the file
            outfile.print(strName + ",");
            outfile.print(dblCost + ",");
            outfile.print(intQuantity + ",");
            outfile.println(chrLocation);
        }
        outfile.close(); 
        // read the data and store some information for analysis
        int numItems = 0;
        int itemsB = 0;
        int moreThan50 = 0;
        int totalQuantity = 0;
        try{
            while ((line = br.readLine()) != null)
            {
                numItems++;
                // use comma as a value separator
                String[] data = line.split(csv);
                System.out.println(data[0] + ",$" + data[1] + "," + data[2] + "," + data[3]);
                if(data[3].equals("B"))
                    itemsB++;
                totalQuantity += Integer.parseInt(data[2]);
                if(Double.parseDouble(data[1]) > 50)
                    moreThan50++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    
        // ANALYZE THE DATA
        System.out.println("There are " + numItems + " distict items in stock.");
        // find number of items at location B
        System.out.println("There are " + itemsB + " items at location B.");
        // find number of items that cost more than $50
        System.out.println("There are " + moreThan50 + " items that cost more than $50.");
        // find total quantity of items in stock
        System.out.println("There are " + totalQuantity + " total quantity of items in stock.");
        sc.close();
        br.close();
    }
}
