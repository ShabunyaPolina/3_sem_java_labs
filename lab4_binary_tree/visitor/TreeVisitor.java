package visitor;

import node.TreeNode;
import structure.BinaryTree;

public abstract class TreeVisitor<T extends Comparable<T>> {
    protected String treeString = "";

    public void visit(BinaryTree<T> tree) {
        visit(tree.getRoot());
    };

    protected abstract void visit(TreeNode<T> node);

    public String getTreeString() {
        return treeString;
    }
}