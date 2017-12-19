package test.listTest;

import java.util.*;

/**
 * Created by 18435 on 2017/10/10.
 * ����һ����L����һ����P,���ǰ������������е�����������printLots(L,P)����ӡL����Щ��P
 * ��ָ����λ���ϵ�Ԫ�ء����磬���P = 1,3,4,6 ��ô��L��λ�ڵ�1����3����4�͵�6��λ���ϵġ�
 * Ԫ�ر���ӡ������д������printLots(L,P)��
 * ֻ����ʹ��public�͵�Collections API�����������ù��̵�����ʱ���Ƕ��٣�
 */
public class TextOne {
    /**
     * ����Set����ʵ��
     *
     * @param L
     * @param P
     */
    public static void printLots(Set<Integer> L, Set<Integer> P) {
        Object[] arrayL = L.toArray();
        System.out.println();
        System.out.println("----------������-------------");
        for (int p : P) {
            if (p > 0 && p < arrayL.length) {
                System.out.print(arrayL[p] + ",");
            } else {
                System.out.println("��Ԫ���ڼ���L�в�����");
            }
        }
    }

    /**
     * @param L
     * @param P
     */
    public static void printLotsTwo(List<Integer> L, List<Integer> P) {
        //�Ƚ����������е�Ԫ������
        Collections.sort(L);
        Collections.sort(P);
        //������������о�������Ԫ��
//        System.out.println();
//        System.out.println("-------����L---------");
//        for (int x : L) {
//            System.out.print(x + ",");
//        }
//        System.out.println();
//        System.out.println("-------����P---------");
//        for (int x : P) {
//            System.out.print(x + ",");
//        }
        //�������Ҫ���Ԫ��
        System.out.println();
        for (int p : P) {
            if (p > 0 && p < L.size()) {
                System.out.print(L.get(p) + ",");
            } else {
                System.out.println("��Ԫ���ڼ���L�в�����");
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> listL = new ArrayList<Integer>();
        listL.add(40);
        listL.add(30);
        listL.add(70);
        listL.add(90);
        listL.add(10);
        listL.add(50);
        listL.add(20);
        listL.add(80);
        listL.add(100);
        listL.add(60);
//        System.out.println("-------����L---------");
//        for(int x:setL){
//            System.out.print(x+",");
//        }
        List<Integer> listP = new ArrayList<>();
        listP.add(1);
        listP.add(6);
        listP.add(3);
        listP.add(4);
        listP.add(9);
//        System.out.println();
//        System.out.println("-------����P---------");
//        for(int x:setP){
//            System.out.print(x+",");
//        }
        long listStart = System.currentTimeMillis();
        TextOne.printLotsTwo(listL, listP);
        long listEnd = System.currentTimeMillis();
        System.out.println("list���ϴ�������ʱ��:" + (listEnd - listStart));


        Set<Integer> setL = new TreeSet<>();
        setL.add(40);
        setL.add(30);
        setL.add(70);
        setL.add(90);
        setL.add(10);
        setL.add(50);
        setL.add(20);
        setL.add(80);
        setL.add(100);
        setL.add(60);
//        System.out.println("-------����L---------");
//        for(int x:setL){
//            System.out.print(x+",");
//        }
        Set<Integer> setP = new TreeSet<>();
        setP.add(1);
        setP.add(6);
        setP.add(3);
        setP.add(4);
        setP.add(9);
//        System.out.println();
//        System.out.println("-------����P---------");
//        for(int x:setP){
//            System.out.print(x+",");
//        }
        long setStart = System.currentTimeMillis();
        TextOne.printLots(setL, setP);
        long setEnd = System.currentTimeMillis();
        System.out.println("set���ϴ�������ʱ��:" + (setEnd - setStart));



    }
}
