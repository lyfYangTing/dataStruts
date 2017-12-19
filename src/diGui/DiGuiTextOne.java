package diGui;

/**
 *
 * Created by 18435 on 2017/9/25.
 * 实现斐波那契数列  1，1，2，3，5，8，13, 21, 34 ,55 ......
 */
public class DiGuiTextOne {

    int fbnq(int x){
        if(x<2){
            return x==0 ? 0 : 1;//fbnq(0)=0  fbnq(1)=1  基准情况:函数的值可以直接算出，不用求助递归
        }else{
            return fbnq(x-1)+fbnq(x-2);//fbnq(2)=f(0)+f(1)  fbnq(3)=f(2)+f(1)  递归调用
        }
    }

    public static void main(String[] args){
        DiGuiTextOne dg = new DiGuiTextOne();
        int sum = 0;
        for(int i=0;i<=10;i++){
            sum = sum + dg.fbnq(i);
        }
        System.out.println("sum="+sum);
    }
}
