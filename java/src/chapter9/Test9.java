package chapter9;

/**
 * Created by wangbin on 2017/3/4.
 */
public class Test9 {
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 9, 8};
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("次小值为 :  " + new Exercise911().secondSmall(a));
    }
}
