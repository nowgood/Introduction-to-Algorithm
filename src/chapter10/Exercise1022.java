package chapter10;

/**
 * Created by NowGood on 2017/3/10.
 */
public class Exercise1022 extends Exercise1021{
    public void push (ListNode node) {
        insert(node);
    }
    public ListNode pop() {
       return delete();
    }
}
