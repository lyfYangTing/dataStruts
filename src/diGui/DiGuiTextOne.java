package diGui;

/**
 *
 * Created by 18435 on 2017/9/25.
 * ʵ��쳲���������  1��1��2��3��5��8��13, 21, 34 ,55 ......
 */
public class DiGuiTextOne {

    int fbnq(int x){
        if(x<2){
            return x==0 ? 0 : 1;//fbnq(0)=0  fbnq(1)=1  ��׼���:������ֵ����ֱ����������������ݹ�
        }else{
            return fbnq(x-1)+fbnq(x-2);//fbnq(2)=f(0)+f(1)  fbnq(3)=f(2)+f(1)  �ݹ����
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
