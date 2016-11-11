package studaout.string;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LonestSubstringWithoutRepeating {

    public static int find(String str) {
        int l = 0;
        int i = 0;
        int s = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        while (i < str.length() ) {
            char c = str.charAt(i);
            if ( h.containsKey(c) ) {
                if ( i-s > l ) l = i-s;
                s = h.get(c) + 1;
            }
            h.put(c, i);
            i+=1;
        }
        if ( i-s > l ) l = i-s;
        return l;
    }

    public static void main(String[] args) {
        System.out.println(find("abcabcbb"));
        System.out.println(find("bbbbbb"));
        System.out.println(find("pwwkewr"));
    }
}
