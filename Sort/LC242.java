
/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

思路: 利用数组作为map存储每个字母出现的次数,
首先循环一次s，初始化map，然后循环一次t，将
t.charAt(i) - 'a'作为索引，进行减1操作，如果不匹配，总有某个位置的值
为负数，跳出
*/

public class LC242 {

    public boolean solution(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        int[] m = new int[26];

        for(int i = 0 ; i < s.length(); i++) {
            m[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            m[t.charAt(i) - 'a']--;
            if(m[t.charAt(i) - 'a'] < 0) return false;
        }

        return true;
    }
}