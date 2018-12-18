package arrayTest;

/**
 * Created by 18435 on 2018/11/1.
 * ʵ�� int sqrt(int x) ������
 * ���㲢���� x ��ƽ���������� x �ǷǸ�������
 * ���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
 * ʾ�� 1:
 * ����: 4���: 2
 * ʾ�� 2:
 * ����: 8���: 2˵��: 8 ��ƽ������ 2.82842...,
 * ���ڷ���������������С�����ֽ�����ȥ
 */
public class MySqurt {

    /**
     * ���ַ�
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
     * ԭ�����ַ�
     * ע��㣺1.low high middle������������int
     *         2.ѭ������ low��high���ʱ������Ҫ��һ��ѭ��
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
        //��ʱhigh<low
        return high;
    }

    public static void main(String[] args) {
        System.out.println(MySqurt.mysqrt(8));
        System.out.println(MySqurt.mySqrt(8));
    }
}
