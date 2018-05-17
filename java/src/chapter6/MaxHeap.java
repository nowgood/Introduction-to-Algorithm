package chapter6;

/**
 * Created by wangbin on 2017/3/16.
 *
 * 这里讨论数组都是下标从1开始：A[1...n]
 *
 * 理解：
 * 这里谈一下对于堆的一点小理解
 * 1. 比如说下面的代码，在第一次写堆的时候，我创建了堆的两个属性：堆的大小（heapSize） 和 存储堆的数组(heapArray)
 *    到后面的时候，感觉这个 heapArray 很鸡肋。我觉得可能是下面原因导致的：
 *    1）建立堆的过程，实际上就是在外部传入一个数组，而不是在类的内部形成一个数组
 *    2） 一般来说，对于一个堆来说，是不需要插入操作的，我们所说的 MAX-HEAPIFY 并不是插入，而是建堆的一个操作，有以下特征
 *          a. 当然，其两个儿子都应经是最大堆的根节点，最重要的是，不影响原本的树结构（我们不关心树每个节点装的是什么，只在乎他的形状）
 *          b. 需要插入的元素原本就存储在数组之中， 且插入的位置都在A[1]之前(包括 A[1])
 *          c. 我们指的插入操作应该是，插入一个原本不在数组中的数，并且 heapSize 加 1
 *
 *
 *2. 现在来看看如果想对一个堆进行`插入操作`的话，由于一般堆的底层数据结构是数组，抽象数据类型又是一个完全二叉树
 *   1）所以在把当前堆当成其儿子节点，来插入是错误的，因为另一个儿子是 null，这样就不是完全二叉树了
 *   2）在头部插入，通过与当前头结点比较，找到较大值，然后，找到其中较小的，然后在下一层比较，这里问题在于，我们插入了一个外来元素，树的结构
 *   发生了改变，我们从上往下插入的话，在下一层，我们该去把上一轮比较的较小值比其左右儿子的值都大，下一步我们让他与左儿子交换 还是 右儿子呢？
 *   这个处理起来很困难
 *   3）从尾部插入，只要当前的 heapSize < Array.length,就把 x 插入 A[heapSize + 1]，这样可能破坏了堆的性质，
 *   然后通过与上面的作比较，自下如上的处理，使 插入元素 所在的节点变成一个堆。
 *
 *   这样我们能够看出来，其实插入的过程就是 建堆，我们把该元素插入到当前堆的数组的尾部，然后重新建堆，
 *   当然插入的操作要简单的多，我们只需要把 插入元素和 ta 的父亲比，这个操作最坏的时间花费是树的高度 O（lgn）
 *
 *
 *3. 再来谈谈 通过数组建堆的过程中，对于 heapSize 做的鸡肋操作
 *   其实，我们已经知道了这个堆建立后，heapSize 有多大，我还掩耳盗铃的，通过赋初值，然后每一次调用 MAX-HEAPIFY 就加 1；
 *
 *
 *4. 最后提醒一下：
 *
 * 这里我们说的下标是从0开始的数组的下标
 * 思想依然是，先用从 1 开始的数组来思考，然后转化成从一开始
 * 最好一个非叶节点的下标是：   floor(heapSize/2) - 1
 *
 *
 *
 *
 *
 *
 */
public class MaxHeap {

    private int heapSize;
    private int[] heapArray;

    public MaxHeap(int length) {
        this.heapSize = 0;
        heapArray = new int[length];
    }

    public MaxHeap() {
        this(0);
    }

    public int[] buildMaxHeap(int[] arr) {
        if (arr == null) return null;
        heapArray = arr;
        // 由于是从数组建立堆的，所以已经知道了最后堆的大小，且 floor[n/2] ~ n 是叶子节点，已经满足了
        // 因此: 把堆的初始大小设为 arr.length - (arr.length / 2 + 1) + 1 = arr.length - arr.length / 2 ;
        // MaxHeapify过程的使用条件是，A[i]的两个儿子都应该是最大堆的根节点
        heapSize = arr.length - arr.length / 2 ;
        for (int i = (heapArray.length/ 2 - 1); i >= 0; i--) {
            MaxHeapify(i, arr[i]);
        }

        return heapArray;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public int[] getHeapArray() {
        return heapArray;
    }


    public void MaxHeapify(int i, int key) {
        if (heapSize == heapArray.length)
            throw new StackOverflowError();

        // 插入节点若是叶子节点的话，以该节点为根的子树已经符合最大堆的条件
        // 叶子节点可以看成只有一个节点的堆。
        heapArray[i] = key;

        // 记录父节点和儿子节点中最大值的索引
        int largest = i;
        // 需要先验证 A[i] 是否已经是根节点
        if (leftChildIndex(i) <= heapSize && (heapArray[leftChildIndex(i)] > heapArray[largest])) {
            largest = leftChildIndex(i);
        }
        if (rightChildIndex(i) <= heapSize && heapArray[rightChildIndex(i)] > heapArray[largest]) {
            largest = rightChildIndex(i);
        }

        if (largest != i) {
            exchange(i, largest);
            MaxHeapify(largest, key);
        } else {
            heapSize++;
        }
        /**
         if(i > （(heapSize  / 2 - 1）) {  // 这个判断虽然逻辑没错，但是不适用我们这里；
         // 因为我们这里是从数组建立堆的时候，当前的堆并不是一个已经建好完全二叉树
         heapSize++;
         } else {

         // 记录父节点和儿子节点中最大值的索引
         int largest = i;
         if (heapArray[leftChildIndex(i)] > heapArray[largest] ) {
         largest = leftChildIndex(i);
         }
         if (heapArray[rightChildIndex(i)] > heapArray[largest]) {
         largest = rightChildIndex(i);
         }

         if (largest != i) {
         exchange(i, largest);
         MaxHeapify(largest, key);
         }
         }
         **/
    }

    private void exchange(int index1, int index2) {
        int temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }


    private int leftChildIndex(int parent) {
        return 2 * parent + 1;
    }
    private int rightChildIndex(int parent) {
        return 2 * parent + 2;
    }
}
