package arrayTest;

import java.util.Arrays;

/**
 * Created by 18435 on 2018/11/2.
 * 二分查找类   1 <= k <= n*n
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 * 示例:
 * matrix = [[ 1,  5,  9],[10, 11, 13],[12, 13, 15]],
 * k = 8,
 * 返回 13。
 */
public class SortedMatrix {

    /**
     * 找矩阵中第K小元素
     * 暴力解决法：将二位数组遍历出来，取第K个值
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
     * 找矩阵中第K小元素
     * 利用二分法解决
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
     * 统计数组中小于middle的元素个数
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
                    break;//跳出内层循环
                }
            }
        }
        return count;
    }

    /**
     * 统计数组中小于middle的元素个数 (通过while循环实现)
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
