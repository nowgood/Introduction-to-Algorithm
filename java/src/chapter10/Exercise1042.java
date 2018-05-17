package chapter10;

/**
 * Created by NowGood on 2017/3/12.
 * 习题10.4-2
 */
public class Exercise1042 {
    public void drawTree(BinaryNode root) {
        if (root == null) return;
        BinaryNode recursion = root;
        System.out.print(recursion.element);
        drawTree(recursion.leftChild);
        drawTree(recursion.rightChild);
    }
}
