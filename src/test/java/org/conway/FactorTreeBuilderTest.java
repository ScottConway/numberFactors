package org.conway;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FactorTreeBuilderTest {
    public static final List<Integer> TEST_LIST = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 12);

    @Test
    @DisplayName("If null passed in for list then empty list is returned")
    public void passNullForList() {
        List<List<Integer>> tree = FactorTreeBuilder.buildTree(null, 3);
        assertTrue(tree.isEmpty());
    }

    @Test
    @DisplayName("If empty list passed in for list then empty list is returned")
    public void passEmptyList() {
        List<List<Integer>> tree = FactorTreeBuilder.buildTree(new ArrayList<>(), 3);
        assertTrue(tree.isEmpty());
    }

    @Test
    @DisplayName("build a tree that returns multiple possible outcomes.")
    public void buildTree() {
        List<List<Integer>> solutions = FactorTreeBuilder.buildTree(TEST_LIST, 8);
        assertEquals(5, solutions.size());
        assertTrue(solutions.contains(Arrays.asList(1, 3, 4)));
        assertTrue(solutions.contains(Arrays.asList(1, 2, 5)));
        assertTrue(solutions.contains(Arrays.asList(3, 5)));
        assertTrue(solutions.contains(Arrays.asList(1, 7)));
        assertTrue(solutions.contains(Arrays.asList(8)));
    }

    @Test
    @DisplayName("buildNumberNode will return null if a sum is impossible.")
    public void buildNumberNodeImpossibleTest() {
        assertNull(FactorTreeBuilder.buildNumberNode(new NumberNode(1), Arrays.asList(2, 7, 8), 5));
    }
}
