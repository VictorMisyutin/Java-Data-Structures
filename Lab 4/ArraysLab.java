public class ArraysLab{
    public static void main (String[] args){

    }

    public void linSearchString(String strArray[], String search)
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
        if (flag == 1)
            System.out.println("item found at position " + (i + 1));
        else
            System.out.println("item not found");
    }
}
