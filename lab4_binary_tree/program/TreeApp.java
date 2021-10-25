package program;

import structure.BinaryTree;
import customclass.Book;

public class TreeApp {
    public static void main(String[] args) {

        BinaryTree<Integer> integerTree = new BinaryTree<>();
        integerTree.insert(50);
        integerTree.insert(4);
        integerTree.insert(30);
        integerTree.insert(100);
        integerTree.insert(0);
        integerTree.insert(-48);
        integerTree.insert(12);
        integerTree.insert(765);

//        integerTree.insertR(50);
//        integerTree.insertR(4);
//        integerTree.insertR(30);
//        integerTree.insertR(100);
//        integerTree.insertR(0);
//        integerTree.insertR(-48);
//        integerTree.insertR(12);
//        integerTree.insertR(765);


        integerTree.displayTree();

        System.out.println(integerTree.find(100));
        System.out.println(integerTree.find(2));

        System.out.println("root->left->right");
        integerTree.infixTraverse();
        System.out.println("\nleft->right->root");
        integerTree.prefixTraverse();
        System.out.println("\nleft->root->right");
        integerTree.postfixTraverse();
        System.out.println();

        //--------------------------------------------------------------------------

        Book book1 = new Book("a", "h", 123);
        Book book2 = new Book("b", "r", 54);
        Book book3 = new Book("c", "q", 90);
        Book book4 = new Book("d", "z", 66);
        Book book5 = new Book("q", "v", 66);
        Book book6 = new Book("h", "p", 66);

        BinaryTree<Book> bookTree = new BinaryTree<>();
        bookTree.insert(book1);
        bookTree.insert(book2);
        bookTree.insert(book3);
        bookTree.insert(book4);
        bookTree.insert(book5);

        bookTree.displayTree();

        System.out.println(bookTree.find(book5));
        System.out.println(bookTree.find(book6));

        System.out.println("root->left->right");
        bookTree.infixTraverse();
        System.out.println("\nleft->right->root");
        bookTree.prefixTraverse();
        System.out.println("\nleft->root->right");
        bookTree.postfixTraverse();
        System.out.println();
    }
}
