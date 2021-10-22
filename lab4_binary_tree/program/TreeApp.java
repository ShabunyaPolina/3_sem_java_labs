package program;

import node.TreeNode;
import structure.BinaryTree;
import customclass.Book;

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
////        System.out.println(node1);
//
//        BinaryTree<Integer> tree = new BinaryTree<>();
//        tree.insert(50);
//        System.out.println(tree);
//        tree.insert(4);
//        System.out.println(tree);
//        tree.insert(30);
//        System.out.println(tree);
//        tree.insert(100);
//        System.out.println(tree);
//
//        System.out.println(tree.find(4));
//        System.out.println(tree.find(2));
//
//        tree.infixTraverse(tree.getRoot());
//        System.out.println();
//        tree.prefixTraverse(tree.getRoot());
//        System.out.println();
//        tree.postfixTraverse(tree.getRoot());
//
//        tree.displayTree();

        Book book1 = new Book("a", "h", 123);
        System.out.println(book1);
        Book book2 = new Book("b", "r", 54);
        System.out.println(book2);
        Book book3 = new Book("c", "q", 90);
        System.out.println(book3);
        Book book4 = new Book("d", "z", 66);
        System.out.println(book4);

        BinaryTree<Book> tree = new BinaryTree<>();
        tree.insert(book1);
        tree.insert(book2);
        tree.insert(book3);
        tree.insert(book4);

        System.out.println(tree);

        tree.displayTree();
    }
}
