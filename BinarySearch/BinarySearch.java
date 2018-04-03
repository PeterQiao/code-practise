
/**
We can implement binary search with two formats with different entry condition and mid calculation
here are two
*/

public class BinarySearch {

    public int binarySearch(int[] arr, int target) {

        if(arr == null || arr.length == 0) return -1;
        int start, end, mid;
        start = 0;
        end = arr.length - 1;

        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid;
            else end = mid;
        }

        if(arr[start] == target) return start;
        if(arr[end] == target) return end;
        return -1;
    }

    public int binarySearch1(int[] arr, int target) {

        if(arr == null || arr.length == 0) return -1;
        int start, end, mid;
        start = 0;
        end = arr.length - 1;

        while(start <= end) {
            mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
}