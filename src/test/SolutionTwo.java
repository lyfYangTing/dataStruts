package test;

import util.MySort;

import java.util.Scanner;

/**
 * Created by 18435 on 2017/10/27.
 * Ī�ݿ��������ϲ���ĵ����̵���һ�����̺�һ��USB������̵����n�в�ͬƷ�Ƶļ��̺�n�ֲ�ͬƷ�Ƶ�USB��Ī�ݿ���Ҫ�������ܶ��Ǯ(Ҳ����˵����������ܳɱ�����������)��
 * ���ǵ��̵�ļ��̺�USB�������ļ۸��嵥���ҵ�����ӡ��Ī�ݿ������ѵ�Ǯ�������û���㹻��Ǯ��һ�����̺�һ��usb����������ӡ-1�෴��
 * ע����ʹ����ʣ���Ǯ����Ҳ������һ�����ϵļ��̺�һ��USB��
 * �����ʽ
 * ��һ�а��������ռ�ָ����������ֱ�����(Ī�ݿ�ӵ�е�Ǯ)(����Ʒ������)��(usb����Ʒ�Ƶ�����)��
 * �ڶ��а����ռ�ָ�����������ʾÿ������Ʒ�Ƶļ۸�.
 * �����а����ռ�ָ���������ʾÿ��usb������Ʒ�Ƶļ۸�.
 * �����ʽ
 * ��ӡһ����������ʾĪ�ݿ�Ҫ������Ǯ�������û���㹻��Ǯ��һ�����̺�һ��usb����������ӡ-1�෴��
 */
public class SolutionTwo {
    static int getMoneySpent(int[] keyboards, int[] drives, int s) {
        // Complete this function
        int money = -1;
        //���ѭ���Ӵ�С  ���ѭ����С����
        MySort.descendingOrderSorting(keyboards);//��������
        MySort.positiveOrderSorting(drives);//��������
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                if (keyboards[i] + drives[j] > s) {
                    break;
                }
                if (keyboards[i] + drives[j] > money) {
                    money = keyboards[i] + drives[j];
                }
            }
        }
        return money;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for (int drives_i = 0; drives_i < m; drives_i++) {
            drives[drives_i] = in.nextInt();
        }
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}
