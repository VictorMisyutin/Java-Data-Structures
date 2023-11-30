import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Benford {
    /** 
    An array counting how often each digit is the first digit of a number.
    Default value: 0 for each of the digits 0-9.
    */
    private int[] digitCounts;
    
    /**
    The total number of first digits counted (i.e., the sum of {@code digitCounts}. Default value: 0
    */
    private int totalCount;
    
    /** 
    The maximum width of a bar in the bar chart.
    */
    public static final int MAX_WIDTH = 50;
    
    /** 
    The Benford constructor assigns default values to the instance variables.
    */
    public Benford(){
        digitCounts = new int[10];
        totalCount = 0;
    }
    
    /**
     * The analyzeFile function counts the first digit of all of the numbers
     * in a given file and updates its statistics.
     *
     * @param filename The name of the file to analyze
     */
    public void analyzeFile(String filename){
        try {
            File file = new File(filename); // create file
            Scanner scanner = new Scanner(file); // create scanner
            String word = ""; 
            while(scanner.hasNext()){ // check that file has more content
                word = scanner.next(); // get next word in file
                if(Character.isDigit(word.charAt(0))){ // check if first character is a digit 
                    digitCounts[Integer.parseInt(String.valueOf(word.charAt(0)))] += 1; // add one to digits array
                    totalCount++; // add one to total count
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problem opening file: " + e.getMessage());
            System.exit(-1);
        }
    }
    
    /**
     * The visualizeResults function prints the results of the analysis so
     * far to Standard.out by printing how many times each digit appeared as 
     * a first digit and drawing a corresponding bar chart.
     */
    public void visualizeResults(){
        int maxCount = 0;
        for (int count : digitCounts) { // find digit with highest count
            if (count > maxCount) {
                maxCount = count;
            }
        }
        for (int i = 0; i < digitCounts.length; i++) { // iterate through all digits
            int barLength; 
            
            if (maxCount != 0){ // avoid division by zero if maxcount is equal to 0 
                barLength = Math.round(MAX_WIDTH * digitCounts[i] / (float) maxCount);
            } 
            else { 
                barLength = 0;
            }
            System.out.printf("%d %8d %4.1f%% : ", i, digitCounts[i], (digitCounts[i] / (float) totalCount)*100);
            for (int j = 0; j < barLength; j++) { // prints appropriate amount of stars
                System.out.print("*");
            }
    
            System.out.println();
        }
    }

    //
    public static void main(String[] args){
        if(args.length == 0){ // check if user added any arguments
            System.out.println("Please remeber to include at least one file name in the command line arguements");
            System.exit(-1); // exit gracefully 
        }
        Benford benford = new Benford(); // create instance of Benford class
        for(String filename : args){
            benford.analyzeFile(filename);
            benford.visualizeResults();
        }
    }

}
