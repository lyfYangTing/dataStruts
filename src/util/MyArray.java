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
     * ��ѭ��ʵ��������ۼӺ�����
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
     * �õݹ�ʵ������Ԫ�ص��ۼӺ�
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
     * �������������n-1��͵����ֵ����Сֵ
     *
     * @param array û��Ҫ��
     */
    public static void getMinAndMaxSum(int[] array) {
        MySort.positiveOrderSorting(array);//�����򣬴�С����
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
     * ͳ�����������ֵ�ĸ���
     *
     * @param ar
     * @return
     */
    static int getArrayMaxCount(int[] ar) {
        int n = ar.length;
        int count = 1;//ͳ�����ֵ�ĸ���
        for (int i = 1; i < n; i++) {
            if (ar[0] < ar[i]) {//a[0]���ŵ�һֱ����ʱ�����ֵ��һ�������ֵ��һ��ͳ�������
                int a = ar[0];
                ar[0] = ar[i];
                ar[i] = a;
                count = 1;//ÿ��һ�����ֵ����Ҫ����countֵ
                if (ar[i] == ar[0]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * ͳ��������ÿ��Ԫ�ص��ظ�����
     * @param array
     * @return
     */
    public static Map<Integer,Integer> getEveryElementCount(int[] array){
        Map<Integer,Integer> map = new TreeMap<>();//������� Ԫ��  ��������Ԫ�صĸ���
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
     * ��ȡ������Ԫ�ص���Ը��� ��:����� m��nԪ��   ��nԪ�ؿ���� m/2 ��
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
     * ��̬������������
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
