package test.listTest;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 18435 on 2017/10/10.
 * Josephus����:
 *    N���˱�Ŵ�1��N,Χ����һ��ԲȦ����1�ſ�ʼ����һ��������������M�δ��ݺ���������������
 *    �����������Χ����ԲȦ��С�������ڱ�������˺��������������������������Ϸ�����ʣ�µ��˻�ʤ��
 *
 *    ���磺
 *    ��� M=0 �� N=5 ,����Ϸ�����������5����Ϸ�˻�ʤ
 *    ��� M=1 �� N=5 ,��������˵�˳����2��4��1��5
 *
 *    a.��дһ��������M��N��һ��ֵ�µ�Josephus���⣬Ӧʹ���򾡿��ܵظ�Ч�ʣ�Ҫȷ���ܹ����������Ԫ��
 *    b.��ĳ��������ʱ��
 *
 *    �������:
 *      1.һ�ַ��������ǿ���ʹ�ö��С���Ϊ����ÿ�ζ��Ǵ���n��Ԫ�����m��Ԫ�ء�
 *       ÿ�δӶ�����һ��ȡԪ�أ�һ���ּ��뵽���е�ĩβ��ֱ��������m��ʱ�������m��Ԫ��ֱ�������Ƴ������Ǿͱ�֤��ȡ��ǡ����Ԫ�أ�ͬʱ�ֱ�֤ԭ������˳��û�иı䡣
 *       ����һֱѭ��n�飬���ǾͿ��Խ�����Ԫ�ض�ȡ�����ˡ���ǰ�����۵Ĺ������ǾͿ��Կ���������ʱ�临�Ӷ�ΪO(m*n)��
 *      2.����ѭ������ �� ˫��ѭ������  Sxxhlb.java----->public void josePhus(int n, int m) ����
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
//    public void process(int interval) {//����һ ���� �ؼ�����
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
