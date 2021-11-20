package visitor;

import node.TreeNode;

// left->root->right
public class InfixTraverseVisitor<T extends Comparable<T>> extends TreeVisitor<T> {

    @Override
    protected void visit(TreeNode<T> node) {
        if(node != null) {
            visit(node.getLeftChild());
            treeString += node.getValue() + " ";
            visit(node.getRightChild());
        }
    }
}
