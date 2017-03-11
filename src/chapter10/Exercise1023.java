package chapter10;

import java.util.List;

/**
 * Created by NowGood on 2017/3/10.
 */
public class Exercise1023 extends Exercise1021 {

   public ListNode dequeue() {
       return delete();
   }
   public void enqueue(ListNode node) {
       if (node == null) {
           throw new RuntimeException("请输入一个非空的node");
       }
       if (head == null) {
           head = tail = node;
       } else{
          tail.next = node;
          tail = node;
       }
   }
}
