package myTree;

/**
 * Created by 18435 on 2017/10/17.
 * 折半查找
 */
public class HalfSearch {

    /**
     * @param startNumber  查找范围   startNumber ----  endNumber
     * @param endNumber
     * @param targetNumber 查找的数字
     * @return
     */
    public static void getHalfNumber(int startNumber, int endNumber, int targetNumber) {
        int count = 1;
        int guessNumber = (startNumber + endNumber) / 2; //第一次猜测的数字
        while (guessNumber != targetNumber) {
            if (guessNumber > targetNumber) {
                endNumber = guessNumber;
            } else {
                startNumber = guessNumber;
            }
            guessNumber = (startNumber + endNumber) / 2; // 3/2=1(去尾)
            count++;
            System.out.println("guessNumber--------->" + guessNumber);
            System.out.println("startNumber--------->" + startNumber);
            System.out.println("endNumber--------->" + endNumber);
            System.out.println("-------------------------------------------------");
        }
        System.out.println("恭喜你，猜了" + count + "次，终于猜对了");
    }


    public static void main(String[] args) {
       // HalfSearch.getHalfNumber(0,100,39);
        char exp = '+';
        System.out.println(1+exp+1);
    }
}
