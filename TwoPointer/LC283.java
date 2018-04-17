/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
思路： 题意是将0挪动到最后，所以需要两个指针，一个指到0，一个指这个0以后的第一个非0的地方，然后进行交换
*/

public class solution {
  public void movezero(int[] nums) {
    if (nums == null || nums.length <= 1) return;

    int zero = 0, non-zero = 0;
    while(zero < nums.length && non-zero < nums.length) {
      //找到一个0
      if(nums[zero] != 0) {
        zero++;
        non-zero = zero;
        continue;
      }
      //找0之后第一个非0
      if(nums[non-zero] == 0) {
        non-zero++;
        continue;
      }

      int temp = nums[zero];
      nums[non-zero] = nums[zero];
      nums[zero] = temp;

      //++
      zero++;
      non-zero++;
    }
  }
}