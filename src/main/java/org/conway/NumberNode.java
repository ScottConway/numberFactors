package org.conway;

import java.util.ArrayList;
import java.util.List;

public class NumberNode {
    int number;
    List<NumberNode> childNodes = new ArrayList<>();
    NumberNode parentNode;

    public NumberNode(int number) {
        this.number = number;
    }

    public NumberNode(int number, NumberNode parentNode) {
        this.number = number;
        this.parentNode = parentNode;
    }

    public int getNumber() {
        return number;
    }

    public int getSum() {
        return parentNode == null ? number : number + parentNode.getSum();
    }

    public NumberNode addChildNode(int number) {
        NumberNode childNode = new NumberNode(number, this);
        childNodes.add(childNode);
        return childNode;
    }

    public int getNumberOfChildren() {
        return childNodes.size();
    }

    public List<List<Integer>> flatten() {
        List<List<Integer>> flattenedTree = new ArrayList<>();
        if (childNodes.isEmpty()) {
            List<Integer> leafNode = new ArrayList<>();
            leafNode.add(this.number);
            flattenedTree.add(leafNode);
        } else {
            for (NumberNode child : childNodes) {
                for (List<Integer> list : child.flatten()) {
                    list.add(0, this.number);
                    flattenedTree.add(list);
                }
            }
        }
        return flattenedTree;
    }
}
