package util;

import java.math.BigDecimal;

/**
 * Created by 18435 on 2017/10/23.
 * ��ѧ�������ʽ��ؼ���
 */
public class MyMath {

    /**
     * ���� �ײ�����eΪ�׵Ķ���
     * ���û��׹�ʽ    logx(y) = loge(x)/loge(y)
     * ע��logx(y) log��xΪ��y�Ķ���
     * @param value
     * @param base
     * @return
     */
    public static double getLog(double value,double base){
        return Math.log(value)/Math.log(base);
    }

    /**
     * ͨ��BigDecimal���д���֮�������
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
