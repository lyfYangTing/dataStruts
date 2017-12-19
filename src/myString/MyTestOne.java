package myString;

/**
 * Created by 18435 on 2017/10/12.
 * 串的模式匹配算法:
 * 朴素算法:对主串的每一个字符作为子串开头，与要匹配的字符串进行匹配
 * KMP模式匹配算法:
 */
public class MyTestOne {

    /**
     * 返回子串t在主串s中第pos个字符之后的位置。若不存在，则函数返回值为-1
     * @param s
     * @param t
     * @param pos
     * @return
     */
    public static int index(String s,String t,int pos){
        int index = -1;
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for(int i = pos>0 ? pos :0;i<ss.length;i++){//主串字符数组
            System.out.println("i======"+i);
            index = i;
            for(int j=0;j<ts.length;j++){//子串字符数组
                System.out.println(i+"-------"+ss[i]);
                System.out.println(j+"-------"+ts[j]);
                if(ss[i]==ts[j]){//如果该位置匹配相同，则继续向下比较
                    System.out.println(i+"=========="+j);
                    i++;
                    //j++;
                }else{//匹配失败，则退出此次匹配，进行下次匹配，将主串的下标回退到本次匹配首位
                    System.out.println(i+"=========="+j);
                    i = i - j;//回溯
                    index = -1;
                    break;
                }
            }
            if(index!=-1){
                break;
            }
        }
        return index;
    }

    public static void main(String[] args){
        String s = "googlegood";
        String t = "googleo";
        int index = MyTestOne.index(s,t,0);
        System.out.println("------------->"+index);
    }
}
