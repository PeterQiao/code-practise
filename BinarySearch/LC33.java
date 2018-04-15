/*
Search in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.

思路：无重复元素，在某个位置翻转的数组中查找
因为数组在某个位置翻转了，所以需要判断一下是start-mid 有序还是mid+1-end有序
判断以后，需要用target与nums[mid]进行比较，先在有序数组中判断，这样可以找到下一个循环的起点或者终点
*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        
        int start = 0;
        int end = nums.length - 1;
        int mid = start;
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < nums[start]) {
                if(nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        
        return -1;
    }
}