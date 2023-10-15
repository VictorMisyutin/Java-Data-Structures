// Program Writer: Victor Misyutin
// Date: 10-14-2023

import java.util.ArrayList;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
public class ArrayListQueue
{
    // declare an array list
    // This list will hold customers, the left of the list is the front of the queue
    static ArrayList<String> list = new ArrayList<String>();
    // will keep track of serverd customers
    static int servedCustomers = 0;
    public static void main(String args[])
    {

        // populate the list with some initial elements (queue)
        enqueue("Steve");
        enqueue("Lance");
        enqueue("Betsy");
        dequeue();
        enqueue("Marissa");
        dequeue();
        dequeue();
        dequeue();
        enqueue("Raul");
        enqueue("Sandy");
        dequeue();

    }

    // QUEUE METHODS
    // --------------

    // add customer to the right of the list (end of queue)
    static void enqueue(String customer){
        list.add(customer);
        display();
    }

    // removes a customer from the front of the queue
    // (left most value in list)
    static void dequeue(){
        if(isEmpty()) return;
        list.remove(0);
        display();
        servedCustomers++;
    }

    // return true if list is empty (no one in queue)
    static boolean isEmpty(){
        return (list.size() == 0);
    }

    // display the elements/customers in the queue
    static void display(){
        // declare a Date object and its formatting
        Date myDate = new Date();
        String myDateFormat = "MM/dd/yyyy";
        SimpleDateFormat dtToday = new
        SimpleDateFormat(myDateFormat);

        // declare a StringBuilder object to display the list elements
        StringBuilder sb = new StringBuilder();
        // declare an Iterator object to cycle through the list elements
        Iterator<String> itr = list.iterator();
        // use a looping structure to display the list elements
        System.out.println("iterate through ArrayList elements ...");
        while(itr.hasNext())
        {
            // append the elements to the StringBuilder object
            sb.append(itr.next() + "\n");
        }
        // display the elements that are in the list (queue)
        JOptionPane.showMessageDialog(null, dtToday.format(myDate) + "\n" + "display queue \n" + sb);
    }

    // return how many customers have been served (dequeued)
    static int custCount(){
        return servedCustomers;
    }
}
