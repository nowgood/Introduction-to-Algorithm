package chapter10;

/**
<<<<<<< HEAD
 * Created by wangbin on 2017/3/7.
 * 习题10.1-2
 */

public class Exercise1012 {
   int[] array;
   int[] top;
   int[] size;

    public Exercise1012(int size) {
        this.array = new int[size];
        this.top = new int[2];
        this.size = new int[2];
    }

    public class Stack1 {

        public void push(int data) {
            Exercise1012.this.push(data, 0);
        }

        public int pop() {
            return Exercise1012.this.pop(0);
        }

        public boolean empty() {
            return Exercise1012.this.empty(0);
=======
 * Created by NowGood on 2017/3/7.
 */
public class Exercise1012 {
    int[] array;
    int size1, size2;
    int top1, top2;



    public Exercise1012(int size) {
        this.array = new int[size];
        this.size1 = 0;
        this.size2 = 0;
        this.top1 = -1;
        this.top2 = size;
    }

    public class Stack1 {
        public void push(int data) {
            if ((size1 + size2) < array.length ) {
                top1 += 1;
                size1 += 1;
                array[top1] = data;
            } else {
                throw new RuntimeException("overflow");
            }
        }

        public int pop() {
            if (empty()) {
                throw new RuntimeException("underflow");
            } else {
                size1++;
                return array[(--top1) + 1];
            }
        }

        public boolean empty() {
            if (size1 == 0) {
                return true;
            } else {
                return false;
            }
>>>>>>> origin/master
        }
    }

    public class Stack2 {
<<<<<<< HEAD
        public void push(int data) { Exercise1012.this.push(data, 1);}

        public int pop() {
            return Exercise1012.this.pop(1);
        }

        public boolean empty() {
            return Exercise1012.this.empty(1);
        }

    }

    public boolean empty(int mark) {
        if (size[mark] == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param data
     * @param mark 标识是 入 Stack1 还是 Stack2
     */
    private void push(int data, int mark) {
        int length = size[0] + size[1];

        if(length == array.length) {
            throw new RuntimeException("Overflow ");
        }
        // 移动的半径
        int radius = (array.length - length + 1) / 2 ;

        int one = mark;
        int other = 1 - mark;

        if (size[one] == 0) {
            top[one] = (top[other] + radius) / array.length;
        } else {
            top[one] = (top[one] + 1) % array.length;
        }


        if (empty(other)) {
            array[top[one]] = data;
        } else {

            int bottom = (top[other] + array.length - size[other] + 1) % array.length;
            if (bottom != top[one]) {
                array[top[one]] = data;
            } else {

                for (int i = size[other] - 1; i >= 0; i--) {
                    array[(i + radius + bottom) % array.length] = array[(i + bottom) % array.length];
                }
                array[top[one]] = data;
            }
        }
        size[one] += 1;
    }

    private int pop(int mark) {
        int one = mark;
        if (empty(size[one])) {
            throw new RuntimeException("underflow");
        }
        size[one] -= 1;
        int ret = array[top[one]];
        top[one] = (top[one] - 1 + array.length) % array.length;
        return ret;
=======
        public void push(int data) {
            if ((size1 + size2) < array.length ) {
                size2++;
                array[--top2] = data;
            } else {
                throw new RuntimeException("overflow");
            }
        }

        public int pop() {
            if (empty()) {
                throw new RuntimeException("underflow");
            } else {
                size2--;
                return array[(++top2) - 1];
            }
        }

        public boolean empty() {
            if (size2 == 0) {
                return true;
            } else {
                return false;
            }
        }
>>>>>>> origin/master
    }
}
