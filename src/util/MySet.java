package util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 18435 on 2017/11/3.
 *
 */
public class MySet {
    private Set<Integer> set = new HashSet<Integer>();

    /**
     * ���ɿ� ����������ʱ �ڴ�ͱ��ˡ�������������Ҫ������ Object[] bridgeArray = bridgeSet.toArray();
     * @param oldArray
     */
    public static void getMedianArray(int[] oldArray){
        double[] medianArray = new double[oldArray.length];
        Set<Integer> bridgeSet = new HashSet<Integer>();
        //���ɼ���(��ֱ������)   ��Ϊ����Ԫ�ظ����������������鳤�Ⱥ�û�б���ֵ�ĵط�Ĭ��ֵΪ0
        for(int i=0;i<oldArray.length;i++){
            bridgeSet.add(oldArray[i]);
            //Object[] bridgeArray = bridgeSet.toArray();
//            if(bridgeArray.length%2==1){
//                medianArray[i] = (int)bridgeArray[bridgeArray.length/2];
//            }else{
//                medianArray[i] = ((int)bridgeArray[bridgeArray.length/2] + (int)bridgeArray[bridgeArray.length/2-1])/2.0;
//            }
            Iterator<Integer> iterator = bridgeSet.iterator();
            int count = 0;
            while(iterator.hasNext()){
                int x = iterator.next();
                if(count==bridgeSet.size()/2){
                    if(bridgeSet.size()%2==1){
                        medianArray[i] = x;
                    }else{
                        medianArray[i] = (x + iterator.next())/2.0;
                    }
                    break;
                }
                count++;
            }
        }
        //�����ֵ����
        for(int i=0;i<medianArray.length;i++){
            System.out.println(medianArray[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        MySet.getMedianArray(a);
        String s = "assdsds";
        char[] ss = s.toCharArray();
    }

//    public static void main(String[] args){
//        Set<Integer> set = new HashSet<Integer>();
//        Object[] bridgeArray = set.toArray();
//        int a = 3;
//        System.out.println(a/2.0);
//    }
}
