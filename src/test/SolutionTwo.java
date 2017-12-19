package test;

import util.MySort;

import java.util.Scanner;

/**
 * Created by 18435 on 2017/10/27.
 * 莫妮卡想从她最喜欢的电子商店买一个键盘和一个USB。这家商店出售n中不同品牌的键盘和n种不同品牌的USB。莫妮卡想要花尽可能多的钱(也就是说，她购买的总成本必须是最大的)。
 * 考虑到商店的键盘和USB驱动器的价格清单，找到并打印出莫妮卡将花费的钱。如果她没有足够的钱买一个键盘和一个usb驱动器，打印-1相反。
 * 注：即使她有剩余的钱，她也不会买一个以上的键盘和一个USB。
 * 输入格式
 * 第一行包含三个空间分隔的整数，分别描述(莫妮卡拥有的钱)(键盘品牌数量)和(usb驱动品牌的数量)。
 * 第二行包含空间分隔的整数，表示每个键盘品牌的价格.
 * 第三行包含空间分隔的整数表示每个usb驱动器品牌的价格.
 * 输出格式
 * 打印一个整数，表示莫妮卡要花多少钱。如果她没有足够的钱买一个键盘和一个usb驱动器，打印-1相反。
 */
public class SolutionTwo {
    static int getMoneySpent(int[] keyboards, int[] drives, int s) {
        // Complete this function
        int money = -1;
        //外层循环从大到小  里层循环从小到大
        MySort.descendingOrderSorting(keyboards);//降序排序
        MySort.positiveOrderSorting(drives);//升序排序
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
