package arrayTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 18435 on 2018/10/30.
 * 给定包含n+1整数的数组num，其中每个整数介于1和n之间(包括在内)，则证明至少存在一个重复数。假设只有一个重复的号码，找到一个重复的号码。
 * 要求：
 * 1.不能修改数组(假设数组是只读的)。
 * 2.您必须只使用常量，O(1)额外空间
 * 3.您的运行时复杂度应该小于O(N2)。
 * 4.数组中只有一个重复数字，但可以重复多次。
 */
public class FindDuplicate {
    /**
     * 周期检测解决方案(图论)
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int low = nums[0];
        int fast = nums[nums[0]];
        while (low != fast){//第一次相遇在环上   不是在环和线的交界处
            low = nums[low];
            fast = nums[nums[fast]];
        }
        // Find the "entrance" to the cycle.  第一次相遇之后，走的快的返回起点,下标为0
        fast = 0;
        while (low != fast){
            fast = nums[fast];
            low  = nums[low];
        }
        return low;
    }

    /**
     * 先排序 再找   排序改变了数组的内容
     * 时间复杂度：O(nlogn)  排序的时间复杂度
     * 空间复杂度：O(1)或O(n)    在这里，我们对内存进行排序，因此内存占用是恒定的。如果不能修改输入数组，则必须为num的副本分配线性空间，并对其进行排序。
     * @param nums
     * @return
     */
    public int findDuplicateOne(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }


    /**
     * 利用集合  不能满足只使用常量，O(1)额外空间的条件
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int findDuplicateTwo(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    /**
     * 利用一个变量
     *
     * @param nums
     * @return
     */
    public int findDuplicateThree(int[] nums){
        int numberIndex = 0;
        while(true){
            for(int start=numberIndex+1;start<nums.length;start++){
                if(nums[numberIndex]==nums[start]){
                    return nums[numberIndex];
                }
            }
            numberIndex++;
        }
    }

    /**
     * 二分搜索法 比较的是middle而不是nums[middle]
     * @param nums
     * @return
     */
    public int findDuplicateFour(int[] nums){
        int low = 1;//数字的范围下限
        int high = nums.length - 1;//数字的范围上限
        while (low<high){
            int middle = low + (high - low)/2;
            int count = 0;
            for(int num:nums){
                if(num <= middle){
                    count++;
                }
            }
            if(count<=middle){//说明重复值比3大
                low = middle + 1;
            }else {
                high = middle - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        int[] a = new int[]{1,2,4,4,3,5,4};
        System.out.println(findDuplicate.findDuplicate(a));
    }
}
