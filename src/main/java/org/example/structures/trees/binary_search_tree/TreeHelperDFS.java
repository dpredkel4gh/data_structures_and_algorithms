package org.example.structures.trees.binary_search_tree;

import java.util.List;

public class TreeHelperDFS {
    // traverse in order

    public static List<Integer> traverseInOrder(Node node, List<Integer> array) {
        if (node.left != null) {
            traverseInOrder(node.left, array);
        }
        array.add(node.value);
        if (node.right != null) {
            traverseInOrder(node.right, array);
        }
        return array;
    }

    // traverse pre order
    public static List<Integer> traversePreOrder(Node node, List<Integer> array) {
        array.add(node.value);
        if (node.left != null) {
            traversePreOrder(node.left, array);
        }
        if (node.right != null) {
            traversePreOrder(node.right, array);
        }
        return array;
    }

    // traverse post order
    public static List<Integer> traversePostOrder(Node node, List<Integer> array) {
        if (node.left != null) {
            traversePostOrder(node.left, array);
        }
        if (node.right != null) {
            traversePostOrder(node.right, array);
        }
        array.add(node.value);
        return array;
    }
}
