import java.util.Scanner;

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
        if (stringSearchVal != -1)
            System.out.println("Item found at position " + stringSearchVal);
        else System.out.println("Item not found");

        // Search for client number using linear search
        System.out.println("Enter a Client Number: ");
        int numSearch = scanner.nextInt();
        int intSearchVal = linSearchInt(myClientNumbers, numSearch);
        if (intSearchVal != -1)
            System.out.println("Item found at position " + intSearchVal);
        else System.out.println("Item not found");
        
        // print results
        if ((intSearchVal != -1 && stringSearchVal != -1) && intSearchVal == stringSearchVal)
            System.out.println("results:                 the positions match");
        else 
            System.out.println("results:                 the positions do not match");
            
        // Create new Arrays with old values
        String[] newClients1 = myClientsArray;
        int[] newNumbers1 = myClientNumbers;

        // sort Arrays based on client names using bubble sort
        System.out.println("\nArray sorted by client names using bubble sort:");
        stringBubbleSort(newClients1,newNumbers1);
        // print sorted arrays
        printParallelArrays(newClients1, newNumbers1);

        // search client names array using binary search
        stringSearchVal = binSearchString(newClients1, "Zheng");
        System.out.println("\nSearch the clients array for 'Zheng' using binary search:\n" + stringSearchVal);        

        // Sort arrays based on client numbers using bubble sort
        System.out.println("\nArrays sorted by client numbers using bubble sort:");
        intBubbleSort(newClients1,newNumbers1);
        // print sorted arrays
        printParallelArrays(newClients1, newNumbers1);

        // search both arrays using binary search
        stringSearchVal = binSearchString(newClients1, "Baker");
        System.out.println("\nSearch client array for 'Baker' using binary search:\n" + stringSearchVal);
        intSearchVal = binSearchInt(newNumbers1, 188);
        System.out.println("\nSearch number array for 188 using binary search:\n" + intSearchVal);

        // sort arrays by client names using insertion sort
        System.out.println("\nArray sorted by client names using insertion sort:");
        stringInsertionSort(newClients1,newNumbers1);
        printParallelArrays(newClients1, newNumbers1);

        // sort arrays by client numbers using insertion sort
        System.out.println("\nArray sorted by client numbers using insertion sort:");
        intInsertionSort(newClients1,newNumbers1);
        printParallelArrays(newClients1, newNumbers1);

        // test remaining functions
        System.out.println("\nChange client name who has the value 189 to 'Adil'.\n"
                             + "Also, remove client who has name 'Bond' and create a new client\n"
                             + "with the name 'Zach' and number 123. Finally," 
                             + "change number for the client with name 'Butler' to 102.\n");
        changeClient(189, "Adil");
        removeClient("Bond");
        addClient("Zach", 123);
        changeValue("Butler", 102);

        printParallelArrays(newClients1, newNumbers1);
    }
    
    // Given a value, find the first instance of that value,
    // and change their client name to the new client name
    public static void changeClient(int value, String newClientname){
        int index = linSearchInt(myClientNumbers, value)-1;
        myClientsArray[index] = newClientname;
    }

    // remove a client from both arrays
    public static void removeClient(String client){
        int index = linSearchString(myClientsArray, client)-1;
        myClientsArray[index] = null;
        myClientNumbers[index] = 0;
    }

    // change value of clients number
    public static void changeValue(String client, int newVal){
        int index = linSearchString(myClientsArray, client)-1;
        myClientNumbers[index] = newVal;
    }

    // add new client with given name and number
    public static void addClient(String client, int number){
        for(int i = 0; i < myClientsArray.length;i++){
            if(myClientsArray[i] == null){
                myClientsArray[i] = client;
                myClientNumbers[i] = number;
            }
        }
    }

    // print both given parallel arrays 
    public static void printParallelArrays(String[] strArray,int[] intArray){
        for(int i = 0; i<strArray.length;i++){
            if (strArray[i] != null)
                System.out.println(strArray[i] + ":" + intArray[i]);
        }
    }

    // search string array for a value using linear search
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
            return i+1;
        }
        return 0;    
    }
    // search int array for a value using linear search
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
            return i+1;
        }
        return 0;
    }
    
    // precondition: strArray is sorted
    // Search string array using binary search
    public static int binSearchString(String strArray[], String search){  
        int left = 0;
        int right = strArray.length-1;
        while(left<=right){
            int middle = (left + right)/2;
            int val = search.compareTo(strArray[middle]);
            if(val == 0) return middle+1;
        
            if(val > 0) left = middle+1;
            else right = middle-1;
        }
        return -1;
    }
 
    // precondition: intArray is sorted
    // Search int array using binary search
    public static int binSearchInt(int intArray[], int search){
        int left = 0;
        int right = intArray.length-1;
        while(left<=right){
            int middle = (left + right-1) / 2;
            if(intArray[middle] == search) return middle+1;
        
            if(intArray[middle] < search) left = middle+1;
            else right = middle-1;
        }

        return -1;
    }

    // sort both parallel arrays by string(client name) using bubble sort 
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

    // sort both parallel arrays by int(client number) using bubble sort 
    public static void intBubbleSort(String[] strArray, int[] intArray){
        boolean swapped;
        int tempInt;
        String tempStr;
        for(int i = 0 ; i < intArray.length-1;i++){
            swapped = false;
            for(int j = 0; j < intArray.length-i-1;j++){
                if(intArray[j] > intArray[j+1]){
                    tempInt = intArray[j+1];
                    tempStr = strArray[j+1];
                    intArray[j+1] = intArray[j];
                    strArray[j+1] = strArray[j];
                    intArray[j] = tempInt;
                    strArray[j] = tempStr;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }        
    }  

    // sort both parallel arrays by string(client name) using insertion sort 
    public static void stringInsertionSort(String[] strArray, int[] intArray){
        String tempStr;
        int tempInt;
        for (int i = 1; i < strArray.length; i++) {
            tempStr = strArray[i];
            tempInt = intArray[i];
            int j = i - 1;
            while (j >= 0) {
                if (tempStr.compareTo(strArray[j]) > 0) {
                    break;
                }
                strArray[j+1] = strArray[j];
                intArray[j+1] = intArray[j];
                j--;
            }
            strArray[j+1] = tempStr;
            intArray[j+1] = tempInt;
            // System.out.println(Arrays.toString(strArray));
        }
    }

    // sort both parallel arrays by int(client number) using insertion sort 
    public static void intInsertionSort(String[] strArray, int[] intArray){
        int tempInt;
        String tempStr;
        for (int i = 1; i< intArray.length;i++){
            tempInt = intArray[i];
            tempStr = strArray[i];
            int j = i-1;
            while(j>=0 && intArray[j] > tempInt){
                intArray[j+1] = intArray[j];
                strArray[j+1] = strArray[j];
                j--;                
            }
            intArray[j+1] = tempInt;
            strArray[j+1] = tempStr;
        }
    }

}
