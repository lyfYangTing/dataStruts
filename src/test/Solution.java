package test;

import util.MySort;

import java.util.Scanner;

/**
 * Created by 18435 on 2017/10/26.
 * 考虑两组正整数，A={a0,a1,a2,...an} 和 B={b0,b1,b2,...bn},我们说一个正整数x如果满足下列条件：
 * 1.A或B集合中只有1个元素，则该元素属 集合A和集合B的中间集
 * 2.x如果包含在A集合中，需要满足 x%a[i] == 0 则为中间级元素
 * 3.x如果包含在B集合中，需要满足 b[i]%x ==0  则为中间级元素
 * 4.不包含在A集合和B集合中其他x值，需要满足（x%a[i]==0 && b[i]%x==0） 则为中间集元素
 * 本例 ： 统计中间集元素个数
 */
public class Solution {
    static int getTotalX(int[] a, int[] b) {
        int count = 0;
        //先将两数组排序
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

    public static boolean getA(int[] array,int x){//判断x是否满足  x%array[i] == 0
        boolean isTrue = true;
        for(int i=0;i<array.length;i++){
            if(x % array[i] != 0){
                isTrue = false;
            }
        }
        return isTrue;
    }

    public static boolean getB(int[] array,int x){//判断x是否满足  array[i] % x == 0
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
         * 测试用例 :
         * 输入      n      m      a          b         输出
         *           1      3      2      20 30 12       1（2）
         *           2      3     2 4     16 32 96       3（4，8，16）
         *           2      1     2 6        12          2（6，12）
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
