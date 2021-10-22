package structure;

import node.TreeNode;

import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void insert(T value) {
        TreeNode<T> newNode = new TreeNode<>(value);
        if (root == null)
            root = newNode;
        else {
            TreeNode<T> current = root;
            TreeNode<T> parent;
            while (true) {
                parent = current;
                int cmp = value.compareTo(current.getValue());
                if (cmp < 0) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public TreeNode<T> find(T value) {
        if (root == null)
            return null;
        TreeNode<T> current = root;
        while (current.getValue() != value) {
            int cmp = value.compareTo(current.getValue());
            if (cmp < 0)
                current = current.getLeftChild();
            else
                current = current.getRightChild();
            if (current == null)
                return null;
        }
        return current;
    }

    public void prefixTraverse(TreeNode<T> node) {  // root-left-right
        if (node != null) {
            System.out.print(node.getValue() + " ");
            prefixTraverse(node.getLeftChild());
            prefixTraverse(node.getRightChild());
        }
    }

    public void postfixTraverse(TreeNode<T> node) {  // left-right-root
        if (node != null) {
            postfixTraverse(node.getLeftChild());
            postfixTraverse(node.getRightChild());
            System.out.print(node.getValue() + " ");
        }
    }

    public void infixTraverse(TreeNode<T> node) {  // left-root-right
        if (node != null) {
            infixTraverse(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            infixTraverse(node.getRightChild());
        }
    }

    public void displayTree() {
        Stack<TreeNode<T>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while (!isRowEmpty) {
            Stack<TreeNode<T>> localStack = new Stack<TreeNode<T>>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; ++j)
                System.out.print(' ');
            while (!globalStack.isEmpty()) {
                TreeNode<T> temp = (TreeNode<T>) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; ++j)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
        System.out.println(
                "......................................................");
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
