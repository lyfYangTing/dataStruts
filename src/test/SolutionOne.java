package test;

import java.util.Scanner;

/**
 * Created by 18435 on 2017/10/27.
 * 计数谷
 * 加里是个热心的徒步旅行者。他仔细地跟踪他的徒步旅行，密切关注像地形这样的小细节。在他上次远足时，他走了n个台阶。他每走一步，都会注意到这是一步是上坡或下坡。加里的远足起点和终点都是海平面。我们定义了以下术语：
 *a.山是连续步骤的非空序列。以上海平面，从一步开始上从海平面到终点下到海平面。(0表示海平面)：则序列  0 1 2 1 0 为山序列
 *b.谷是连续步骤的非空序列。以下海平面，从一步开始下从海平面到终点上到海平面。则例如  序列 0 -1 -2 -1 0 为谷序列
 * 输入格式 :
 * 第一行包含一个整数，表示加里徒步旅行的步数。
 * 第二行包含角色。每个字符在（U,D）中取值(在U指示向上一步和D指示向下一步)，以及字符串中的字符描述了加里的在远足中走的每一步。
 * 约束:
 * 输出格式
 *打印一个整数，表示加里在远足期间走过的山数和谷数。
 */
public class SolutionOne {

    /**
     * 将只含有（U和D）的字符串转换成int数组 U代表up,向上一步   D代表down，向下一步
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
     * 统计目标序列在array数组中的个数 : 在本例中就是在array中统计 {0，-1}子序列的个数
     * @param array   完整序列
     * @param target  子序列  （最笨的办法 待改进）
     * @return
     */
    public static int getSubsequenceCount(int[] array,int[] target){
        int count = 0;
        for(int i=0;i<array.length-target.length;i++){
            boolean isTrue = true;
            for(int j=0;j<target.length;j++){
                if(array[i+j] != target[j]){
                    isTrue = false;//表示没有匹配到
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
        //将 UDDDUDUU 转换成 坐标数组:水平线坐标为0  即 {UDDDUDUU} 可转换成 0,1,[0,-1,]-2,-1,-2,-1,0  1个山谷
        //{DD UU DD U D UUU D} 可转换成 [0,-1,] -2,-1, [0,-1,] -2,-1,-2,-1,0,1,0,   2           2个山谷
        int[] array = SolutionOne.StringToIntArray("UDDDUDUU");
        int[] target = new int[]{0,-1};
        System.out.println(SolutionOne.getSubsequenceCount(array,target));

        Scanner in = new Scanner(System.in);
        
    }
}
