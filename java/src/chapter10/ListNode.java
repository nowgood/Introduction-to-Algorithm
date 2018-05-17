package chapter10;

/**
 * Created by NowGood on 2017/3/10.
 */
public class ListNode {
    int key;
    ListNode pre;
    ListNode next;

    public ListNode(int key) {
        this.key = key;
        this.pre = null;
        this.next = null;
    }
}
