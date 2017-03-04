package chapter6;

import java.util.Arrays;

/**
 * Created by wangbin on 2017/3/3.
 */
public class Test6 {
    public static void main(String[] args) {
        int[] a = {10, 5, 9, 8, 7, 7, 6, 6, 6};
        int[] b = {10, 5, 9, 8, 7, 7, 6, 6, 6};
        RecursiveMaxHeapify.maxHeapify(a, 1);
        System.out.println(Arrays.toString(a));
        LoopMaxHeapify.maxHeapfiy(b, 1);
        System.out.println(Arrays.toString(b));

    }
}
