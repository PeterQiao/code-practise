/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
主要是考虑进位的问题，扩展问题，两个数组相加，bigint的设计
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            //进位
            digits[i] = 0;
        }
        int[] ret = new int[digits.length + 1];
        for(int i = 1; i < digits.length; i++) {
            ret[i] = digits[i];
        }
        ret[0] = 1;
        return ret;
    }
}