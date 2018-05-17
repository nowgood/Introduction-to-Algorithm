package chapter2;

/**
 * Created by wangbin on 2017/2/26.
 */
public class Sort {
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // key 为拿起来的牌
           int key = arr[i];
           for (int j = i-1; j >= 0; j--) {
                if (key > arr[j]) {
                    arr[j+1] = arr[j];
                    // 拿起来的牌 key 为现有牌中最小值
                    if (j == 0) {
                        arr[j] = key;
                    }
                } else {
                    arr[j+1] = key;
                    break;
                }
            }
        }
        return arr;
    }
}