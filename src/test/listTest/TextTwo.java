package test.listTest;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 18435 on 2017/10/10.
 * Josephus问题:
 *    N个人编号从1到N,围坐成一个圆圈。由1号开始传递一个热土豆。经过M次传递后拿着热土豆的人
 *    被清除离座，围坐的圆圈缩小，由坐在被清除的人后面的人拿起热土豆继续进行游戏，最后剩下的人获胜。
 *
 *    例如：
 *    如果 M=0 和 N=5 ,则游戏人依序被清除，5号游戏人获胜
 *    如果 M=1 和 N=5 ,则被清除的人的顺序是2，4，1，5
 *
 *    a.编写一个程序解决M和N在一般值下的Josephus问题，应使程序尽可能地高效率，要确保能够清除各个单元。
 *    b.你的程序的运行时间
 *
 *    解决方案:
 *      1.一种方法是我们可以使用队列。因为我们每次都是处理n个元素里第m个元素。
 *       每次从队列里一边取元素，一边又加入到队列的末尾，直到数到第m的时候。这个第m的元素直接让它移除，我们就保证了取到恰当的元素，同时又保证原来环的顺序没有改变。
 *       这样一直循环n遍，我们就可以将所有元素都取出来了。从前面讨论的过程我们就可以看到，它的时间复杂度为O(m*n)。
 *      2.单向循环链表 或 双向循环链表  Sxxhlb.java----->public void josePhus(int n, int m) 方法
 */
public class TextTwo {

    public static void josePhus(Sxxhlb sxxhlb,int M,int N){
       // List<Integer> list = new LinkedList<>();
//        for(int i=1;i<=N;i++){
//            list.add(i);
//        }
       //int start = list.
        for(int i=0;i<N;i++){
            int oldData =sxxhlb.remove(M);
            System.out.print("--"+oldData);
        }
    }
//    public void process(int interval) {//方案一 队列 关键代码
//        if(interval <= 0)
//            throw new IllegalArgumentException("Invalid interval");
//        int length = queue.size();
//        for(int i = 0; i < length; i++) {
//            for(int j = 0; j < interval; j++) {
//                T t = queue.remove();
//                queue.add(t);
//            }
//            T removed = queue.remove();
//            System.out.println(removed);
//        }
//    }
    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();
        for(int i=1;i<=10;i++){
            list.add(i);
        }
        //int size = list.size()/2;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==3){
                list.remove(i);
                //i--;
            }
            System.out.println("-"+list.get(i));
        }
//        for(int i:list){
//            if(i==3){
//                list.remove(i);
//            }
//        }
        System.out.println(list.size());
    }
}
