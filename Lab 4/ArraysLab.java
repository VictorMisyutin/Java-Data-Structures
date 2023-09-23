import java.util.Scanner;

public class ArraysLab{
    static Scanner scanner = new Scanner(System.in);
    public static void main (String args[]){
        // Create String Array
        String[] myClientsArray = new String[10];
        myClientsArray[0] = "Butler";
        myClientsArray[1] = "Samuels";
        myClientsArray[2] = "Bond";
        myClientsArray[3] = "Chang";
        myClientsArray[4] = "Baker";
        myClientsArray[5] = "Davis";
        myClientsArray[6] = "Zheng";
        myClientsArray[7] = "Joe";

        // Create Int Array
        int[] myClientNumbers = new int[10];
        myClientNumbers[0] = 108;
        myClientNumbers[1] = 121;
        myClientNumbers[2] = 188;
        myClientNumbers[3] = 107;
        myClientNumbers[4] = 122;
        myClientNumbers[5] = 111;
        myClientNumbers[6] = 203;
        myClientNumbers[7] = 135;

        // Search for name
        System.out.println("Enter a Client Name: ");
        String nameSearch = scanner.nextLine();
        int stringSearchVal = linSearchString(myClientsArray, nameSearch);

        // Search for number
        System.out.println("Enter a Client Number: ");
        int numSearch = scanner.nextInt();
        int intSearchVal = linSearchInt(myClientNumbers, numSearch);
        
        if ((intSearchVal != -1 && stringSearchVal != -1) && intSearchVal == stringSearchVal)
            System.out.println("results:                 the positions match");
        else 
            System.out.println("results:                 the positions do not match");

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
    
    public static void binSearchString(String strArray[], String search){

    }

    public static void binSearchInt(int intArray[], int search){

    }

}
