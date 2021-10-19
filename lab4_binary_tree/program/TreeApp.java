package program;

import groovyjarjarantlr4.runtime.tree.Tree;
import node.TreeNode;

public class TreeApp {
    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<>();
        node1.setValue(5);
        System.out.println(node1);
        System.out.println(node1.getValue());
        TreeNode<Integer> node2 = new TreeNode<>();
        node2.setValue(2);
        node1.setLeftChild(node2);
        System.out.println(node2);
        System.out.println(node1);
    }
}
