package chapter4;

import java.util.Arrays;

/**
 * Created by wangbin on 2017/3/3.
 * 时间复杂度：O(n)
 */
public class Exercise415 {


    public static int[] findMaxSubString(int arr[]) {
        int a[] = pretreatment(arr);
        int temp = 0;
        int[] maxSum = {0, 0, Integer.MIN_VALUE};
        int tag = 0;
        for (int k = 0; k < a.length; k++) {
            temp += a[k];
            if (temp > maxSum[2]){
                maxSum[2] = temp;
                maxSum[1] = k;
                maxSum[0] = tag;
            }
            if (temp < 0 ) {
                temp = 0;
                tag = k;
            }
        }
        return maxSum;
    }

    private static int[] pretreatment(int a[]) {
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i] - a[i-1];
        }
        a[0] = 0;
        return a;
    }
}
