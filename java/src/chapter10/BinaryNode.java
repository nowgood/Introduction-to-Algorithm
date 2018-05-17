package chapter10;

/**
 * Created by NowGood on 2017/3/12.
 */
public class BinaryNode {
    int element;
    BinaryNode leftChild;
    BinaryNode rightChild;

    public BinaryNode(int element) {
        this(element, null, null);
    }
    public BinaryNode(int element, BinaryNode leftChild, BinaryNode rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
