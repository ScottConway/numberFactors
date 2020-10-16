package org.conway;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FactorTreeBuilder {
    public static List<List<Integer>> buildTree(List<Integer> numbers, Integer desiredTotal) {
        List<List<Integer>> solution = new ArrayList<>();

        if (numbers == null) {
            return solution;
        }

        List<NumberNode> parentNodes = new ArrayList<>();
        // Make a list whose numbers are all equal to or less than desiredTotal
        List<Integer> workNumbers = numbers.stream()
                                       .filter(x -> x <= desiredTotal)
                                       .collect(Collectors.toList());

        for (int i = 0; i < workNumbers.size(); i++) {
            NumberNode numberNode = buildNumberNode(new NumberNode(workNumbers.get(i)),
                    workNumbers.subList(i+1, workNumbers.size()),
                    desiredTotal- workNumbers.get(i));
            if (numberNode != null) {
                solution.addAll(numberNode.flatten());
            }
        }

        return solution;
    }

    public static NumberNode buildNumberNode(NumberNode node, List<Integer> subList, Integer desiredTotal) {
        if (desiredTotal == 0) {
            return node;
        }

        List<Integer> workNumbers = subList.stream()
                .filter(x -> x <= desiredTotal)
                .collect(Collectors.toList());
        for (int i = 0; i < workNumbers.size(); i++) {
            NumberNode childNode = buildNumberNode(new NumberNode(workNumbers.get(i)),
                    workNumbers.size() == 1 ? workNumbers : workNumbers.subList(i+1, workNumbers.size()),
                    desiredTotal-workNumbers.get(i));
            if (childNode != null) {
                node.addChildNode(childNode);
            }
        }
        return node.getNumberOfChildren() == 0 ? null : node;
    }
}
