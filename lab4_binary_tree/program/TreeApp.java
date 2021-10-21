package program;

import node.TreeNode;
import structure.BinaryTree;

public class TreeApp {
    public static void main(String[] args) {
//        TreeNode<Integer> node1 = new TreeNode<>();
//        node1.setValue(5);
//        System.out.println(node1);
//        System.out.println(node1.getValue());
//        TreeNode<Integer> node2 = new TreeNode<>();
//        node2.setValue(2);
//        node1.setLeftChild(node2);
//        System.out.println(node2);
//        System.out.println(node1);

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(50);
        System.out.println(tree);
        tree.insert(4);
        System.out.println(tree);
        tree.insert(30);
        System.out.println(tree);
        tree.insert(100);
        System.out.println(tree);

        System.out.println(tree.find(4));
        System.out.println(tree.find(2));
    }
}
