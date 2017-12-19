package util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by 18435 on 2017/10/25.
 */
public class MyArray {

    /**
     * 用循环实现数组的累加和运算
     *
     * @param n
     * @param ar
     * @return
     */
    static int simpleArraySum(int n, int[] ar) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ar[i];
        }
        return sum;
    }

    /**
     * 用递归实现数组元素的累加和
     *
     * @param lastIndex
     * @param ar
     * @return
     */
    static int simpleArraySumByDiGui(int lastIndex, int[] ar) {
        if (lastIndex > 0) {
            return ar[lastIndex] + simpleArraySumByDiGui(lastIndex - 1, ar);
        } else {
            return ar[0];
        }
    }

    /**
     * 求出数组中任意n-1项和的最大值和最小值
     *
     * @param array 没有要求
     */
    public static void getMinAndMaxSum(int[] array) {
        MySort.positiveOrderSorting(array);//先排序，从小到大
        long maxSum = 0;
        long minSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                maxSum += array[i];
            }
            if (i < array.length - 1) {
                minSum += array[i];
            }
        }
        System.out.println(minSum + " " + maxSum);
    }

    /**
     * 统计数组中最大值的个数
     *
     * @param ar
     * @return
     */
    static int getArrayMaxCount(int[] ar) {
        int n = ar.length;
        int count = 1;//统计最大值的个数
        for (int i = 1; i < n; i++) {
            if (ar[0] < ar[i]) {//a[0]里存放的一直是暂时的最大值，一边找最大值，一边统计其个数
                int a = ar[0];
                ar[0] = ar[i];
                ar[i] = a;
                count = 1;//每换一次最大值，需要重置count值
                if (ar[i] == ar[0]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 统计数组中每个元素的重复次数
     * @param array
     * @return
     */
    public static Map<Integer,Integer> getEveryElementCount(int[] array){
        Map<Integer,Integer> map = new TreeMap<>();//用来存放 元素  和数组中元素的个数
        for(int i=0;i<array.length;i++){
            if(map.get(array[i])==null){
                map.put(array[i],1);
            }else{
                map.replace(array[i],map.get(array[i])+1);
            }
        }
        return map;
    }

    /**
     * 获取数组中元素的配对个数 即:如果有 m个n元素   则n元素可配成 m/2 对
     * @param array
     */
    public static int sockMerchant(int[] array){
        TreeMap<Integer,Integer> map = (TreeMap<Integer, Integer>) MyArray.getEveryElementCount(array);
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer,Integer>> iterator = set.iterator();
        int count = 0;
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            int value = entry.getValue();
            count = count + value/2;
        }
        return count;
    }

    /**
     * 动态扩充数组容量
     * @param array
     */
    public static int[] dynamicExpansionCapacity(int[] array){
        int[] newArray= new int[3*array.length/2+1];
        for(int i=0;i<array.length;i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] ar = new int[n];
//        for (int ar_i = 0; ar_i < n; ar_i++) {
//            ar[ar_i] = in.nextInt();
//        }
//        int result = simpleArraySum(n, ar);
//        System.out.println(result);
//        int result1 = simpleArraySumByDiGui(n - 1, ar);
//        System.out.println(result1);
        int[] array = new int[]{10,20,20,10,10,30,50,10,20};
        System.out.println(MyArray.sockMerchant(array));



    }
}
