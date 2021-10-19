package node;

public class TreeNode<T> {
    private T value;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(final TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(final TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "[" +
                "value: " + value +
                ", leftChild: " + leftChild +
                ", rightChild: " + rightChild +
                "]";
    }
}
