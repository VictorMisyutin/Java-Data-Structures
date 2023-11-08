package Lab11;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
public class ArrayListStack
{
    // declare a class – level array list
    static ArrayList<String> list = new ArrayList<String>();
    public static void main(String args[])
    {
        // add an element to the array list
        push("client 1");
        // add an element to the array list
        push("client 2");
        // add an element to the array list
        push("client 3");
        // add an element to the array list
        push("client 4");
        display();
        // pop an element
        pop();
        // pop an element
        pop();
        display();

        // should output "Client 2"
        System.out.println("The top element is: " + top());

        if(isEmpty()){
            System.out.println("List is empty");
        }
        else{
            System.out.println("List is not empty");
        }
        pop();
        pop();
        if(isEmpty()){
            System.out.println("List is empty");
        }
        else{
            System.out.println("List is not empty");
        }
    }

    // define the pop() method
    public static void pop()
    {
        // declare an object to manipulate the list
        Object obj = new Object();
        if (!isEmpty())
        {
            obj = list.remove(0);
            System.out.println(obj + " is removed from ArrayList");
        }
        else
            System.out.println("empty list");
    }

    // define the push() method
    public static void push(String client){
        Collections.reverse(list);
        list.add(client);
        Collections.reverse(list);

    }
    // define the top() method
    public static String top(){
        if (!isEmpty())
        {
            return list.get(0);
        }
        else
            return "";        
    } 
    // define the isEmpty() method
    public static boolean isEmpty(){
        return (list.size() == 0);
    }

    // define the display() method
    public static void display(){
        // declare a date object
        Date myDate = new Date();
        String myDateFormat = "MM/dd/yyyy";
        SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat);
        // store the stack elements in a StringBuilder object
        StringBuilder sb = new StringBuilder();
        // declare an Iterator object
        Iterator<String> itr = list.iterator();
        // iterate through the list of elements in the ArrayList
        System.out.println("iterate through ArrayList elements");
        while(itr.hasNext())
        {
            sb.append(itr.next() + "\n");
        }
        // display the stack elements in a Dialog Box
        JOptionPane.showMessageDialog(null, dtToday.format(myDate) + "\n" + "display elements \n" + sb);
        // clear the StringBuilder object
        sb.setLength(0);
        // update the Iterator object
        itr = list.iterator();
        // store the updated stack elements in a StringBuilder object
        System.out.println("iterate through ArrayList elements");
        while(itr.hasNext())
        {
            sb.append(itr.next() + "\n");
        }
        // display the current stack elements in a Dialog Box
        JOptionPane.showMessageDialog(null, dtToday.format(myDate) + "\n" + "display elements \n" + sb);
    }
}