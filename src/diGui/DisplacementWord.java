package diGui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 18435 on 2017/10/20.
 * ��λ�֣�
 * ���ǰ�һ����ĸ�����ֲ�ֳɸ��ָ�������ϣ�
 * �磺abc ����:abc �� acb �� bca �� bac �� cba �� cab 6�֣�����Ǳ�λ�֡�
 */
public class DisplacementWord {
    private static char[] words;
    private static int count = 0;

    /**
     * ��λ�ķ���
     * 1.ȫ�������ұߵ�n-1����ĸ
     * 2.�ֻ�����n����ĸ(�ֻ���������ĸ������һλ��������ߵ���ĸ���⣬��ת�������ұ���ĸ�ĺ���)
     * 3.�ظ����ϲ���n��
     *
     * @param newSize ��ĸ����
     */
    public static void doAnagram(int newSize) {//��Ҫ����
        if (newSize == 1) {
            return;//�����ݹ���� ����Ҫ�ٵ�������Ԫ�ص�λ��
        }
        for (int i = 0; i < newSize; i++) {//Ҫ�ֻ�����n����ĸ  ����Ҫ��rotate����ִ��n��
            //�ݹ���Ҫ���Ĺ�������ʾ   ת��
            doAnagram(newSize - 1);
            // displayWord(); û���������ƵĻ���������ظ������
            if (newSize == 2) {//��Ϊ��ֻ�����Ч�ģ������Ķ����ظ��ģ�
                count++;
                displayWord();//��newSize=2ʱ������ȷ��
            }
            rotate(newSize);
        }
    }

    /**
     * ת���ķ�����������ĸ������һλ��������ߵ���ĸ���⣬��ת�������ұ���ĸ�ĺ���
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
     * ��ʾ
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
        //�Ӽ����ж�ȡ�ַ�
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("���û�����һ������");
        String input = DisplacementWord.getString();
        DisplacementWord.words = input.toCharArray();
        doAnagram(DisplacementWord.words.length);
    }
}
