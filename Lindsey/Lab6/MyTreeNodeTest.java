import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyTreeNodeTest {
    @Test
    public void testAddChild() {
        MyTreeNode<String> rootNode = new MyTreeNode<>("Root");
        MyTreeNode<String> child1 = rootNode.addChild("Child");

        assertEquals("Child", child1.getItem());
        assertEquals(rootNode, child1.getParent());
        assertTrue(rootNode.getChildren().contains(child1));
    }

    @Test
    public void testGetChildren() {
        MyTreeNode<String> rootNode = new MyTreeNode<>("Root");
        rootNode.addChild("Child1");
        rootNode.addChild("Child2");

        assertEquals(2, rootNode.getChildren().size());
    }

    @Test
    public void testGetItem() {
        MyTreeNode<Integer> node = new MyTreeNode<>(42);

        assertEquals((Integer)42, node.getItem());
    }

    @Test
    public void testGetParent() {
        MyTreeNode<String> rootNode = new MyTreeNode<>("Root");
        MyTreeNode<String> child1 = rootNode.addChild("Child1");

        assertEquals(rootNode, child1.getParent());
    }

    @Test
    public void testIsLeaf() {
        MyTreeNode<String> leafNode = new MyTreeNode<>("Leaf");
        assertTrue(leafNode.isLeaf());

        MyTreeNode<String> parentNode = new MyTreeNode<>("Parent");
        MyTreeNode<String> childNode = parentNode.addChild("Child");
        assertFalse(parentNode.isLeaf());
        assertTrue(childNode.isLeaf());
    }

    @Test
    public void testIsRoot() {
        MyTreeNode<String> rootNode = new MyTreeNode<>("Root");
        assertTrue(rootNode.isRoot());

        MyTreeNode<String> childNode = rootNode.addChild("Child");
        assertFalse(childNode.isRoot());
    }

    @Test
    public void testDepth() {
        MyTreeNode<String> rootNode = new MyTreeNode<>("Root");
        assertEquals(0, rootNode.depth());

        MyTreeNode<String> child = rootNode.addChild("Child");
        assertEquals(1, child.depth());

        MyTreeNode<String> grandchild = child.addChild("Grandchild");
        assertEquals(2, grandchild.depth());
    }

    @Test
    public void testHeight() {
        MyTreeNode<String> rootNode = new MyTreeNode<>("Root");
        assertEquals(0, rootNode.height());

        MyTreeNode<String> child1 = rootNode.addChild("Child");
        assertEquals(1, rootNode.height());

        MyTreeNode<String> grandchild = child1.addChild("Grandchild");
        assertEquals(2, rootNode.height());

        MyTreeNode<String> greatGrandchild = grandchild.addChild("GreatGrandchild");
        assertEquals(3, rootNode.height());
    }

    @Test
    public void testContains() {
        MyTreeNode<String> rootNode = new MyTreeNode<>("Root");
        rootNode.addChild("Child1").addChild("Grandchild1");
        rootNode.addChild("Child2");

        assertTrue(rootNode.contains("Root"));
        assertTrue(rootNode.contains("Child1"));
        assertTrue(rootNode.contains("Grandchild1"));
        assertTrue(rootNode.contains("Child2"));
        assertFalse(rootNode.contains("NonexistentItem"));
    }

}
