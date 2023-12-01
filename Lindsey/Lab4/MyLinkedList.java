import java.util.AbstractList;


public class MyLinkedList<T> extends AbstractList<T> {
	/* Your MyLinkedList instance variables and methods go here. */
	/** The Node that is currently the beginning of the linked list. */
    private DoublyLinkedNode firstNode;
    /** The Node that is currently the end of the linked list. */
    private DoublyLinkedNode lastNode;
    /** The current size of the list. */
    private int size;
    public MyLinkedList(){
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    public int getsize(){
        return this.size;
    }
    public T get(int index) {
        // TODO: we will fill this in soon
        return null;
   }
   

	private class DoublyLinkedNode {
		/* Your DoublyLinkedNode instance variables and constructor 
		   go here.*/
          /** The item stored in this Node. */
        private T item;

        /** The Node that preceeds this Node in the doubly linked list. Note: previous is null if this Node is the beginning of the doubly linked list. */
        private DoublyLinkedNode previous;
        /** The Node that follows this Node in the doubly linked list. Note: next is null if this Node is the end of the doubly linked list. */
        private DoublyLinkedNode next;

        }
        
    
        }





