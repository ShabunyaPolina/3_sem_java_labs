package visitor;

import node.TreeNode;

//left-right-root
public class PostfixTraverseVisitor <T extends Comparable<T>> extends TreeVisitor<T> {

    @Override
    protected void visit(TreeNode<T> node) {
        if(node != null) {
            visit(node.getLeftChild());
            visit(node.getRightChild());
            treeString += node.getValue() + " ";
        }
    }
}
