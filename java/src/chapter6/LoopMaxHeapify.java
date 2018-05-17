package chapter6;

/**
 * Created by wangbin on 2017/3/3.
 */
public class LoopMaxHeapify {
    public static void maxHeapfiy(int[] a, int index) {

        int tag = 0;
        while (tag == 0) {
            tag = 1;
            int left = (index + 1) * 2 - 1;
            int right = (index + 1) * 2;
            int larger = index;
            if (left < a.length && a[left] > a[index]) {
                larger = left;
            }
            // a[right] > a[larger], 要从三个中选择最大的，这里用 a[larger] 而不是 [index]
            if (right < a.length && a[right] > a[larger]) {
                larger = right;
            }
            if (larger != index) {
                int temp = a[larger];
                a[larger] = a[index];
                a[index] = temp;
                tag = 0;
                index = larger;
            }
        }
    }
}
