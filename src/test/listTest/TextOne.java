package test.listTest;

import java.util.*;

/**
 * Created by 18435 on 2017/10/10.
 * 给定一个表L和另一个表P,它们包含以升序排列的整数。操作printLots(L,P)将打印L中那些由P
 * 所指定的位置上的元素。例如，如果P = 1,3,4,6 那么，L中位于第1，第3，第4和第6个位置上的、
 * 元素被打印出来。写出过程printLots(L,P)。
 * 只可以使用public型的Collections API容器操作。该过程的运行时间是多少？
 */
public class TextOne {
    /**
     * 利用Set集合实现
     *
     * @param L
     * @param P
     */
    public static void printLots(Set<Integer> L, Set<Integer> P) {
        Object[] arrayL = L.toArray();
        System.out.println();
        System.out.println("----------处理后的-------------");
        for (int p : P) {
            if (p > 0 && p < arrayL.length) {
                System.out.print(arrayL[p] + ",");
            } else {
                System.out.println("该元素在集合L中不存在");
            }
        }
    }

    /**
     * @param L
     * @param P
     */
    public static void printLotsTwo(List<Integer> L, List<Integer> P) {
        //先将两个集合中的元素排序
        Collections.sort(L);
        Collections.sort(P);
        //输出两个集合中经排序后的元素
//        System.out.println();
//        System.out.println("-------集合L---------");
//        for (int x : L) {
//            System.out.print(x + ",");
//        }
//        System.out.println();
//        System.out.println("-------集合P---------");
//        for (int x : P) {
//            System.out.print(x + ",");
//        }
        //输出符合要求的元素
        System.out.println();
        for (int p : P) {
            if (p > 0 && p < L.size()) {
                System.out.print(L.get(p) + ",");
            } else {
                System.out.println("该元素在集合L中不存在");
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
//        System.out.println("-------集合L---------");
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
//        System.out.println("-------集合P---------");
//        for(int x:setP){
//            System.out.print(x+",");
//        }
        long listStart = System.currentTimeMillis();
        TextOne.printLotsTwo(listL, listP);
        long listEnd = System.currentTimeMillis();
        System.out.println("list集合处理运行时间:" + (listEnd - listStart));


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
//        System.out.println("-------集合L---------");
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
//        System.out.println("-------集合P---------");
//        for(int x:setP){
//            System.out.print(x+",");
//        }
        long setStart = System.currentTimeMillis();
        TextOne.printLots(setL, setP);
        long setEnd = System.currentTimeMillis();
        System.out.println("set集合处理运行时间:" + (setEnd - setStart));



    }
}
