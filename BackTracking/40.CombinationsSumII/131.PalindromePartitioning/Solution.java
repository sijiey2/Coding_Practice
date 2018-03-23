// DFS (Recursion)
// Key words: Return all possible palindrome partitioning
// Idea: for each pos as the start, try other positions as the end
// 10ms (5ms)

import java.util.List;
import java.util.ArrayList;

public class Solution {
    List<List<String>> result = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> temp = new ArrayList<String>();

        explore(s, temp, 0);
        return result;
        }

    public void explore(String s, List<String> temp, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(temp));
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            
            if (isPalindrome(str)) {
                temp.add(str);
                explore(s, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    } 

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.partition("aab");
    }
    
}
