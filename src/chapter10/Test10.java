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
        System.out.println();
        System.out.println("**********  " + string + "  *********");
        System.out.println();
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
        boundary("Exercise1012 End");

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
        boundary("Exercise1015 End");
        Exercise1015 exercise1015 = new Exercise1015(5);
        for (int i = 0; i < 4; i++) {
            exercise1015.frontEnqueue(i + 1);
        }
        System.out.println("在队头入队:  " + Arrays.toString(exercise1015.doublequeue));
        exercise1015.frontDequeue();
        System.out.println("在队头出队:  " + Arrays.toString(exercise1015.doublequeue));
        exercise1015.endEnqueue(90);
        System.out.println(Arrays.toString(exercise1015.doublequeue));
        boundary("Exercise1015 End");
    }
}
