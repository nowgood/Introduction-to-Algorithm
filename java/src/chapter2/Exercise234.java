package chapter2;

/**
 * Created by wangbin on 2017/2/28.
 */
public class Exercise234 {


    // 插入排序的递归解法
    public static int[] recursionInsertSort(int[] a, int index) {
        if (a == null || index == 0) return a;
        a = recursionInsertSort(a, index - 1);
        return insertion(a, a[index], index);
    }


    // 1.静态方法中不可以包含非静态方法
    // 2.函数作用：插入排序 的 插入过程
    private static int[] insertion(int[] a, int key, int index) {
        int i = index - 1;
        for (; i >= 0; i--) {
            if (key <= a[i]) {
                a[i + 1] = a[i];
                if (i == 0) {
                    a[i] = key;
                }
            } else {
                a[i + 1] = key;
                break;
            }
        }
        return a;
    }
}

