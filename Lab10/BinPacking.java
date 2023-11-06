// Victor Misyutin
// 11-3-2023
// CSC 241

package Lab10;
import java.util.ArrayList;
import java.util.*;
class BinPacking {
    int capacity;
    int itemsToPack[] = new int[100];
    int binNumber;
    int totalNumBins;
    public static void main(String args[]) {
        ArrayList<Integer> vect = new ArrayList<>();
        int pos = 0;
        int number = 0;
        int count = 1;
        int upperBound = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("how many items are to be packed? ");
        number = sc.nextInt();
        System.out.println("enter the bin capacity? ");
        upperBound = sc.nextInt();
        while (count <= number) {
            pos = getRandomValue(upperBound);
            vect.add(pos);
            count++;
        }
        
        System.out.println("-----------------------------");
        System.out.println("items to pack: ");
        print(vect);
        // First Fit
        ArrayList<Integer> result = new ArrayList<>();
        result = FirstFit(vect, upperBound);
        printBins(result);

        result = NextFit(vect,upperBound);
        printBins(result);
    }
    public static int getRandomValue(int ub)
    {
        Random r = new Random();
        int element = 0;
        int upperBound = ub;
        int lowerBound = 1;
        element = Math.abs(r.nextInt()) % upperBound +
        lowerBound;
        return element;
    }
    public static void print(ArrayList<Integer> a)
    {
        for (int i = 0; i < a.size(); ++i)
            System.out.print(a.get(i) + " ");
        System.out.println("\n-----------------------------");
    }

    public static void printBins(ArrayList<Integer> a){
        System.out.println("-----------------------------\nValue in each bin:");
        for(int i = 0; i < a.size(); i++){
            System.out.print(a.get(i) + "   ");
        }
        System.out.println("\nTotal number of bins used: " + a.size());
        System.out.println("-----------------------------");
    }

    // First Fit
    public static ArrayList<Integer> FirstFit(ArrayList<Integer> a, int capacity){
        System.out.println("First Fit:");
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        int current;
        boolean found = false;  
        for(int i = 0; i <a.size(); i++){
            current = a.get(i);
            for(int j = 0 ; j < result.size();j++){
                found = false;
                if(current + result.get(j) <= capacity){
                    result.set(j, result.get(j) + current);
                    System.out.println("Bin " + (j+1) + ": " + result.get(j));
                    found = true;
                    break;    
                }
            }
            if(!found){
                result.add(current);
                System.out.println("Bin " + (result.size()+1) + ": " + current);
            }
        }
        return result;
    }

    // Next Fit
    public static ArrayList<Integer> NextFit(ArrayList<Integer> a, int capacity){
        System.out.println("Next Fit:");
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        int currentVal = 0, currentBin = 0;
        
        for(int i = 0;i < a.size(); i++){
            currentVal = a.get(i);
            if(result.get(currentBin) + currentVal <= capacity){
                result.set(currentBin, result.get(currentBin) + currentVal);
                System.out.println("Bin " + (currentBin+1) + ": " + result.get(currentBin));
            }
            else{
                currentBin++;
                result.add(currentVal);
                System.out.println("Bin " + (currentBin+1) + ": " + currentVal);
            }

        }

        return result;
    }

}