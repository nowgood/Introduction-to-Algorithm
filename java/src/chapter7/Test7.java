package chapter7;

import java.util.Arrays;

/**
 * Created by wangbin on 2017/3/4.
 */
public class Test7 {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3, 6, 9, 8, 7, 0, 5};
        QuickSort.quickSort(a, 0, a.length - 1 );
        System.out.println(Arrays.toString(a));
    }
}
