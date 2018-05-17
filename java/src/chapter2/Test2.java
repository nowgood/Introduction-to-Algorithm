package chapter2;

import java.util.Arrays;

/**
 * Created by wangbin on 2017/2/26.
 */
public class Test2 {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3, 6, 9, 8, 7, 0, 5};

        // 插入排序测试
        System.out.println("插入排序测试： " + Arrays.toString(Sort.insertSort(a)));


        //Exercise214测试
        int[] b = {1, 0, 0, 0, 0, 0, 1, 1};
        int[] c = {1, 1, 1, 1, 0, 0, 1, 1};
        System.out.println("Exercise214测试：  " + Arrays.toString(Exercise214.ex214(b, c)));

        System.out.println(Arrays.toString(Exercise234.recursionInsertSort(a, a.length - 1)));
        System.out.println("test");
    }
}

