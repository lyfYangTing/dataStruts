package arrayTest;

import java.util.Arrays;

/**
 * Created by 18435 on 2018/11/2.
 * ���ֲ�����   1 <= k <= n*n
 * ����һ�� n x n ��������ÿ�к�ÿ��Ԫ�ؾ������������ҵ������е�kС��Ԫ�ء�
 * ��ע�⣬���������ĵ�kСԪ�أ������ǵ�k��Ԫ�ء�
 * ʾ��:
 * matrix = [[ 1,  5,  9],[10, 11, 13],[12, 13, 15]],
 * k = 8,
 * ���� 13��
 */
public class SortedMatrix {

    /**
     * �Ҿ����е�KСԪ��
     * ���������������λ�������������ȡ��K��ֵ
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int[] newArray = new int[matrix.length*matrix.length];
        int i = 0;
        for(int row = 0;row<matrix.length;row++){
            for(int col = 0;col<matrix[row].length;col++){
                newArray[i++] = matrix[row][col];
            }
        }
        Arrays.sort(newArray);
        return newArray[k-1];
    }

    /**
     * �Ҿ����е�KСԪ��
     * ���ö��ַ����
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallestByDichotomy(int[][] matrix, int k){
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low < high){
            int middle = low + (high - low)/2;
            int count = getCount(matrix,middle);
            if(count < k){
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    /**
     * ͳ��������С��middle��Ԫ�ظ���
     * @param matrix
     * @param middle
     * @return
     */
    public int getCount(int[][] matrix,int middle){
        int count = 0;
        for (int row =matrix.length -1;row>=0;row--){
            for(int col = matrix.length-1;col>=0;col--){
                if(matrix[row][col] <= middle){
                    count = count + col + 1;
                    break;//�����ڲ�ѭ��
                }
            }
        }
        return count;
    }

    /**
     * ͳ��������С��middle��Ԫ�ظ��� (ͨ��whileѭ��ʵ��)
     * @param matrix
     * @param middle
     * @return
     */
    public int getCountByWhile(int[][] matrix,int middle){
        int row = 0;
        int col = matrix.length - 1;
        int count = 0;
        while(row < matrix.length && col>=0){
            if(matrix[row][col] <= middle){
                count += row + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }
}
