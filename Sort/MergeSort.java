import org.junit.Assert;
import org.junit.Test;

public class MergeSort {

    public int[] mergeSort(int[] arr) {

        if(arr == null || arr.length < 2) return arr;

        int[] temp= new int[arr.length];
        divide(arr, 0, arr.length - 1, temp);
        return arr;
    }

    private void divide(int[] arr, int start, int end, int[] temp) {
        if(start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        divide(arr, start, mid, temp);
        divide(arr, mid + 1, end, temp);
        merge(arr, start, mid, end, temp);
    }

    private void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;

        while(left <= mid && right <= end) {
            if(arr[left] < arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while(left <= mid) {
            temp[index++] = arr[left++];
        }

        while(right <= end) {
            temp[index++] = arr[right++];
        }

        for(index = start; index <= end; index++) {
            arr[index] = temp[index];
        }
    }

    @Test
    public void test() {
        int[] a = {4,3,1};
        int[] expected = {1,3,4};
        Assert.assertArrayEquals(expected, mergeSort(a));
    }
}