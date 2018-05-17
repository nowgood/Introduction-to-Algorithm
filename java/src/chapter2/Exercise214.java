package chapter2;

import java.util.Arrays;

/**
 * Created by wangbin on 2017/2/26.
 */
public class Exercise214 {
    public static int[] ex214 (int[] a, int[] b) {
        int[] sum = new int[a.length + 1];
        int carryBit = 0;
        for (int i = a.length - 1; i >= 0 ; i--) {
            sum[i+1] = (a[i] + b[i] + carryBit) % 2;
            carryBit = (a[i] + b[i] + carryBit) / 2;
        }
        sum[0] = carryBit;
        return sum;
    }
}
