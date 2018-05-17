package chapter9;

/**
 * Created by NowGood on 2017/3/4.
 */
public class Exercise911 {
    BinaryNode head;
    BinaryNode child;
    BinaryNode parent;
    BinaryNode firstPoint;
    BinaryNode secondPoint;
    BinaryNode parentPoint;

    public int firstSmall(int[] arr) {
        if (arr.length < 1 || arr == null)
            throw new RuntimeException("No data");
        if (arr.length == 1)
            throw new RuntimeException("No second smaller data");

        head = new BinaryNode(arr[0]);
        head.next = new BinaryNode(arr[1]);
        // 第一次处理数组,由于输入数组是整型,和后续处理不同,故设置tag = 1
        // 表示第一次处理
        int tag = 1;
        while (head.next != null) {
            if (tag == 1) {
                    for (int i = 0; i < arr.length; i += 2) {
                        if (i == arr.length - 1) {
                            child = new BinaryNode(arr[i]);
                            parent = new BinaryNode(arr[i]);
                            parent.leftChild = child;
                        } else if (arr[i] < arr[i + 1]){
                            parent = new BinaryNode(arr[i]);
                            parent.leftChild = new BinaryNode(arr[i]);
                            parent.rightChild = new BinaryNode(arr[i+1]);
                        }else {
                            parent = new BinaryNode(arr[i + 1]);
                            parent.leftChild = new BinaryNode(arr[i + 1]);
                            parent.rightChild = new BinaryNode(arr[i]);
                        }
                        if (tag == 1) {
                            head = parent;
                            parentPoint = parent;
                            tag = 0;
                        } else {
                            parentPoint.next = parent;
                            parentPoint = parent;
                        }
                    }
            }

            BinaryNode x = head;
            while (x != null) {
                System.out.print(x.element + " ");
                x = x.next;
            }
            System.out.println();
            firstPoint = head;
            head = null;
            while (firstPoint != null) {
                //secondPoint 两个元素比较中 指向第二个元素的指针
                secondPoint = firstPoint.next;
                if (secondPoint == null) {
                    parent = new BinaryNode(firstPoint.element);
                    parent.leftChild = firstPoint;
                    firstPoint = firstPoint.next;
                } else if (firstPoint.element < secondPoint.element){
                    parent = new BinaryNode(firstPoint.element);
                    parent.leftChild = firstPoint;
                    parent.rightChild = secondPoint;
                    firstPoint = secondPoint.next;
                }else {
                    parent = new BinaryNode(secondPoint.element);
                    parent.leftChild = secondPoint;
                    parent.rightChild = firstPoint;
                    firstPoint = secondPoint.next;
                }
                if (head == null) {
                    head = parent;
                    parentPoint = parent;
                } else {
                    parentPoint.next = parent;
                    parentPoint = parent;
                }
            }
        }
        BinaryNode y = head;
        while (y != null) {
            System.out.print(head.element + " ");
            y = y.next;
        }
        System.out.println();
        return head.element;
    }
    public int secondSmall(int[] arr) {
        if (arr.length < 2)
            throw new RuntimeException("no second element");
        int firstSmall = firstSmall(arr);
        System.out.println("最小值为 :  " + firstSmall);

        int secondSmall = Integer.MAX_VALUE;
        while (head.leftChild != null) {
            if (head.rightChild == null) {
                return secondSmall;
            }
            if (secondSmall > head.rightChild.element){
                secondSmall = head.rightChild.element;
            }
            head = head.leftChild;
            }
        return secondSmall;
    }

    private class BinaryNode {
        int element;
        BinaryNode next;
        BinaryNode leftChild;
        BinaryNode rightChild;

        public BinaryNode(int element) {
            this.element = element;
            next = null;
            leftChild = null;
            rightChild = null;
        }
    }
}
