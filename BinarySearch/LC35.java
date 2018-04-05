import org.junit.Assert;
import org.junit.Test;

/**
 * 这道题用跨过的判断比较好，相邻需要判断左右指针的情况，比较复杂：
 * if (nums[start] >= target) {
 *           return start;
 *       } else if (nums[end] >= target) {
 *           return end;
 *       } else {
 *           return end + 1;
 *       }
 * 如果用start <= end 跨过的方式，总是返回start, 因为结束的时候，start总是指向大于等于target的最小的元素的位置
 */
public class LC35 {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int start, end, mid;
        start = 0;
        end = nums.length - 1;

        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(start + " " + end);
        return start;

    }

    @Test
    public void test() {
        int[] a = {1,3,5,7};
        Assert.assertEquals(1, searchInsert(a, 2));
    }
}
