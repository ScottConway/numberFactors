package org.conway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberNodeTest {

    @Test
    @DisplayName("Creating an NumberNode.")
    public void createNumberNode() {
        NumberNode node = new NumberNode(3);
        assertEquals(0, node.getNumberOfChildren());
        assertEquals(3, node.getNumber());
        assertEquals(3, node.getSum());
    }

    @Test
    @DisplayName("Add child to node.")
    public void addChildNode() {
        NumberNode parent = new NumberNode(3);
        NumberNode child = parent.addChildNode(4);
        assertEquals(3, parent.getNumber());
        assertEquals(3, parent.getSum());
        assertEquals(4, child.getNumber());
        assertEquals(7, child.getSum());
    }

    @Test
    @DisplayName("A parent can have multiple children.")
    public void addMultipleChildren() {
        NumberNode parent = new NumberNode(3);
        NumberNode child34 = parent.addChildNode(4);
        NumberNode child36 = parent.addChildNode(6);
        assertEquals(3, parent.getNumber());
        assertEquals(3, parent.getSum());
        assertEquals(4, child34.getNumber());
        assertEquals(7, child34.getSum());
        assertEquals(6, child36.getNumber());
        assertEquals(9, child36.getSum());
    }

    @Test
    @DisplayName("Get number of children")
    public void getNumberOfChildren() {
        NumberNode parent = new NumberNode(3);
        assertEquals(0, parent.getNumberOfChildren());
        NumberNode child34 = parent.addChildNode(4);
        assertEquals(1, parent.getNumberOfChildren());
        NumberNode child36 = parent.addChildNode(6);
        assertEquals(2, parent.getNumberOfChildren());
    }

    @Test
    @DisplayName("Build a whole tree.")
    public void buildTree() {
        NumberNode parent = new NumberNode(3);
        NumberNode child34 = parent.addChildNode(4);
        NumberNode child342 = child34.addChildNode(2);
        NumberNode child36 = parent.addChildNode(6);
        NumberNode child362 = child36.addChildNode(2);
        assertEquals(3, parent.getNumber());
        assertEquals(3, parent.getSum());
        assertEquals(4, child34.getNumber());
        assertEquals(7, child34.getSum());
        assertEquals(6, child36.getNumber());
        assertEquals(9, child36.getSum());
        assertEquals(2, child342.getNumber());
        assertEquals(9, child342.getSum());
        assertEquals(2, child362.getNumber());
        assertEquals(11, child362.getSum());
    }

    @Test
    @DisplayName("Flatten the tree.")
    public void flatten() {
        List<Integer> list342 = Arrays.asList(3, 4, 2);
        List<Integer> list362 = Arrays.asList(3, 6, 2);
        List<Integer> list123 = Arrays.asList(1, 2, 3);

        NumberNode parent = new NumberNode(3);
        NumberNode child34 = parent.addChildNode(4);
        NumberNode child342 = child34.addChildNode(2);
        NumberNode child36 = parent.addChildNode(6);
        NumberNode child362 = child36.addChildNode(2);

        List<List<Integer>> flattenedTree = parent.flatten();

        assertTrue(flattenedTree.contains(list342));
        assertTrue(flattenedTree.contains(list362));
        assertFalse(flattenedTree.contains(list123));
    }

    @Test
    @DisplayName("NumberNode can be added as a child to another numberNode.")
    public void addNumberNodeToNumberNode() {
        NumberNode node2 = new NumberNode(2);
        NumberNode node4 = new NumberNode(4);
        node2.addChildNode(node4);
        assertEquals(1, node2.getNumberOfChildren());
        assertEquals(6, node4.getSum());
    }
}
