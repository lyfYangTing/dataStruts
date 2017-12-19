package test;

import java.util.Scanner;

/**
 * Created by 18435 on 2017/9/28.
 */
public class Text {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //String s = sc.next();
//        int s = sc.nextInt();
//        double s1 = sc.nextDouble();
        String[] ss = new String[3];
        for(int i=0;i<3;i++){
            ss[i] = sc.nextLine();
        }
        int i = Integer.parseInt(ss[0]);
        double j = Double.parseDouble(ss[1]);
        System.out.println(i);
        System.out.println(j);
        System.out.println(ss[2]);
        sc.close();

    }
}
