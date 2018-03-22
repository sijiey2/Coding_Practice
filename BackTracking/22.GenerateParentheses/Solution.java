// DFS (Recursion)
// Key words: Generate all combinations
// Idea: for each pos, we can have either ')' or '(' 
//       -can have '(' when there are positions available
//       -can have ')' when there are extra '('

import java.util.List;
import java.util.ArrayList;

public class Solution {
     List<String> result = new ArrayList<String>();

     public List<String> generateParenthesis(int n) {      
        explore("", 0, 0, n);
        return result;
    }
    
    public void explore(String each, int open, int close, int n){
        if(each.length() == n * 2){
            result.add(each);
            return;
        }
        
        if(open < n)
            explore(each + "(", open + 1, close, n);
        if(close < open)
            explore(each + ")", open, close + 1, n);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.generateParenthesis(3);
    }
}
