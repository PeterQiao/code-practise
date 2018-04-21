/*
Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

思路：建立一个comparator，比较两个字符串大小，返回相应的顺序，如s1=90,s2=32则应该90在前，所以(s2+s1)[3290].compareTo(s1+s2)[9032] 返回-1， 表示
s1<s2, 则90放到32之前
*/

public class Solution {
    public String largestNumber(int[] nums)  {
        if(nums == null) return "";
        if(nums.length == 0) return Integer.toString(nums[0]);

        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumberComparator());

        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s);
        }

        String ret = sb.toString();
        
        //all 0
        int index = 0;
        while (index < ret.length() && ret.charAt(index) == '0') {
            index++;
        }
        if (index == ret.length()) {
            return "0";
        }
        return ret;
    }
}

class NumberComparator implements Comparator<String> {
@Override
public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
    }
}