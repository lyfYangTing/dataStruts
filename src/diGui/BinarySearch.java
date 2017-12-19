package diGui;

import util.MyMath;

/**
 * Created by 18435 on 2017/10/20.
 * 二分查找：
 * 用最少的比较次数在一个有序的数组中找到给定的一个数据项。
 * 把数组从中间分成两半，然后查找的数据项在数组的哪一半，再次地折半，如此这样下去。
 */
public class BinarySearch {
    private static int[] datas;
    private static void getSequenceDatas(int[] originalDatas) {//将原始数组转换成有序的数组
        for (int i = 0; i < originalDatas.length; i++) {
            for (int j = i; j < originalDatas.length; j++) {
                if (originalDatas[i] > originalDatas[j]) {//按从小到大的顺序
                    int data = originalDatas[i];
                    originalDatas[i] = originalDatas[j];
                    originalDatas[j] = data;

                }
            }
        }
        datas = originalDatas;
    }

    /**
     * @param startNumber  查找范围   startNumber ----  endNumber
     * @param endNumber
     * @param targetNumber 要查找的数字
     * @return
     */
    public static void getHalfNumber(int startNumber, int endNumber, int targetNumber) {
        int count = 1;
        if (startNumber >= 0 && endNumber < datas.length) {
            int guessIndex = (startNumber + endNumber) / 2;//可能会发生溢出
            int guessNumber = datas[guessIndex];
            int high = (int) MyMath.getLog(datas.length, 2);
            while (guessNumber != targetNumber) {//效率低
                if (guessNumber > targetNumber) {
                    endNumber = guessIndex - 1;
                } else {
                    startNumber = guessIndex + 1;
                }
                guessIndex = (startNumber + endNumber) / 2;// 3/2=1(去尾)
                guessNumber = datas[guessIndex];
                count++;
                if (count == (high + 1) && guessNumber != targetNumber) {//二叉查找树的树高
                    System.out.println("数组中没有你要查找的数字");
                    return;
                }
            }
            System.out.println("恭喜你，找到了您要的数字，它在数组的第" + guessIndex + "个位置");
        }
    }

    /**
     * 利用循环实现已经优化的二分查找算法实现
     * 在数组datas[low]-datas[high] 中查找goal
     * 通过不断改变low和high的值，来确定新的查找范围
     * 每循环一次，就把查找的范围（直接）折半
     * @param len  数组长度
     * @param goal
     * @return
     */
    public static int binary_search(int len, int goal) {
        int low = 0;
        int high = len <= datas.length ? len - 1 : datas.length - 1;
        while (low <= high) {
            int middle = (high - low) / 2 + low;//在此处用(high+low)/2 会在datas[0]处发生溢出
            if (datas[middle] == goal) {
                return middle;
            } else if (datas[middle] > goal) {
                high = middle - 1;//找到datas[middle]左边数组的右边界(左边界为0)  high在一直向左移
            } else {
                low = middle + 1;//找到datas[middle]右边数组的左边界(右边界为datas.length-1) low在一直向右移
            }
        }
        return -1;//没有找到
    }

    /**
     * 利用递归实现二分查找法
     * 不用改变low和high的值，
     * 而用low和high的新值作为参数反复调用binarySearchDiGui方法。
     * @param low
     * @param high
     * @param goal
     */
    public static int binarySearchDiGui(int low,int high,int goal){
        int middle = (high-low)/2 + low;
        if(low<=high){
            if(datas[middle]==goal){
                return middle;
            }else if(datas[middle]>goal){
                return binarySearchDiGui(0,middle-1,goal);
            }else{
                return binarySearchDiGui(middle+1,high,goal);
            }
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] datas = new int[]{12, 1, 4, 6, 8, 2, 9, 17, 7, 22};
        BinarySearch.getSequenceDatas(datas);
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + ",");
        }
        BinarySearch.getHalfNumber(0, 9, 12);
        int index = BinarySearch.binary_search(10, 12);
        if (index == -1) {
            System.out.println("没有找到要查找的数字");
        } else {
            System.out.println("您要查找的数字在数组的第" + index + "个位置");
        }

        int indexOne = BinarySearch.binarySearchDiGui(0,9,12);
        if (indexOne == -1) {
            System.out.println("没有找到要查找的数字");
        } else {
            System.out.println("您要查找的数字在数组的第" + index + "个位置");
        }
        //System.out.println((int)MyMath.getLog(17,2));
    }
}
