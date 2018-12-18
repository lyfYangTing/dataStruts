package arrayTest;

/**
 * Created by 18435 on 2018/11/1.
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4输出: 2
 * 示例 2:
 * 输入: 8输出: 2说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去
 */
public class MySqurt {

    /**
     * 二分法
     * @return
     */
    public static int mysqrt(int x){
        long low = 1;
        long high = x;
        while (low<high){
            long middle = low + (high - low)/2;
            if(middle*middle==x){
                return (int)middle;
            }else if(middle*middle > x){
                high = middle - 1;
            }else {
                low = low + 1;
            }
        }
        if(low*low>x){
            return (int)low-1;
        }
        return (int)low;
    }

    /**
     * 原理：二分法
     * 注意点：1.low high middle的数据类型是int
     *         2.循环条件 low和high相等时，还需要再一次循环
     * @param x
     * @return
     */
    public static int mySqrt(int x){
        int low = 1;
        int high = x;
        while(low <= high){
            int middle = low + (high - low)/2;
            if(x/middle==middle){
                return middle;
            }else if (x/middle > middle){
                low = middle + 1;
            }else {
                high = middle - 1;
            }
        }
        //此时high<low
        return high;
    }

    public static void main(String[] args) {
        System.out.println(MySqurt.mysqrt(8));
        System.out.println(MySqurt.mySqrt(8));
    }
}
