package util;

import java.util.*;

/**
 * Created by 18435 on 2017/11/1.
 */
public class MyString {

    /**
     * �������ַ���ͨ��ɾ���ַ��ķ�ʽ������ת����ͬ��ĸ�����  Ч�ʵͣ�������
     * @param first
     * @param second
     * @return
     */
    public static int convertAnagrams(String first,String second){
        int count = 0;
        Map<Character,Integer> firstMap = MyString.getCharCount(first);
        Map<Character,Integer> secondMap = MyString.getCharCount(second);
        int length = first.length()<second.length() ? first.length() : second.length();
        char[] xhChar = first.length()<second.length() ? first.toCharArray() : second.toCharArray();
        Map<Character,Integer> repeatMap = new TreeMap<>();
        for(int i=0;i<length;i++){
            if(secondMap.get(xhChar[i])!=null && firstMap.get(xhChar[i])!=null){
                if(repeatMap.get(xhChar[i])==null){//��ֹ��ͬ����ĸ�ظ�ͳ��:����������xhChar�ŵ�Set������ȥ��
                    int value = firstMap.get(xhChar[i])<=secondMap.get(xhChar[i]) ? firstMap.get(xhChar[i]) : secondMap.get(xhChar[i]);
                    repeatMap.put(xhChar[i],value);
                    count+=value*2;
                }
            }
        }
        return first.length()+second.length()-count;
    }

    public static int numberNeeded(String first, String second){
        int[] lettercounts = new int[26];//ͳ��ÿ����ĸ��first��second���ִ����Ĳ�ֵ
        int count = 0;
        for(char c : first.toCharArray()){
            lettercounts[c-'a']++;//��ͬ��ĸ��������±�ֵ��ͬ
        }
        for(char c : second.toCharArray()){
            lettercounts[c-'a']--;
        }

        for(int i :lettercounts){
            count+=Math.abs(i);//Math.abs(i) ���i�ľ���ֵ
        }
        return count;
    }
    /**
     * ͳ��һ���ַ����� ÿ���ַ��ظ��Ĵ���
     * @param s
     * @return
     */
    public static Map<Character,Integer> getCharCount(String s){
        Map<Character,Integer> map = new TreeMap<Character,Integer>();
        char[] ss = s.toCharArray();
        for(int i=0;i<ss.length;i++){
            if(map.get(ss[i])==null){
                map.put(ss[i],1);
            }else{
                map.replace(ss[i],map.get(ss[i])+1);
            }
        }
        return map;
    }

    /**
     * ��һ���ַ����ֳ�  ������ �� ż���� ������
     * @param original  ԭʼ�ַ���
     * @return
     */
    public static String getOddAndEvenNumber(String original){
        char[] originalArray = original.toCharArray();
        StringBuffer[] sb = new StringBuffer[]{new StringBuffer(),new StringBuffer()};
        for(int i=0;i<originalArray.length;i++){
            if(i%2==0){
                sb[0].append(originalArray[i]);
            }else{
                sb[1].append(originalArray[i]);
            }
        }
        return sb[0].toString()+" "+sb[1].toString();
    }

    public String reverseString(String original){
        return new StringBuffer(original).reverse().toString();
    }

    public static String reverseTest(String original){
        char[] value = original.toCharArray();
        int n = value.length - 1;
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
            if (Character.isSurrogate(cj) ||
                    Character.isSurrogate(ck)) {
                System.out.println(cj +"-------------------------"+ck);
            }
        }
        return String.valueOf(value);
    }
    public static void main(String[] args){
//        System.out.println(MyString.convertAnagrams("imkhnpqnhlvaxlmrsskbyyrhwfvgteubrelgubvdmrdmesfxkpykprunzpustowmvhupkqsyjxmnptkcilmzcinbzjwvxshubeln","wfnfdassvfugqjfuruwrdumdmvxpbjcxorettxmpcivurcolxmeagsdundjronoehtyaskpwumqmpgzmtdmbvsykxhblxspgnpgfzydukvizbhlwmaajuytrhxeepvmcltjmroibjsdkbqjnqjwmhsfopjvehhiuctgthrxqjaclqnyjwxxfpdueorkvaspdnywupvmy"));
//        System.out.println(MyString.numberNeeded("imkhnpqnhlvaxlmrsskbyyrhwfvgteubrelgubvdmrdmesfxkpykprunzpustowmvhupkqsyjxmnptkcilmzcinbzjwvxshubeln","wfnfdassvfugqjfuruwrdumdmvxpbjcxorettxmpcivurcolxmeagsdundjronoehtyaskpwumqmpgzmtdmbvsykxhblxspgnpgfzydukvizbhlwmaajuytrhxeepvmcltjmroibjsdkbqjnqjwmhsfopjvehhiuctgthrxqjaclqnyjwxxfpdueorkvaspdnywupvmy"));
//          Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        String[] originals = new String[n];
//        for(int i=0;i<n;i++){
//            originals[i] = sc.nextLine();
//        }
//        sc.close();
//        for(int i=0;i<originals.length;i++){
//            System.out.println(MyString.getOddAndEvenNumber(originals[i]));
//        }
        String test = "������������";
        System.out.println(test);
        System.out.println(MyString.reverseTest(test));
    }
}
