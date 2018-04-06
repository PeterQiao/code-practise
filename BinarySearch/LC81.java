/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). 数组中的元素可能重复
在一个不连续的排好序的数组中查找target
需要对arr[mid]和arr[start]的关系进行判断：
[2,1,3] arr[mid] < arr[start] 说明 右侧有序
[1,3,2] arr[mid] > arr[start] 说明 左侧有序
*/

public class LC81 {

  public int solution(int[] arr, int target) {
    
    public boolean search(int[] arr, int target) {
    if (arr == null)
      return false;
    if (arr.length == 1 && arr[0] != target)
      return false;

    int start = 0;
    int end = arr.length - 1;
    int mid;

    while (start <= end) {
      mid = start + (end - start) / 2;
      if (arr[mid] == target)
        return true;
      if (arr[mid] < arr[start]) {
        if (arr[mid] <= target && target <= arr[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      } else if (arr[mid] > arr[start]) {
        if (arr[start] <= target && target <= arr[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        start++;
      }
    }
    return false;
  }
}