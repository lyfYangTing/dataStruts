package myTree;

/**
 * Created by 18435 on 2017/10/17.
 * �۰����
 */
public class HalfSearch {

    /**
     * @param startNumber  ���ҷ�Χ   startNumber ----  endNumber
     * @param endNumber
     * @param targetNumber ���ҵ�����
     * @return
     */
    public static void getHalfNumber(int startNumber, int endNumber, int targetNumber) {
        int count = 1;
        int guessNumber = (startNumber + endNumber) / 2; //��һ�β²������
        while (guessNumber != targetNumber) {
            if (guessNumber > targetNumber) {
                endNumber = guessNumber;
            } else {
                startNumber = guessNumber;
            }
            guessNumber = (startNumber + endNumber) / 2; // 3/2=1(ȥβ)
            count++;
            System.out.println("guessNumber--------->" + guessNumber);
            System.out.println("startNumber--------->" + startNumber);
            System.out.println("endNumber--------->" + endNumber);
            System.out.println("-------------------------------------------------");
        }
        System.out.println("��ϲ�㣬����" + count + "�Σ����ڲ¶���");
    }


    public static void main(String[] args) {
       // HalfSearch.getHalfNumber(0,100,39);
        char exp = '+';
        System.out.println(1+exp+1);
    }
}
