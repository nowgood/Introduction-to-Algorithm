package chapter10;

import java.util.Arrays;

/**
 *
 * Created by NowGood on 2017/3/7.
 */
public class Test10 {

    /**
     * 功能 : 分界线
     * 说明: 由于 main 函数是静态函数, 所以把 boundary 也设成静态函数
     * @param string
     */
    public static void boundary(String string) {
        System.out.println("**********  " + string + "  *********");
    }

    public static void main(String[] args) {

        // 测试Exercise1012
        boundary("Exercise1012 Start");
        Exercise1012 exercise1012 = new Exercise1012(10);
        Exercise1012.Stack1 stack1 = exercise1012.new Stack1();
        Exercise1012.Stack2 stack2 = exercise1012.new Stack2();
        for (int i = 0; i < 5; i++) {
            stack1.push(i);
        }
        for (int i = 0; i < 5; i++) {
            stack2.push(i);
        }
        for (int i = 0; i < 5; i++) {
            stack1.pop();
        }
        // stack1.pop();
        System.out.println(Arrays.toString(exercise1012.array));

        boundary("Exercise1014 Start");
        Exercise1014 exercise1014 = new Exercise1014(5);
        for (int i = 0; i < 5 - 1; i++) {
            exercise1014.enqueue(i);
        }
        for (int i = 0; i < 5 - 1; i++) {
            exercise1014.dequeue();
        }
        // exercise1014.dequeue();
        System.out.println(Arrays.toString(exercise1014.array));

        boundary("Exercise1014 End");
        Exercise1015 exercise1015 = new Exercise1015(5);
        for (int i = 0; i < 4; i++) {
            exercise1015.frontEnqueue(i + 1);
        }
        System.out.println("在队头入队:  " + Arrays.toString(exercise1015.doublequeue));
        exercise1015.frontDequeue();
        System.out.println("在队头出队:  " + Arrays.toString(exercise1015.doublequeue));
        exercise1015.endEnqueue(90);
        System.out.println(Arrays.toString(exercise1015.doublequeue));

        boundary("Exercise1016 Start");

        Exercise1016 exercise1016 = new Exercise1016();
        for (int i = 0;i < 4; i++) {
            exercise1016.enqueue(i);
        }
        for (int i = 0;i < 4; i++) {
            System.out.println(exercise1016.dequeue());
        }
        exercise1016.enqueue(3);
        System.out.println(exercise1016.dequeue());
        // exercise1016.dequeue();

        boundary("Exercise1017 Start");

        Exercise1017 exercise1017 = new Exercise1017();
        for (int i = 01;i < 5; i++) {
            exercise1017.push(i);
        }
        for (int i = 0;i < 4; i++) {
            System.out.println(exercise1017.pop());
        }
        //exercise1017.push(3);
        //System.out.println(exercise1017.pop());

        boundary("Exercise1021 Start");

        Exercise1021 exercise1021 = new Exercise1021();
        for (int i = 0;i < 5; i++) {
            exercise1021.insert(new ListNode(i));
        }
        System.out.println(exercise1021.delete(4).key);
        System.out.println(exercise1021.delete(0).key);
        System.out.println(exercise1021.delete(2).key);
        System.out.println(exercise1021.delete(1).key);
        // System.out.println(exercise1021.delete(8).key);

        boundary("Exercise1022 Start");

        Exercise1022 exercise1022 = new Exercise1022();
        for (int i = 0;i < 5; i++) {
            exercise1022.push(new ListNode(i));
        }
        for (int i = 0;i < 5; i++) {
            System.out.println(exercise1022.pop().key);
        }

        boundary("Exercise1023 Start");

        Exercise1023 exercise1023 = new Exercise1023();
        for (int i = 0;i < 4; i++) {
            exercise1023.enqueue(new ListNode(i));
        }
        System.out.println(exercise1023.dequeue().key);
        System.out.println(exercise1023.dequeue().key);

        boundary("Exercise1024 Start");

        Exercise1024 exercise1024 = new Exercise1024();
        for (int i = 0;i < 5; i++) {
            exercise1024.insert(new ListNode(i));
        }
        System.out.println(exercise1024.delete(exercise1024.search(4)).key);

        boundary("Exercise1025 Start");
        // exercise1024.reverse();
        ListNode node = exercise1024.nil.next;
        while (node != exercise1024.nil) {
            System.out.println(node.key);
            node = node.next;
        }


    }
}