package arrayTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 18435 on 2018/10/30.
 * ��������n+1����������num������ÿ����������1��n֮��(��������)����֤�����ٴ���һ���ظ���������ֻ��һ���ظ��ĺ��룬�ҵ�һ���ظ��ĺ��롣
 * Ҫ��
 * 1.�����޸�����(����������ֻ����)��
 * 2.������ֻʹ�ó�����O(1)����ռ�
 * 3.��������ʱ���Ӷ�Ӧ��С��O(N2)��
 * 4.������ֻ��һ���ظ����֣��������ظ���Ρ�
 */
public class FindDuplicate {
    /**
     * ���ڼ��������(ͼ��)
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(1)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int low = nums[0];
        int fast = nums[nums[0]];
        while (low != fast){//��һ�������ڻ���   �����ڻ����ߵĽ��紦
            low = nums[low];
            fast = nums[nums[fast]];
        }
        // Find the "entrance" to the cycle.  ��һ������֮���ߵĿ�ķ������,�±�Ϊ0
        fast = 0;
        while (low != fast){
            fast = nums[fast];
            low  = nums[low];
        }
        return low;
    }

    /**
     * ������ ����   ����ı������������
     * ʱ�临�Ӷȣ�O(nlogn)  �����ʱ�临�Ӷ�
     * �ռ临�Ӷȣ�O(1)��O(n)    ��������Ƕ��ڴ������������ڴ�ռ���Ǻ㶨�ġ���������޸��������飬�����Ϊnum�ĸ����������Կռ䣬�������������
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
     * ���ü���  ��������ֻʹ�ó�����O(1)����ռ������
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(n)
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
     * ����һ������
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
     * ���������� �Ƚϵ���middle������nums[middle]
     * @param nums
     * @return
     */
    public int findDuplicateFour(int[] nums){
        int low = 1;//���ֵķ�Χ����
        int high = nums.length - 1;//���ֵķ�Χ����
        while (low<high){
            int middle = low + (high - low)/2;
            int count = 0;
            for(int num:nums){
                if(num <= middle){
                    count++;
                }
            }
            if(count<=middle){//˵���ظ�ֵ��3��
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
