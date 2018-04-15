/*
Pow(x, n)
思路：不能用暴力直接乘，会超时。
x的n次方可以转换为x的n/2次方相乘，所以可以用折半的思想来做。
需要判断n的奇偶性
*/
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n < 0) return 1/ power(x, -n);
        return power(x, n);
    }
    
    private double power(double x , int n ) {
        if(n == 0) return 1;
        double half = power(x , n/2);
        if(n%2 == 0) return half*half;
        return x * half * half;
    }
}