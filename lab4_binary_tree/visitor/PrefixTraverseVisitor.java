package visitor;

import node.TreeNode;

// root-left-right
public class PrefixTraverseVisitor<T extends Comparable<T>> extends TreeVisitor<T> {

    @Override
    protected void visit(TreeNode<T> node) {
        if(node != null) {
            treeString += node.getValue() + " ";
            visit(node.getLeftChild());
            visit(node.getRightChild());
        }
    }
}
