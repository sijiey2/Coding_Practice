// DFS (Recursion)
// Key words: Return all possible subsets
// Idea: for each pos, try a num (no duplicates)
//      duplicates: set start
// 4ms (2ms) 

import java.util.List;
import java.util.ArrayList;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }

        explore(new ArrayList<Integer>(), nums, 0);
        // print result
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();

        return result;
    }
    
    public void explore(List<Integer> each, int[] nums, int start) {
        result.add(new ArrayList<Integer>(each));
        for (int i = start; i < nums.length; i++) {
            each.add(nums[i]);
            explore(each, nums, i+1);
            each.remove(each.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3,4,5};
        sol.subsets(nums);
    }
}
