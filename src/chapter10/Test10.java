package chapter10;

import java.util.Arrays;

/**
 * Created by wangbin on 2017/3/7.
 *
 * 未完成，各种错误
 */
public class Test10 {
    public static void main(String[] args) {
        Exercise1012 exercise1012 = new Exercise1012(20);
       Exercise1012.Stack1 stack1 = exercise1012.new Stack1();
       Exercise1012.Stack2 stack2 = exercise1012.new Stack2();

       for (int i = 0; i < 10; i++) {
           stack1.push(10 + i);
       }

        for (int i = 0; i < 10; i++) {
            stack2.push(20);
        }

        System.out.println(Arrays.toString(exercise1012.array));


    }
}
