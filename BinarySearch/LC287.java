/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. 
Assume that there is only one duplicate number, find the duplicate one. 
思路：先解释一下题目，题目要求的是在一个n+1长度的数组中，有n-1个不重复的数，数字从1~n，1个数字重复了，找到那个重复的数。
不能改变数组，所以不能swap，不能排序
空间复杂度为O(1)，不能用set
二分搜索，先取出1-n中的中位数，循环nums数组，与中位数进行比较，如果小于等于中位数的数字的个数比mid小或者相等，那么说明重复的数字在[mid+1, end]里面，
反之在[1,mid-1]里面。这里可以比较mid与小于等于mid的数字的原因在于，数组中的数字是1-n并且不重复。
*/

public class LC287 {
 public int findDuplicate(int[] nums) {

        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;

        int start = 0, end = nums.length - 1, mid = start;
        int i = 0, count = 0;
        while(start <= end) {
            count = 0;
            mid = start + (end - start) / 2;
            for(i = 0; i < nums.length; i++) {
                if(nums[i] <= mid) count++;
            }
            if(count <= mid) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}