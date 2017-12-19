package diGui;

import util.MyMath;

/**
 * Created by 18435 on 2017/10/20.
 * ���ֲ��ң�
 * �����ٵıȽϴ�����һ��������������ҵ�������һ�������
 * ��������м�ֳ����룬Ȼ����ҵ����������������һ�룬�ٴε��۰룬���������ȥ��
 */
public class BinarySearch {
    private static int[] datas;
    private static void getSequenceDatas(int[] originalDatas) {//��ԭʼ����ת�������������
        for (int i = 0; i < originalDatas.length; i++) {
            for (int j = i; j < originalDatas.length; j++) {
                if (originalDatas[i] > originalDatas[j]) {//����С�����˳��
                    int data = originalDatas[i];
                    originalDatas[i] = originalDatas[j];
                    originalDatas[j] = data;

                }
            }
        }
        datas = originalDatas;
    }

    /**
     * @param startNumber  ���ҷ�Χ   startNumber ----  endNumber
     * @param endNumber
     * @param targetNumber Ҫ���ҵ�����
     * @return
     */
    public static void getHalfNumber(int startNumber, int endNumber, int targetNumber) {
        int count = 1;
        if (startNumber >= 0 && endNumber < datas.length) {
            int guessIndex = (startNumber + endNumber) / 2;//���ܻᷢ�����
            int guessNumber = datas[guessIndex];
            int high = (int) MyMath.getLog(datas.length, 2);
            while (guessNumber != targetNumber) {//Ч�ʵ�
                if (guessNumber > targetNumber) {
                    endNumber = guessIndex - 1;
                } else {
                    startNumber = guessIndex + 1;
                }
                guessIndex = (startNumber + endNumber) / 2;// 3/2=1(ȥβ)
                guessNumber = datas[guessIndex];
                count++;
                if (count == (high + 1) && guessNumber != targetNumber) {//���������������
                    System.out.println("������û����Ҫ���ҵ�����");
                    return;
                }
            }
            System.out.println("��ϲ�㣬�ҵ�����Ҫ�����֣���������ĵ�" + guessIndex + "��λ��");
        }
    }

    /**
     * ����ѭ��ʵ���Ѿ��Ż��Ķ��ֲ����㷨ʵ��
     * ������datas[low]-datas[high] �в���goal
     * ͨ�����ϸı�low��high��ֵ����ȷ���µĲ��ҷ�Χ
     * ÿѭ��һ�Σ��ͰѲ��ҵķ�Χ��ֱ�ӣ��۰�
     * @param len  ���鳤��
     * @param goal
     * @return
     */
    public static int binary_search(int len, int goal) {
        int low = 0;
        int high = len <= datas.length ? len - 1 : datas.length - 1;
        while (low <= high) {
            int middle = (high - low) / 2 + low;//�ڴ˴���(high+low)/2 ����datas[0]���������
            if (datas[middle] == goal) {
                return middle;
            } else if (datas[middle] > goal) {
                high = middle - 1;//�ҵ�datas[middle]���������ұ߽�(��߽�Ϊ0)  high��һֱ������
            } else {
                low = middle + 1;//�ҵ�datas[middle]�ұ��������߽�(�ұ߽�Ϊdatas.length-1) low��һֱ������
            }
        }
        return -1;//û���ҵ�
    }

    /**
     * ���õݹ�ʵ�ֶ��ֲ��ҷ�
     * ���øı�low��high��ֵ��
     * ����low��high����ֵ��Ϊ������������binarySearchDiGui������
     * @param low
     * @param high
     * @param goal
     */
    public static int binarySearchDiGui(int low,int high,int goal){
        int middle = (high-low)/2 + low;
        if(low<=high){
            if(datas[middle]==goal){
                return middle;
            }else if(datas[middle]>goal){
                return binarySearchDiGui(0,middle-1,goal);
            }else{
                return binarySearchDiGui(middle+1,high,goal);
            }
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] datas = new int[]{12, 1, 4, 6, 8, 2, 9, 17, 7, 22};
        BinarySearch.getSequenceDatas(datas);
        for (int i = 0; i < datas.length; i++) {
            System.out.print(datas[i] + ",");
        }
        BinarySearch.getHalfNumber(0, 9, 12);
        int index = BinarySearch.binary_search(10, 12);
        if (index == -1) {
            System.out.println("û���ҵ�Ҫ���ҵ�����");
        } else {
            System.out.println("��Ҫ���ҵ�����������ĵ�" + index + "��λ��");
        }

        int indexOne = BinarySearch.binarySearchDiGui(0,9,12);
        if (indexOne == -1) {
            System.out.println("û���ҵ�Ҫ���ҵ�����");
        } else {
            System.out.println("��Ҫ���ҵ�����������ĵ�" + index + "��λ��");
        }
        //System.out.println((int)MyMath.getLog(17,2));
    }
}
