import junit.framework.Assert;
import org.junit.Test;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * IDEA: 30 / 3 = 10 => 1*2^3 + 1*2^2 + 0*2^1 + 0*1
 */
public class LC29 {

    public int solution(int dividend, int divisor) {

        final int INT_MAX = Integer.MAX_VALUE;
        final int INT_MIN = Integer.MIN_VALUE;
        if(divisor == 0 || dividend == INT_MAX + 1 && divisor == -1 || dividend == INT_MIN && divisor == -1)
            return INT_MAX;

        int sign = (dividend>0 && divisor>0) || (dividend<0 && divisor<0)  ? 1 : -1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        long tmp, bit;
        int res = 0;

        while(dvd >= dvs) {
            tmp = dvs;
            bit = 1;
            while(dvd >= (tmp << 1)) {
                tmp <<= 1;
                bit <<= 1;
            }
            res += bit;
            dvd -= tmp;
        }
        return sign == 1 ? res : -res;
    }

    @Test
    public void test() {
        int a = solution(-2147483648, 1);
        Assert.assertEquals(-2147483648, a);
    }
}
