package myString;

/**
 * Created by 18435 on 2017/10/12.
 * ����ģʽƥ���㷨:
 * �����㷨:��������ÿһ���ַ���Ϊ�Ӵ���ͷ����Ҫƥ����ַ�������ƥ��
 * KMPģʽƥ���㷨:
 */
public class MyTestOne {

    /**
     * �����Ӵ�t������s�е�pos���ַ�֮���λ�á��������ڣ���������ֵΪ-1
     * @param s
     * @param t
     * @param pos
     * @return
     */
    public static int index(String s,String t,int pos){
        int index = -1;
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for(int i = pos>0 ? pos :0;i<ss.length;i++){//�����ַ�����
            System.out.println("i======"+i);
            index = i;
            for(int j=0;j<ts.length;j++){//�Ӵ��ַ�����
                System.out.println(i+"-------"+ss[i]);
                System.out.println(j+"-------"+ts[j]);
                if(ss[i]==ts[j]){//�����λ��ƥ����ͬ����������±Ƚ�
                    System.out.println(i+"=========="+j);
                    i++;
                    //j++;
                }else{//ƥ��ʧ�ܣ����˳��˴�ƥ�䣬�����´�ƥ�䣬���������±���˵�����ƥ����λ
                    System.out.println(i+"=========="+j);
                    i = i - j;//����
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
