package org.conway;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static final List<Integer> INTEGERS = Arrays.asList(1,2,3,4,5,7,9,10,11,14,17,25,50);
    public static final Integer DESIRED_TOTAL = 32;
    public static void main(String[] args) {
        List<List<Integer>> tree = FactorTreeBuilder.buildTree(INTEGERS, DESIRED_TOTAL);
        System.out.println(String.format("Number of possible solutions: %d", tree.size()));
        tree.forEach(System.out::println);
    }
}
