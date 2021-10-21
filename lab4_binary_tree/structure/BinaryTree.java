package structure;

import node.TreeNode;

public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    // constructors
    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
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
        if(root == null)
            return null; // ????????????????????
        TreeNode<T> current = root;
        while(current.getValue() != value) {
            int cmp = value.compareTo(current.getValue());
            if(cmp < 0)
                current = current.getLeftChild();
            else
                current = current.getRightChild();
            if(current == null)
                return null;
        }
        return current;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
