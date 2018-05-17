package chapter4;

/**
 * Created by wangbin on 2017/3/1.
 *
 * 说明：用暴力解法求最大子数组问题
 * 时间复杂度：O(n2)
 * 空间复杂度：O(1)
 */
public class Exercise412 {


    public static int[] FindMaxSubstring(int[] a) {
        int[] maxRange = new int[3];
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int temp = a[j] - a[i];
                if (temp > maxRange[2]) {
                    maxRange[0] = i;
                    maxRange[1] = j;
                    maxRange[2] = temp;
                }
            }
        }
        return maxRange;
    }
}
