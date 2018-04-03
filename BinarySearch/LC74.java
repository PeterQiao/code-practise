import org.junit.Assert;
import org.junit.Test;

/**
 * search in 2D sorted matrix, we have two solutions
 * 1. Use binary search to find row, then find target within row
 * 2. Use one time binary search
 */

public class LC74 {

    public int[] solution(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row, col;
        int left, right, mid;
        left = 0;
        right = rows * cols - 1;

        //convert 2d to 1d
        while (left <= right) {
            mid = left + (right - left) / 2;
            row = mid / cols;
            col = mid % cols;
            if (matrix[row][col] == target) return new int[]{row, col};
            else if (matrix[row][col] < target) left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        int[][] arr = new int[2][2];
        int counter = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = counter;
                counter++;
            }
        }

        int[] result = solution(arr, 2);
        int[] expected = new int[]{1, 0};
        Assert.assertArrayEquals(expected, result);
    }
}