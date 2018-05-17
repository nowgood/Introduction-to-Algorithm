package chapter7;

/**
 * Created by wangbin on 2017/3/4.
 */
public class QuickSort {
    public static void quickSort(int[] a, int start, int end) {
        // 数组为空或者长度为0，不需要排序，直接返回
        if (a.length == 0 || a == null ) return;

        // 划分数组时，
        // 1. 当 a[end] 是最大值或者最小值时，出现这种 start > end 的情况，已排好序
        // 2. 当只有一个数需要排序时， 即已排好序
        if (start >= end) {
            return;
        }
        // 控制输入
        if (start < 0 || end > a.length - 1)
            throw new RuntimeException("ArrayIndexOutOfBoundsException");


        int partition = Partition(a, start, end);

        //partition 将原数组分为3部分：
        // 1. a[start] ~ a[partition - 1]
        // 2. a[partition]
        // 3. a[partition + 1] ~ a[end]
        quickSort(a, start, partition - 1);
        quickSort(a, partition + 1 , end);
    }

    // 快速排序的核心步骤
    private static int Partition(int[] a, int start, int end) {

        int mark = a[end];
        int count = start;
        for(int i = start; i < end; i++) {
            if (a[i] <= mark) {
                int temp = a [i];
                a[i] = a[count];
                a[count] = temp;
                count++;
            }
        }
        a[end] = a[count];
        a[count] = mark;
        return count;
    }

}

