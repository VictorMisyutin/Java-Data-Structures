import java.util.ArrayList;
import java.util.List;
public class MyTreeNode<T> {
    // start of part 1
    private T item;
    private MyTreeNode<T> parent;
    List<MyTreeNode<T>> children;

    private MyTreeNode(T item, MyTreeNode<T> parent){
        this.item = item;
        this.parent = parent;
        children = new ArrayList<>();
    }

    public MyTreeNode(T item){
        this(item, null);
    }

    public T getItem(){
        return item;
    }

    public MyTreeNode<T> getParent(){
        return parent;
    }
    
    public List<MyTreeNode<T>> getChildren(){
        List<MyTreeNode<T>> childrenCopy = new ArrayList<MyTreeNode<T>>(this.children);
        return childrenCopy;
    }
    
    public MyTreeNode<T> addChild(T item){
        MyTreeNode<T> child = new MyTreeNode<>(item, this);
        children.add(child);
        return child;
    }
    // end of part 1
    // start of part 2
    public boolean isLeaf(){
        return children.isEmpty();
    }

    public boolean isRoot(){
        return parent == null;
    }

    public int depth() {
        if (parent == null) {
            return 0;
        } 
        else {
            return parent.depth() + 1;
        }
    }

    public int height() {
        if (isLeaf()) {
            return 0;
        } 
        else {
            int height = -1;
            for (MyTreeNode<T> child : children) {
                int childHeight = child.height();
                height = Math.max(height, childHeight);
            }
            return height + 1;
        }
    }
    
    public boolean contains(T item) {
        if (this.item.equals(item)) {
            return true;
        }

        for (MyTreeNode<T> child : children) {
            if (child.contains(item)) {
                return true;
            }
        }

        return false;
    }
    // end of part 2
    // start of part 3
    private void print(String prefix) {
        System.out.println(prefix + item);

        for (MyTreeNode<T> child : children) {
            child.print(prefix + "\t");
        }
    }

    public void print(){
        print("");
    }
    // end of part 3

    // FOR TESTING
    // public static void main(String[] args) {
    //     MyTreeNode<Integer> root = new MyTreeNode<>(150);

    //     MyTreeNode<Integer> child1 = root.addChild(151);
    //     MyTreeNode<Integer> child2 = child1.addChild(275);
    //     MyTreeNode<Integer> child3 = child1.addChild(241);
        
    //     MyTreeNode<Integer> grandchild1 = child3.addChild(210);
    //     grandchild1.addChild(341);

    //     child3.addChild(364);
    //     child3.addChild(374);

    //     MyTreeNode<Integer> child4 = child1.addChild(280);
    //     child4.addChild(383);

    //     // Printing the tree
    //     root.print();
    // }
}
