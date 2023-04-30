package org.example.structures.trees.trie;

import java.util.HashMap;
import java.util.Map;

public class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isWord = false;
}
