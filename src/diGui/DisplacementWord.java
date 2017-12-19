package diGui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 18435 on 2017/10/20.
 * 变位字：
 * 就是把一组字母或数字拆分成各种各样的组合，
 * 如：abc 就有:abc 、 acb 、 bca 、 bac 、 cba 、 cab 6种，这就是变位字。
 */
public class DisplacementWord {
    private static char[] words;
    private static int count = 0;

    /**
     * 变位的方法
     * 1.全排列最右边的n-1个字母
     * 2.轮换所有n个字母(轮换：所有字母向左移一位，但最左边的字母例外，它转换至最右边字母的后面)
     * 3.重复以上步聚n次
     *
     * @param newSize 字母个数
     */
    public static void doAnagram(int newSize) {//主要用来
        if (newSize == 1) {
            return;//结束递归调用 不需要再调整数组元素的位置
        }
        for (int i = 0; i < newSize; i++) {//要轮换所有n个字母  就需要将rotate方法执行n次
            //递归需要做的工作：显示   转动
            doAnagram(newSize - 1);
            // displayWord(); 没有条件控制的话，会出现重复的情况
            if (newSize == 2) {//因为就只这个有效的，其他的都是重复的，
                count++;
                displayWord();//当newSize=2时，可以确定
            }
            rotate(newSize);
        }
    }

    /**
     * 转动的方法：所有字母向左移一位，但最左边的字母例外，它转换至最右边字母的后面
     *
     * @param newSize
     */
    public static void rotate(int newSize) {
        int wordSize = words.length;
        int position = wordSize - newSize;
        char temp = words[position];
        for (int i = position; i < wordSize - 1; i++) {
            words[i] = words[i + 1];
        }
        words[wordSize - 1] = temp;
    }

    /**
     * 显示
     */
    public static void displayWord() {
        System.out.print(count + ".");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
        }
        System.out.print("     ");
        if (count % 5 == 0) {
            System.out.println();
        }
    }

    public static String getString() throws IOException {
        //从键盘中读取字符
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("请用户输入一个单词");
        String input = DisplacementWord.getString();
        DisplacementWord.words = input.toCharArray();
        doAnagram(DisplacementWord.words.length);
    }
}
