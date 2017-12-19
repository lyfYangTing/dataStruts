package util;

import java.util.*;

/**
 * Created by 18435 on 2017/10/25.
 */
public class MyTwoArrayOption {


    public static int getMaxHourglass(int[][] array) {
        int max = MyTwoArrayOption.getSum(array, 0, 0);
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = 0; j < array[i].length - 2; j++) {
                int sum = MyTwoArrayOption.getSum(array, i, j);
                max = sum > max ? sum : max;
            }
        }
        return max;
    }

    /**
     * hourglass:
     * 1  1  1
     * 0
     * 1  0  1
     *
     * @param x 左上角元素的横坐标
     * @param y 左上角元素的纵坐标
     * @return 该hourglass的和
     */
    public static int getSum(int[][] array, int x, int y) {
        int sum = array[x+1][y+1];
        for (int i = x; i < x + 3; i++) {
            if (i == x + 1) {//第二行只有一个元素
                continue;
            }
            for (int j = y; j < y + 3; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int arr[][] = new int[6][6];
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                    arr[i][j] = in.nextInt();
//            }
//        }
//        System.out.println("max------->"+MyTwoArrayOption.getMaxHourglass(arr));

        List<Integer> list1 = new LinkedList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        System.out.println("list1--->"+list1.get(0));
        System.out.println("list1--->"+list1.get(1));
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);


    }
}
