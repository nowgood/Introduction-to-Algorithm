package chapter10;

/**
 * Created by NowGood on 2017/3/10.
 */
public class Exercise1021 {
    /**
     * 问题回答: insert 可以
     *           delete 不可以(由于不知道无法通过 O(1) 时间获取上一个节点的指针
     *
     * 其实在单链表中,可以不要tail,
     * 1. 模拟栈, 由于操作在一头进行, 所以也不需要;
     * 2. 模拟队列, 操作在队头 和 队尾进行;
     *    为了使enqueue 和 dequeue 时间复杂度为O(1),tail必不可少
     *
     */
    ListNode head;
    ListNode tail;

    public Exercise1021() {
        this.head = null;
        this.tail = null;
    }

    public void insert(ListNode node) {
        if (node == null) {
            throw new RuntimeException("请输入一个非空的node");
        }
        if (head == null) {
            head =  tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    /**
     * 删除包含关键字的key的节点
     * @param key
     * @return
     */
     public ListNode delete(int key){
        ListNode point = head;
        ListNode pre = head;
        while (point != null && point.key != key) {
            pre = point;
            point = point.next;
        }
        if (point != null) {
            if (point == head  && point == tail) {
                head = tail = null;
            } else if (point == head) {
                head = head.next;
            } else if (point == tail) {
                pre.next = null;
                tail = pre;
            } else{
                pre.next = point.next;
            }
        }
        // 这里没找到,返回为空, 对象调用时.存在空指针的危险
        return  point;
     }

    /**
     * 删除头元素
     * @return
     */
    public ListNode delete(){
         ListNode point;
         if (head == null) {
             throw new RuntimeException("underflow");
         } else if (head == tail) {
             point = head;
             head = tail = null;
         } else {
             point = head;
             head = head.next;
         }
         return  point;
    }

}
