package util;

/**
 * Created by 18435 on 2017/10/25.
 * 希尔排序相当于直接插入排序的升级，它们同属于插入排序类
 * 堆排序相当于简单选择排序的升级，它们同属于选择排序类
 * 快速排序相当于冒泡排序的升级，它们同属于交换排序类
 */
public class MySort {
    /**
     * 交换排序法：从小到大排序  这是最简单的排序方法,但是效率极低
     *
     * @param array
     */
    public static void positiveOrderSorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }
    }

    /**
     * 交换排序法：从大到小排序
     *
     * @param array
     */
    public static void descendingOrderSorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }
    }

    /**
     * 冒泡排序:两两比较  相邻记录   的关键字,如果反序则交换,直到没有反序的记录为止
     *
     * @param array
     */
    public static void bubblingSorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {//从后往前循环  相对较小的值会往前冒
                if (array[j - 1] > array[j]) {//比较的是相邻元素的大小
                    int a = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = a;
                }
            }
        }
    }

    /**
     * 冒泡排序改进版:减少对 已经有序的序列进行反复比较(减少比较次数)  避免因已经有序的情况下无意义循环判断
     * 时间复杂度分析:
     * 最好的情况:要排序的表本身就是有序的    (n-1)次的比较                   没有数据交换    时间复杂度为 O(n)
     * 最坏的情况:待排序表是逆序的(1+2+3+...+(n-1))=[n*(n-1)/2]次的比较      作等数量级的记录移动   时间复杂度为O(n*n)
     *
     * @param array
     */
    public static void bubblingSortingImprove(int[] array) {
        boolean isOrderliness = false;//判断需要比较的后面的元素序列是否有序  false--->无序    true--->有序了(无需继续向下比较)
        for (int i = 0; i < array.length && !isOrderliness; i++) {
            isOrderliness = true;
            for (int j = array.length - 1; j > i; j--) {//没有任何数据交换,这就说明此序列已经有序,不需要再继续后面的循环判断工作了
                if (array[j - 1] > array[j]) {
                    int a = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = a;
                    isOrderliness = false;
                }
            }
        }
    }

    /**
     * 简单选择排序:就是通过(n-i)次关键字间的比较,从(n-i+1)个记录中选出关键字最小的记录,并和第i(1<=i<=n)个记录交换
     * 时间复杂度分析:  总的时间复杂度为 O(n*n)
     * 比较次数:最好的情况和最坏的情况比较次数一样，都是 n*(n-1)/2 次
     * 交换次数:最好的情况交换为0次，最坏的情况交换为（n-1）次
     *
     * @param array
     */
    public static void simpleSelectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {//找到最小值  才会进行交换操作
                int min = array[minIndex];
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }

    /**
     * 直接插入排序算法:基本操作是将一个记录插入到已经排好序的有序表中，从而得到一个新的，记录数增1的有序表。
     * 插入排序保证从位置0到位置p-1上的元素为已排序状态
     * 时间复杂度分析:
     * 最好的情况: 要排序的表本来就是有序的， 比较次数 (n-1) 次   没有移动  时间复杂度为O(n)
     * 最坏的情况: 要排序的表是逆序的   比较次数 (2+3+4+5+...+n)即(n+2)*(n-1)/2 和 移动次数 (3+4+5+...+(n+1))即(n+4)*(n-1)/2
     * 排序记录是随机的,则平均比较和移动次数约为 n*n/4 次  ，则该排序法的时间复杂度为O(n*n)
     *
     * @param array
     */
    public static void straightInsertionSort(int[] array) {
        //在插入第i个元素的时候，i之前的部分已经是有序序列了
        int j;
        for (int i = 1; i < array.length; i++) {//array[i]为正在插入的元素
            if (array[i] < array[i - 1]) {//需要将正在插入的元素不能插到有序序列尾部 需要通过比较插入到前面的有序序列的适当位置
                int tmp = array[i];
                for (j = i; j > 0 && array[j - 1] > tmp; j--) {
                    array[j] = array[j - 1];//记录向后移动
//                    if (array[j] < array[j - 1]) {//需要交换值，比先将要插入的元素的值放入到一个临时遍量，记录仅向后移动的交换次数多
//                        int x = array[j];
//                        array[j] = array[j - 1];
//                        array[j - 1] = x;
//                    } else {
//                        break;
//                    }
                }
                array[j] = tmp;//将元素插入到该位置   这个位置的前一个元素值小于插入的元素
            }
        }
    }

    /**
     * 希尔排序(也是一种插入排序  缩小增量排序):把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
     * 关键：增量序列的选择
     * 一般增量取值（但不是最优的增量序列）:gap=length/2，缩小增量继续以gap = gap/2的方式，
     * 这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为增量序列。(增量序列的最后一个值必须是1)
     *
     * @param array
     */
    public static void donaldShellSorting(int[] array) {
        int increment = array.length / 2;   //增量，，即可以将该序列分成 increment 组  对同一组的元素进行直接插入排序
        int j;
        while (increment > 0) {
            for (int i = increment; i < array.length; i++) {
                if (array[i] < array[i - increment]) {//现在正插入的元素比同一组的前一个元素小
                    int temporary = array[i];//临时存放正在插入元素的值
                    for (j = i; j >= increment && array[j - increment] > temporary; j -= increment) {//同组元素直接插入
                        array[j] = array[j - increment];
                    }
                    array[j] = temporary;
                }
            }
            increment = increment / 2;
        }
    }

    /**
     * 堆：堆是具有下列性质的完全二叉树，每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
     * 每个结点的值都小于或等于其左右孩子结点的值,称为小顶堆。
     * 按照层序遍历的方式给结点从1开始编号，则结点之间满足以下关系:
     * k(i)>=k(2i) && k(i)>=k(2i+1)  或   k(i)<=k(2i) && k(i)<=k(2i+1)      1<=i<=[n/2]
     * 二叉树性质：一颗完全二叉树，如果i=1,则结点i是二叉树的根，无双亲；如果i>1,则其双亲是结点[i/2]
     * 堆排序：将待排序的序列构造成一个大顶堆。此时，整个序列的最大值就是堆顶的根结点。
     * 将它移走（其实就是将其与堆数组的末尾元素交换，此时末尾元素就是最大值），
     * 然后将剩余的（n-1）序列重新构造成一个堆，这样就会的到n个元素中的次小值。
     * 如此反复执行，便能得到一个有序序列了。
     * 主要需要解决的问题:
     * 1)如何由一个无序序列构建成一个堆?
     * 2)如何在输出堆顶元素后，调整剩余元素成为一个新的堆?
     *
     * @param array
     */
    public static void heapSorting(int[] array) {
        for (int i = array.length; i > 1; i--) {
            //将数组构造成满足大顶堆性质的形式
            MySort.getLargeRoofHeap(array, i);//构建大顶堆
            //将大顶堆的最顶部元素(这个堆的最大值)与 第i个元素交换
            MySort.swap(array, 0, i - 1);//将根元素与末尾元素交换
        }
    }

    /**
     * 将数组构转换成大顶堆  (自己的想法)  缺点：数据交换次数多   不断重新构建堆
     *
     * @param array  转换的数组
     * @param length 需转换的数组长度
     */
    public static void getLargeRoofHeap(int[] array, int length) {
        //System.out.println("length/2-1----------------->"+(length/2-1));
        for (int i = length / 2 - 1; i >= 0; i--) { //从最后一个根结点向上转换
            //System.out.println("i--------->"+i+"------a[i]------------->"+array[i]);
            if (2 * (i + 1) == length && array[i] < array[2 * (i + 1) - 1]) {
                MySort.swap(array, i, 2 * (i + 1) - 1);
            }
            if ((array[i] < array[2 * (i + 1) - 1] || array[i] < array[2 * (i + 1)]) && 2 * (i + 1) < length) {//即  k(i)<k(2i) 不满足跟大于其左孩子的值
                if (array[2 * (i + 1) - 1] > array[2 * (i + 1)]) {//2*(i+1)  =  2*(i+1)+1-1  表示根节点的右孩子下标    元素交换的次数较多
                    MySort.swap(array, i, 2 * (i + 1) - 1);
                } else {
                    MySort.swap(array, i, 2 * (i + 1));
                }
            }
            //System.out.println("i--------->"+i+"------a[i]------------->"+array[i]);
        }
    }

    /**
     * 堆排序：参考书上的想法
     * 1.以线性时间建立一个堆
     * 2.每次将堆中的最后一个元素与第一个元素交换
     * 3.将堆的大小缩减1，将剩余的（n-1）序列重新构造成一个堆
     *
     * @param array
     */
    public static void heapSort(int[] array) {

        //构建一个大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            MySort.percDown(array, i, array.length);
        }
        for (int a : array) {
            System.out.print(a + ",");
        }
        System.out.println("-----------------------------------");

        for (int i = array.length - 1; i > 0; i--) {
            //将堆中的最后一个元素与第一个元素交换
            MySort.swap(array, 0, i);
            for (int a : array) {
                System.out.print(a + ",");
            }
            System.out.println();
            //剩余元素重新调整成一个大顶堆   在原来堆的基础上，将array[0]调整到合适的位置
            MySort.percDown(array, 0, i);
        }
    }

    /**
     * 查找将以array[i]为根的子树的最大结点，并将其放到array[i]处
     *
     * @param array           构建堆的原数组
     * @param currentRootNode 当前子树根节点
     * @param heapSize        堆的长度  （堆中元素和已被删除的元素同在array数组中，所以以heapSize代表现在堆的长度）
     */
    public static void percDown(int[] array, int currentRootNode, int heapSize) {
        int child;
        int tmp;//一直存放的是传进来结点的值   循环一次结束 执行一次 currentRootNode = child
        for (tmp = array[currentRootNode]; MySort.getLeftChild(currentRootNode) < heapSize; currentRootNode = child) {
            child = MySort.getLeftChild(currentRootNode);//用来记录 当前子树最大值的下标
            if (child != heapSize - 1 && array[child + 1] > array[child]) {//右孩子比左孩子的值大
                child++;
            }
            if (tmp < array[child]) {
                array[currentRootNode] = array[child];//将tem插入到合适位置，比tem大的元素会整体向前移动覆盖
            } else {
                break;
            }
        }
        array[currentRootNode] = tmp;
    }

    /**
     * 归并排序原理：
     * 假设初始序列含有n个记录，则可以看成是n个有序的子序列，每个子序列的长度为1，然后两两归并，
     * 得到[n/2]个长度为2或1的有序子序列；再两两归并...如此重复，直至得到一个长度为n的有序序列为止。
     * 归并排序基本操作：合并两个已排序的的表
     *
     * @param array
     */
    public static void mergeSort(int[] array) {
        int[] temporaryArray = new int[array.length];
        //MySort.mergingSortByRecursion(array, temporaryArray, 0, array.length);
        MySort.mergingSortByCycle(array, temporaryArray);
    }

    /**
     * 通过递归实现
     *
     * @param originalArray  源数组
     * @param temporaryArray 临时数组，用来暂时存放两数组合并后的数据
     * @param startIndex
     * @param endIndex
     */
    public static void mergingSortByRecursion(int[] originalArray, int[] temporaryArray, int startIndex, int endIndex) {
        int middle = (startIndex + endIndex) / 2;
        if (startIndex < endIndex) {
            mergingSortByRecursion(originalArray, temporaryArray, startIndex, middle);//给数组前半部分排序
            mergingSortByRecursion(originalArray, temporaryArray, middle + 1, endIndex);//给数组后半部分排序
            merge(originalArray, temporaryArray, startIndex, middle + 1, endIndex);//合并以上两个有序序列
        }
    }

    /**
     * 通过循环实现
     *
     * @param originalArray
     * @param temporaryArray
     */
    public static void mergingSortByCycle(int[] originalArray, int[] temporaryArray) {
        //将分解的数组合并
        int subSequenceLength = 1;
        while (subSequenceLength < originalArray.length) {
            subSequenceLength *= 2;
            int subSeqCount = originalArray.length % subSequenceLength == 0 ? originalArray.length / subSequenceLength : originalArray.length / subSequenceLength + 1;
            for (int start = 0; start < subSeqCount; start++) {
                //合并两个数组
                if ((start * subSequenceLength + subSequenceLength / 2) <= originalArray.length - 1) {
                    int behindIndex = start * subSequenceLength + subSequenceLength - 1 < originalArray.length ? start * subSequenceLength + subSequenceLength - 1 : originalArray.length - 1;
//                    System.out.println("frontStartIndex--------->"+subSequenceLength*start);
//                    System.out.println("behindIndex------->"+(start*subSequenceLength+subSequenceLength-1));
                    MySort.merge(originalArray, temporaryArray, start * subSequenceLength, start * subSequenceLength + subSequenceLength / 2, behindIndex);
                }
            }
        }
    }

    /**
     * 归并排序中   合并两个子序列
     *
     * @param originalArray    源数组
     * @param temporaryArray   临时数组
     * @param frontStartIndex  前一个子序列的开始索引
     * @param behindStartIndex 后一个子序列的开始索引
     * @param behindEndIndex   两个子序列合并后的  序列最后一个索引
     */
    public static void merge(int[] originalArray, int[] temporaryArray, int frontStartIndex, int behindStartIndex, int behindEndIndex) {
        int tempPos = frontStartIndex;
        int frontEnd = behindStartIndex - 1;
        int num = behindEndIndex - frontStartIndex + 1;
        while (frontStartIndex <= frontEnd && behindStartIndex <= behindEndIndex) {
            if (originalArray[frontStartIndex] < originalArray[behindStartIndex]) {
                temporaryArray[tempPos++] = originalArray[frontStartIndex++];
            } else {
                temporaryArray[tempPos++] = originalArray[behindStartIndex++];
            }
        }

        while (frontStartIndex <= frontEnd) {
            temporaryArray[tempPos++] = originalArray[frontStartIndex++];
        }

        while (behindStartIndex <= behindEndIndex) {
            temporaryArray[tempPos++] = originalArray[behindStartIndex++];
        }

        for (int i = 0; i < num; i++, behindEndIndex--) {
            originalArray[behindEndIndex] = temporaryArray[behindEndIndex];
        }
    }

    /**
     * 快速排序驱动程序
     * <p>
     * 快速排序基本思想:(冒泡排序的升级，同属交换排序)
     * 通过一趟排序将待排记录分割成独立的两部分，其中一部分记录的关键字均比另一部分记录的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序的目的。
     * <p>
     * 一般步骤：
     * 1)如果S中元素个数是0或1，则返回
     * 2)取S中任一元素v,称之为枢纽元
     * 3)将S-{v}(S中其余元素)划分成两个不相交的集合
     * 4)返回quickSort(S1)后跟v继而返回quicksort(S2)
     *
     * @param array
     */
    public static void quickSort(int[] array) {

        //MySort.quickSortRecursion(array,0,array.length-1);
        MySort.quickSort(array, 0, array.length - 1);
    }

    public static void quickSortRecursion(int[] array, int startIndex, int endIndex) {
        //先将自己这部分进行相应调整
        MySort.quickSorting(array, startIndex, endIndex);
//        System.out.println("startIndex------->"+startIndex);
//        System.out.println("endIndex--------->"+endIndex);
//        for(int i:array){
//            System.out.print(i+",");
//        }
//        System.out.println();

        //将记录不断分成两部分
        if (endIndex > startIndex) {
            int middle = startIndex + (endIndex - startIndex) / 2;
            MySort.quickSortRecursion(array, startIndex, middle);
            MySort.quickSortRecursion(array, middle + 1, endIndex);
        }
    }

    /**
     * 将需要排序的部分，再分成两部分，进行交换排序  (自己的想法，效率低，太死)
     * 通过随机选取枢纽源，将需要排序的部分 再分成两部分（这两部分可以不是等长的）
     * 目的：将需要排序的部分  调整成  前半部分记录的关键字均比后半部分记录的关键字
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSorting(int[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i <= startIndex + (endIndex - startIndex) / 2; i++) {
            int minIndex = i;
            for (int j = startIndex + (endIndex - startIndex) / 2 + 1; j <= endIndex; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {//最小值已经改变  交换两个元素位置
                MySort.swap(array, i, minIndex);
            }
        }
    }

    /**
     * 快速排序优化版:
     * (1)选取枢纽元
     * 1)安全做法：可以随机选取
     * 2)三数中值分割法：使用数组左端，右端，中心位置上的三个元素的中值作为枢纽元
     * (2)分割策略:
     * 1)将枢纽元与最后的元素交换使得枢纽元离开要被分割的数据段。
     * 2)分割阶段：把所有小元素移到数组的左边，把所有元素移到数组的右边。"小"和"大"是相对于枢纽元
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {

        if(endIndex - startIndex>0){
            int middle = MySort.medianOfThree(array, startIndex, endIndex);

            //当i和j停止时,i指向一个大元素而j指向一个小元素，如果i在j的左边，那么将这两个元素互换
            int i = startIndex;//从前往后找，将i不断右移，移过那些小于枢纽元的元素
            int j = endIndex - 2;//从后往前，将j不断左移，移过那些大于枢纽元的元素
            while (true) {
                while (array[i] < middle) {
                    ++i;
                }
                while (array[j] > middle) {
                    --j;
                }
                //i和j停止了移动   array[i]和array[j]和middle值相等时，i和j也会停止移动
                if (i < j) {
                    MySort.swapBytemp(array, i, j);
                } else {
                    break;
                }
            }
            //当i移动带j的右边时，停止移动，跳出循环  交换枢纽元与i所指向的元素
            MySort.swapBytemp(array, i, endIndex - 1);

            MySort.quickSort(array, startIndex, i - 1);
            MySort.quickSort(array, i + 1, endIndex);
        }else{
            return;
        }
    }

    /**
     * 根据三数中值分割法获取
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int medianOfThree(int[] array, int left, int right) {
        int middle = (right + left) / 2;
        if (array[left] > array[middle]) {
            MySort.swapBytemp(array, left, middle);
        }
        if (array[left] > array[right]) {//将三个数中的最小值放到数组中left位置
            MySort.swapBytemp(array, left, right);
        }
        if (array[middle] > array[right]) {
            MySort.swapBytemp(array, middle, right);
        }
        //将枢纽元与最后的元素交换使得枢纽元离开要被分割的数据段
        MySort.swapBytemp(array, middle, right - 1);
        return array[right - 1];
    }

    /**
     * 交换数组元素  有bug,当a=b时不能正常交换
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void swapBytemp(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    /**
     * 获取根元素(array[0]为第一个根元素)的左孩子结点坐标
     *
     * @param i
     * @return
     */
    public static int getLeftChild(int i) {
        return 2 * i + 1;//由于第一个结点的坐标是0  所以完全二叉树根结点(从1开始)和左孩子结点可以表示为（2*i-1）
        // 则当i从0开始算时 左孩子结点下标可表示 2*(i+1)-1 = 2*i+1
    }

    public static void main(String[] args) {
        int[] a = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        int[] b = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
        MySort.quickSort(b);
        //System.out.println(a);
        for (int i : b) {
            System.out.print(i + ",");
        }
    }
}
