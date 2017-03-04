package chapter4;

import java.util.Arrays;

/**
 * Created by wangbin on 2017/3/1.
 */
public class Exercise414 {


    public static int[] RecursiveFindMaxSubArray(int arr[]) {
        int[] a = pretreatment(arr);
        System.out.println(Arrays.toString(a));
        int b[] = findLeftRightSubArray(a, 0, a.length - 1);
        if (b[2] == 0) { //用来处理没有最大子数组的问题
            return new int[0];
        }
        return new int[] {b[0] -1, b[1], b[2]}; //处理购入的时间点
    }

    private static int[] pretreatment(int a[]) {
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i] - a[i-1];
        }
        a[0] = 0;
        return a;
    }

    private static int[] findLeftRightSubArray(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if(low == high) {
            return  new int[]{low, high, a[low]};
        }
        int[] ansLeft = findLeftRightSubArray(a, low, mid);
        int[] ansRight = findLeftRightSubArray(a, mid + 1, high);
        int[] ansMid = findMaxCrossingSubArray(a, low, high);
        if (ansLeft[2] >= ansRight[2] && ansLeft[2] >= ansMid[2]) {
            return ansLeft;
        } else if (ansRight[2] >= ansLeft[2] && ansRight[2] >= ansMid[2]) {
            return ansRight;
        } else {
            return ansMid;
        }
    }

    private static int[] findMaxCrossingSubArray(int a[], int low, int high) {
        int mid = (low + high) / 2;
        int leftSum, rightSum, left, right;
        left = right = mid;
        leftSum = -Integer.MAX_VALUE;
        rightSum = -Integer.MAX_VALUE;
        int sum = 0;
        for(int i = mid; i >= 0; i--) {
            sum = sum + a[i];
            if (sum > leftSum) {
                leftSum = sum;
                left = i;
            }
        }
        sum = 0; //detail
        for(int i = mid + 1; i <= high; i++) { // 从 mid + 1 而不是 mid 开始
            sum = sum + a[i];
            if (sum > rightSum) {
                rightSum = sum;
                right = i;
            }
        }
        return  new int[]{left, right, rightSum + leftSum} ;
    }
}
