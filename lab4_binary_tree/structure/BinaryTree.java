package structure;

import node.TreeNode;

public class BinaryTree<T> {
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
        if(root == null)
            root = newNode;
        else {
            TreeNode<T> current = root;
            TreeNode<T> parent;
            while (true) {
                parent = current;
                int cmp = value.compareTo(current.getValue());
                if(value < current.getValue()) {

                }
            }
        }
    }
}
