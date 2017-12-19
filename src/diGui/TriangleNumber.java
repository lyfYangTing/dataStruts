package diGui;

/**
 * Created by 18435 on 2017/10/20.
 * 三角数字:
 * 序列1，3，6，10，15......
 * 1    1     1
 * 2    3     1+2
 * 3    6     1+2+3
 * 4    10    1+2+3+4
 * 5    15    1+2+3+4+5
 * n          1+2+3+4+5+.....+n
 */
public class TriangleNumber {

    /**
     * 获取该序列的第n项    利用递归
     * @param n
     */
    public static int getTriangleNumber(int n){
        if(n>1){
            return n + getTriangleNumber(n-1);//getTriangleNumber(n-1)为前n-1项的和
        }else{
            return 1;//基准情况
        }
    }

    /**
     * 利用等差数列求和公式解决
     * @param n   1+2+3+。。。。+n = （1+n）* n/2
     * @return
     */
    public static int getTriangleNumberByArithmetic(int n){
        if(n>=1){
            return (1+n)* n/2;
        }else{
            return 0;
        }
    }

    /**
     * 利用循环解决  n + (n-1)+ (n-2)+.....+1
     * @param n
     * @return
     */
    public static int getTriangleNumberByLoop(int n){
        int total = 0;
        while(n>0){
            total+=n;
            n--;
        }
        return total;
    }

    public static void main(String[] args){
        System.out.println(TriangleNumber.getTriangleNumber(1000));
        System.out.println(TriangleNumber.getTriangleNumberByArithmetic(1000));
        System.out.println(TriangleNumber.getTriangleNumberByLoop(1000));
    }
}
