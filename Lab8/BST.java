package Lab8;
import java.util.Scanner;

public class BST {
    Node root;
    
    BST() {
        root = null;
    }
    
    Node insertRec(Node root, int data){
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if(data < root.data)
        root.left = insertRec(root.left, data);
        else if (data > root.data)
        root.right = insertRec(root.right, data);
        return root; 
    }
    
    void insert(int data){
        root = insertRec(root, data);
        System.out.println("New item inserted into tree => " + data);
    }
    
    void postorderRec(Node root){
        if (root != null){
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.data);
        }
    }

    void preorderRec(Node root){
        if (root == null)
            return;
        System.out.println(root.data + " ");
        preorderRec(root.left);
        preorderRec(root.right);
    }
    
    int findMax(Node node){
        if(node == null)
            return Integer.MIN_VALUE;
        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    int findMin(Node node){
        if (node.left == null)
            return node.data;
        return findMin(node.left);
    }
    
    boolean searchTree(Node root, int item){
        if(root == null)
            return false;
        if(root.data == item)
            return true;
        boolean lres = searchTree(root.left, item); 
        if(lres) return true; 
        boolean rres = searchTree(root.right, item); 
        return rres; 
    }

    public static void main (String args[]){
        BST tree = new BST();
        /* Tree operations ************************/
        // build the tree
        // insert into tree
        tree.insert(27);
        tree.insert(13);
        tree.insert(42);
        tree.insert(6);
        tree.insert(17);
        tree.insert(33);
        tree.insert(48);
        // print max element of tree
        System.out.println("\nMaximum element is " + tree.findMax(tree.root));
        // print postorder of tree
        System.out.println("\nPostorder => ");
        tree.postorderRec(tree.root);
        // NEW // print preorder of tree
        System.out.println("\nPreorder => ");
        tree.preorderRec(tree.root);
        // NEW // search tree
        int item;
        boolean result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat number would you like to look for?");
        item = scanner.nextInt();
        result = tree.searchTree(tree.root, item);
        if(!result)
            System.out.println(item + " was not found in the tree.");
        else
            System.out.println(item + " is in the tree.");
        scanner.close();
        // NEW // minimum node
        System.out.println("\nMinimum element is " + tree.findMin(tree.root));
    }
}

class Node {
    int data;
    Node left, right;
    public Node(int item){
        data = item;
        left = right = null;
    }
}