package util;

import java.math.BigDecimal;

/**
 * Created by 18435 on 2017/10/23.
 * 数学算术表达式相关计算
 */
public class MyMath {

    /**
     * 计算 底不是以e为底的对数
     * 利用换底公式    logx(y) = loge(x)/loge(y)
     * 注：logx(y) log以x为底y的对数
     * @param value
     * @param base
     * @return
     */
    public static double getLog(double value,double base){
        return Math.log(value)/Math.log(base);
    }

    /**
     * 通过BigDecimal进行大数之间的运算
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal add(BigDecimal a,BigDecimal b){
        return a.add(b);
    }


    public static void main(String[] args){
//        long a = 1000000000000000000l;
//        long b = 9000000000000000000l;
//        BigDecimal bigDecimal = new BigDecimal(a);
//        BigDecimal result = bigDecimal.add(new BigDecimal(b));
//        System.out.println(bigDecimal);
        String stringBinary = Integer.toBinaryString(2545);
        System.out.println(stringBinary);
        String[] stringBinarys = stringBinary.split("0");
        for(String s : stringBinarys){
            System.out.println("---->"+s);
        }
    }
}
