package chapter10;

import java.util.List;

/**
 * Created by NowGood on 2017/3/10.
 *
 * 问题:10.2-4 : List -search' 如何在每次迭代的过程中省略对 哨兵的检查
 * 思路: 1. 首先,对于哨兵的检查是为了什么呢? 是为了看链表有没有遍历玩
 *       2. 如何在不检查哨兵的情况下,看是否遍历完了?
 *              将哨兵(nil)的关键字 key 设为 x.key,这样在链表遍历完时,如果没有找到x.key,
 *              就会在 哨兵 这里停止循环 , 应为 nil.key == x.key
 *
 *              然后判断 x 是否等于 nil 就知道是否找到了 关键字为 key 的节点

 */
public class Exercise1024 {
    ListNode nil;
    ListNode next;

    public Exercise1024() {
        this.nil = new ListNode(0);
        nil.next = nil; // important
        this.next = next;
    }
    public void insert(ListNode node) {
        if (node == null) {
            throw new RuntimeException("请输入一个非空的node");
        }
        node.next = nil.next;
        nil.next = node;
    }

    public ListNode search(int key) {
        nil.key = key;
        ListNode point = nil.next;
        while (point.key != key) {
            point = point.next;
        }
        if (point == nil) return null;
        else return point;
    }

    public ListNode delete(ListNode node) {
        ListNode point = nil.next;
        ListNode pre = nil;
        while (point != nil && point != node) {
            pre = point;
            point = point.next;
        }
        if (point == nil) return null;
        pre.next = point.next;
        return  point;
    }
    public void reverse() {
        ListNode point = nil.next;
        ListNode pre = nil;
        ListNode next;
        if (nil.next == null) return;
       while (point != nil) {
          next = point.next;
          point.next = pre;
          pre = point;
          point = next;
       }
       nil.next = pre;
    }
}
