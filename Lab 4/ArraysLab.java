import java.util.Scanner;
import java.util.Arrays;

public class ArraysLab{
    static Scanner scanner = new Scanner(System.in);
    static String[] myClientsArray = new String[10];
    static int[] myClientNumbers = new int[10];
    public static void main (String args[]){
        // Create Clients
        myClientsArray[0] = "Butler";
        myClientsArray[1] = "Samuels";
        myClientsArray[2] = "Bond";
        myClientsArray[3] = "Chang";
        myClientsArray[4] = "Baker";
        myClientsArray[5] = "Davis";
        myClientsArray[6] = "Zheng";
        myClientsArray[7] = "Joe";
        myClientsArray[8] = "Dylan";
        myClientsArray[9] = "Victor";

        // Create Client Numbers
        myClientNumbers[0] = 108;
        myClientNumbers[1] = 121;
        myClientNumbers[2] = 188;
        myClientNumbers[3] = 107;
        myClientNumbers[4] = 122;
        myClientNumbers[5] = 111;
        myClientNumbers[6] = 203;
        myClientNumbers[7] = 135;
        myClientNumbers[8] = 189;
        myClientNumbers[9] = 136;

        // Search for client using linear search
        System.out.println("Enter a Client Name: ");
        String nameSearch = scanner.nextLine();
        int stringSearchVal = linSearchString(myClientsArray, nameSearch);
        
        // Search for number using linear search
        System.out.println("Enter a Client Number: ");
        int numSearch = scanner.nextInt();
        int intSearchVal = linSearchInt(myClientNumbers, numSearch);
        
        // print results
        if ((intSearchVal != -1 && stringSearchVal != -1) && intSearchVal == stringSearchVal)
            System.out.println("results:                 the positions match");
        else 
            System.out.println("results:                 the positions do not match");

        // Print both arrays
        printParallelArrays(myClientsArray, myClientNumbers);

        // Create new Arrays
        String[] newClients1 = myClientsArray;
        int[] newNumbers1 = myClientNumbers;

        // sort both arrays using intrinsic sort
        // Arrays.sort(newClients1);
        // Arrays.sort(newNumbers1);

        // search both arrays using binary search
        stringSearchVal = binSearchString(newClients1, "Zheng");
        intSearchVal = binSearchInt(newNumbers1, 203);

        System.out.println("-------------" + stringSearchVal + " : " + intSearchVal + "----------");
    
    }
    
    // find first number in array and change name of responding client
    public static void changeClient(int value, String newClient){
        int index = linSearchInt(myClientNumbers, value);
        myClientsArray[index] = newClient;
    }

    public static void removeClient(String client){
        int index = linSearchString(myClientsArray, client);
        myClientsArray[index] = null;
        myClientNumbers[index] = 0;
    }

    public static void changeValue(String client, int newVal){
        int index = linSearchString(myClientsArray, client);
        myClientNumbers[index] = newVal;
    }

    public static void addValue(String client, int number){
        for(int i = 0; i < myClientsArray.length;i++){
            if(myClientsArray[i] == null){
                myClientsArray[i] = client;
                myClientNumbers[i] = number;
            }
        }
    }

    public static void printParallelArrays(String[] strArray,int[] intArray){
        for(int i = 0; i<strArray.length;i++){
            if (strArray[i] != null)
                System.out.println(strArray[i] + ":" + intArray[i]);
        }
    }

    public static int linSearchString(String strArray[], String search)
    {
        int i = 0;
        int flag = 0;
        for(i = 0; i < 10; i++)
        {
            if (search.equals(strArray[i]))
            {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("item found at position " + (i + 1));
            return i;
        }
        System.out.println("item not found");
        return 0;    
    }

    public static int linSearchInt(int intArray[], int search){
        int i = 0;
        int flag = 0;
        for(i = 0; i < 10; i++)
        {
            if (search == intArray[i])
            {
                flag = 1;
                break;
            }
        }
        if (flag == 1){
            System.out.println("item found at position " + (i + 1));
            return i;
        }
        System.out.println("item not found");
        return 0;
    }
    
    // precondition: strArray is sorted
    public static int binSearchString(String strArray[], String search){  
        int left = 0;
        int right = strArray.length-1;
        int middle,middleVal;
        while(left<=right){
            middle = left + (right-left)/2;
            middleVal = search.compareTo(strArray[middle]);
            
            if(middleVal == 0) return middle;
        
            if(middleVal > 0) left = middle+1;
            else right = middle-1;
        }
        return -1;
    }
 
    // precondition: intArray is sorted
    public static int binSearchInt(int intArray[], int search){
        int left = intArray[0];
        int right = intArray.length-1;
        int middle,middleVal;
        while(left<=right){
            middle = left + (right-left)/2;
            middleVal = intArray[middle];
            if(middleVal == search) return middle;
        
            if(middleVal < search) left = middle+1;
            else right = middle-1;
        }

        return -1;
    }

    public static void stringBubbleSort(String[] strArray, int[] intArray){
        boolean swapped = false;
        String tempStr;
        int tempInt;
        for (int j = 0; j < strArray.length; j++) {
            swapped = false; 
            for (int i = j + 1; i < strArray.length; i++) {
                // comparing adjacent strings
                if (strArray[i].compareTo(strArray[j]) < 0) {
                    tempStr = strArray[j];
                    tempInt= intArray[j];
                    strArray[j] = strArray[i];
                    intArray[j] = intArray[i];
                    strArray[i] = tempStr;
                    intArray[i] = tempInt;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void intBubbleSort(String[] strArray, int[] intArray){
        boolean swapped;
        int tempInt;
        String tempStr;
        for(int i = 0 ; i < intArray.length;i++){
            swapped = false;
            for(int j = 0; j < intArray.length-i-1;i++){
                if(intArray[j] > intArray[j+1]){
                    tempInt = intArray[j+1];
                    tempStr = strArray[j+1];
                    intArray[j+1] = intArray[i];
                    strArray[j+1] = strArray[i];
                    intArray[j] = tempInt;
                    strArray[j] = tempStr;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }        
    }  

    public static void stringInsertionSort(String[] strArray){

    }

    public static void intInsertionSort(int[] intArray){
        int value;
        for (int i = 1; i< intArray.length;i++){
            value = intArray[i];
            int j = i-1;
            while(j>=0 && intArray[j] > value){
                intArray[j+1] =intArray[j];
                j--;                
            }
            intArray[j+1] = value;
        }
    }

}
