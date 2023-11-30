import java.util.ArrayList;
import java.util.Iterator;

public class UsingIterators {

    public static void main(String args[]){
        ArrayList<Integer> al = new ArrayList<Integer>(100);

        for (int i = 0; i < 100; i++){
            al.add(i);
        }

        Iterator<Integer> iter = al.iterator();
        while (iter.hasNext()) {
            int obj = iter.next();
            // Do something with obj
            System.out.println(obj);
        }
        
        for (Integer i : al) {
            // Do something with i.
            System.out.println(i);
        }
        
        
    }
    
}
