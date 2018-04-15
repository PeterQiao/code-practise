/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
思路：
可以继续用start<=end进行判断， 但是由于在pivot反转了，需要进一步判断，

1. nums[mid] < nums[end], 说明最小值不会在(MID,END]里面，可以舍掉，但是由于数字可能重复，所以需要判断nums[mid]与nums[start]的关系
2. nums[mid] > nums[end], 说明最小值不在[start, mid]里面，于是start = mid+1
3. 如果nums[mid] == nums[end], 无法判断，所以end--

*/

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        if(nums.length == 1) return nums[0];

        int start = 0, end = nums.length - 1;
        int mid = start;

        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] < nums[end]) {
                if(nums[mid] < nums[start]) {
                    end = mid;
                } else {
                    end = mid - 1;
                }
            } else if(nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }

        return nums[start] < nums[mid] ? nums[start] : nums[mid];
    }
}