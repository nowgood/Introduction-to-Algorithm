package chapter4;

import java.util.Arrays;

/**
 * Created by wangbin on 2017/3/1.
 */
public class Test4 {
    public static void main(String[] args) {
        int[] a = {1, 5, 7, 2, 9};
        System.out.println(Arrays.toString(Exercise412.FindMaxSubstring(a)));
        System.out.println(Arrays.toString(Exercise414.RecursiveFindMaxSubArray(a)));
        System.out.println(Arrays.toString(Exercise415.findMaxSubString(a)));
    }
}
