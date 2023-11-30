import org.w3c.dom.Node;

public class LinkedNode<E> {
//instance variables   
    public E data;
    public LinkedNode<E> next;

    //constructor
    public LinkedNode(E data, LinkedNode<E> next){
        this.data = data;
        this.next = next;

    }



    

    public static void main(String[] args) {
        LinkedNode<String> thirdNode = new LinkedNode<String>("third", null);
        LinkedNode<String> secondNode = new LinkedNode<String>("second", thirdNode);
        LinkedNode<String> firstNode = new LinkedNode<String>("first", secondNode);
        LinkedNode<String> node = firstNode;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
        for (LinkedNode<String> nnooddee = firstNode; nnooddee != null; nnooddee = nnooddee.next) {
            System.out.println(nnooddee.data);
        }
        


    }
    
}
