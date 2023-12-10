import java.util.List;

import javax.swing.event.MenuKeyEvent;

public class MyBinarySearchTreeNode<T extends Comparable>{
    private T item;
    private MyBinarySearchTreeNode<T> parent;
    private MyBinarySearchTreeNode<T> leftChild;
    private MyBinarySearchTreeNode<T> rightChild;

    private MyBinarySearchTreeNode(T item, MyBinarySearchTreeNode<T> parent){
        this.item = item;
        this.parent = parent;
        leftChild = null;
        rightChild = null;
    }

    public MyBinarySearchTreeNode(T item){
        this(item, null);
    }

    public T getItem(){
        return item;
    }

    public MyBinarySearchTreeNode<T> getParent(){
        return parent;
    }

    public MyBinarySearchTreeNode<T> insert(T item) {
        // check if item is equal to this.item
        if (item.compareTo(this.item) == 0) {
            return null;
        }
        // check if item is less than this.item
        else if (item.compareTo(this.item) < 0) {
            if (leftChild == null) { // if there is no left child then make one
                MyBinarySearchTreeNode<T> newNode = new MyBinarySearchTreeNode<>(item, this);
                leftChild = newNode;
                return newNode;
            }
            else { // if there is a left child insert somewhere in left child
                return leftChild.insert(item);
            }
        }
        else { // item is larger than this.item
            if (rightChild == null) { // if there is no right child then make one
                MyBinarySearchTreeNode<T> newNode = new MyBinarySearchTreeNode<>(item, this);
                rightChild = newNode;
                return newNode;
            }
            else {// if there is a right child insert somewhere in right child
                return rightChild.insert(item);
            }
        }
    }

    public void preOrder(List<T> resultList) {
        resultList.add(item);

        if (leftChild != null) {
            leftChild.preOrder(resultList);
        }

        if (rightChild != null) {
            rightChild.preOrder(resultList);
        }
    }

    public void inOrder(List<T> resultList) {
        if (leftChild != null) {
            leftChild.inOrder(resultList);
        }

        resultList.add(item);

        if (rightChild != null) {
            rightChild.inOrder(resultList);
        }
    }

    public void postOrder(List<T> resultList) {
        if (leftChild != null) {
            leftChild.postOrder(resultList);
        }

        if (rightChild != null) {
            rightChild.postOrder(resultList);
        }

        resultList.add(item);
    }

    public MyBinarySearchTreeNode<T> find(Object obj) {
        T searchItem = (T) obj;
        int comparison = searchItem.compareTo(this.item);

        if (comparison == 0) {
            return this;
        }
        else if (comparison < 0) {
            if (leftChild != null) {
                return leftChild.find(obj);
            }
            else {
                return null;
            }
        }
        else {
            if (rightChild != null) {
                return rightChild.find(obj);
            }
            else {
                return null;
            }
        }
    }

    private MyBinarySearchTreeNode<T> findSuccessor() {
        MyBinarySearchTreeNode<T> successor = this.rightChild;
        
        while (successor != null && successor.leftChild != null) {
            successor = successor.leftChild;
        }
        
        return successor;
    }
    
    public void remove(T item){
        int comparisonResult = item.compareTo(this.item);

        if (comparisonResult == 0) { // remove current node
            if (leftChild == null && rightChild == null) { // check if leaf
                if (parent != null) {
                    if (parent.leftChild == this) {
                        parent.leftChild = null;
                    } 
                    else if (parent.rightChild == this) {
                        parent.rightChild = null;
                    }
                }
            }
            else if (leftChild == null || rightChild == null) { // check if only one child
                MyBinarySearchTreeNode<T> child = (leftChild != null) ? leftChild : rightChild;
                if (parent != null) {
                    if (parent.leftChild == this) {
                        parent.leftChild = child;
                    } 
                    else if (parent.rightChild == this) {
                        parent.rightChild = child;
                    }
                    child.parent = parent;
            }
            else { // two children
                MyBinarySearchTreeNode<T> successor = findSuccessor();
                this.item = successor.getItem();
                successor.remove(successor.getItem());
            }
        }
        else if (comparisonResult < 0) { // recursive call left
            if (leftChild != null) {
                leftChild.remove(item);
            }
        }
        else { // recursive call right
            if (rightChild != null) {
                rightChild.remove(item);
            }
        }
    }
}
}