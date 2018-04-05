
/*
思想： 将剩下未排序的最小值，交换到合适的位置， 双指针实现，i从左向右扫描指向当前的位置，j从i+1开始向后扫，扫到最小值，将i与minIndex的位置互换
i<arr.length - 1 => i不需要扫描到最后
j<arr.length => j一直在i的肩部(+1的位置)，需要扫描到最后
*/
public class SelectionSort {

  public int[] sort(int[] arr) {
    if (arr == null || arr.length <= 1)
      return arr;

    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex])
          minIndex = j;
      }
      swap(arr, i, minIndex);
    }
    return arr;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  @Test
  public void test() {
    int[] a = {5,4,3,2,1};
    int[] expected = {1,2,3,4,5};
    Assert.assertArrayEquals(expected, sort(a));
  }
}