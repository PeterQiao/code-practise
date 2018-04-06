/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
入口条件： 无需判断start == end, 相邻退出。
解法：双指针循环, 利用减法防止溢出
*/
public class LC167 {

    public int[] solution(int[] arr, int target) {
        int[] ret = new int[2];
        
        if(arr == null) return ret;

        int start = 0;
        int end = arr.length - 1;
        int temp;

        while(start < end) {
            temp = target - arr[start];
            if( temp == arr[end]) {
                ret[0] = start + 1;
                ret[1] = end + 1;
                return ret;
            } else if(temp < arr[end]) {
                end--;
            } else {
                start++;
            }
        }
        return ret;
    }
}