package test;

import java.util.Scanner;

/**
 * Created by 18435 on 2017/10/27.
 * ������
 * �����Ǹ����ĵ�ͽ�������ߡ�����ϸ�ظ�������ͽ�����У����й�ע�����������Сϸ�ڡ������ϴ�Զ��ʱ��������n��̨�ס���ÿ��һ��������ע�⵽����һ�������»����¡������Զ�������յ㶼�Ǻ�ƽ�档���Ƕ������������
 *a.ɽ����������ķǿ����С����Ϻ�ƽ�棬��һ����ʼ�ϴӺ�ƽ�浽�յ��µ���ƽ�档(0��ʾ��ƽ��)��������  0 1 2 1 0 Ϊɽ����
 *b.������������ķǿ����С����º�ƽ�棬��һ����ʼ�´Ӻ�ƽ�浽�յ��ϵ���ƽ�档������  ���� 0 -1 -2 -1 0 Ϊ������
 * �����ʽ :
 * ��һ�а���һ����������ʾ����ͽ�����еĲ�����
 * �ڶ��а�����ɫ��ÿ���ַ��ڣ�U,D����ȡֵ(��Uָʾ����һ����Dָʾ����һ��)���Լ��ַ����е��ַ������˼������Զ�����ߵ�ÿһ����
 * Լ��:
 * �����ʽ
 *��ӡһ����������ʾ������Զ���ڼ��߹���ɽ���͹�����
 */
public class SolutionOne {

    /**
     * ��ֻ���У�U��D�����ַ���ת����int���� U����up,����һ��   D����down������һ��
     * @param s
     * @return
     */
    public static int[] StringToIntArray(String s){
        char[] ss = s.toCharArray();
        int[] numberArray = new int[ss.length+1];
        numberArray[0] = 0;
        for(int i=1;i<numberArray.length;i++){
            if(ss[i-1]=='U'){
                numberArray[i] = numberArray[i-1] + 1;
            }else{
                numberArray[i] = numberArray[i-1] - 1;
            }
        }
        return numberArray;
    }

    /**
     * ͳ��Ŀ��������array�����еĸ��� : �ڱ����о�����array��ͳ�� {0��-1}�����еĸ���
     * @param array   ��������
     * @param target  ������  ����İ취 ���Ľ���
     * @return
     */
    public static int getSubsequenceCount(int[] array,int[] target){
        int count = 0;
        for(int i=0;i<array.length-target.length;i++){
            boolean isTrue = true;
            for(int j=0;j<target.length;j++){
                if(array[i+j] != target[j]){
                    isTrue = false;//��ʾû��ƥ�䵽
                    break;
                }
            }
            if(isTrue){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        //�� UDDDUDUU ת���� ��������:ˮƽ������Ϊ0  �� {UDDDUDUU} ��ת���� 0,1,[0,-1,]-2,-1,-2,-1,0  1��ɽ��
        //{DD UU DD U D UUU D} ��ת���� [0,-1,] -2,-1, [0,-1,] -2,-1,-2,-1,0,1,0,   2           2��ɽ��
        int[] array = SolutionOne.StringToIntArray("UDDDUDUU");
        int[] target = new int[]{0,-1};
        System.out.println(SolutionOne.getSubsequenceCount(array,target));

        Scanner in = new Scanner(System.in);
        
    }
}
