package test;

import util.MySort;

import java.util.Scanner;

/**
 * Created by 18435 on 2017/10/26.
 * ����������������A={a0,a1,a2,...an} �� B={b0,b1,b2,...bn},����˵һ��������x�����������������
 * 1.A��B������ֻ��1��Ԫ�أ����Ԫ���� ����A�ͼ���B���м伯
 * 2.x���������A�����У���Ҫ���� x%a[i] == 0 ��Ϊ�м伶Ԫ��
 * 3.x���������B�����У���Ҫ���� b[i]%x ==0  ��Ϊ�м伶Ԫ��
 * 4.��������A���Ϻ�B����������xֵ����Ҫ���㣨x%a[i]==0 && b[i]%x==0�� ��Ϊ�м伯Ԫ��
 * ���� �� ͳ���м伯Ԫ�ظ���
 */
public class Solution {
    static int getTotalX(int[] a, int[] b) {
        int count = 0;
        //�Ƚ�����������
        MySort.positiveOrderSorting(a);
        MySort.positiveOrderSorting(b);

        for(int x=a[a.length-1];x<=b[0];x++){
            if(x==a[a.length-1]){
                count = Solution.getA(a,x)==true ? count+1 : count;
            }else if(x==b[0]){
                count = Solution.getB(b,x)==true ? count+1 : count;
            }else{
                count = Solution.getA(a,x)==true && Solution.getB(b,x)==true ? count+1 : count;
            }
        }

        return count;

    }

    public static boolean getA(int[] array,int x){//�ж�x�Ƿ�����  x%array[i] == 0
        boolean isTrue = true;
        for(int i=0;i<array.length;i++){
            if(x % array[i] != 0){
                isTrue = false;
            }
        }
        return isTrue;
    }

    public static boolean getB(int[] array,int x){//�ж�x�Ƿ�����  array[i] % x == 0
        boolean isTrue = true;
        for(int i=0;i<array.length;i++){
            if(array[i] % x != 0){
                isTrue = false;
            }
        }
        return isTrue;
    }

    public static void main(String[] args) {
        /**
         * �������� :
         * ����      n      m      a          b         ���
         *           1      3      2      20 30 12       1��2��
         *           2      3     2 4     16 32 96       3��4��8��16��
         *           2      1     2 6        12          2��6��12��
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
