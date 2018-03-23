// DFS (Recursion)
// Key words: return all possible unique permutations
// Idea: for each pos, try each num (no duplicates)
//       duplicates: boolean[] visited
// Attention: sort the array
// 9ms (6ms)

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {    
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> temp = new ArrayList<Integer>();

        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums); // attention
        explore(nums, temp, visited);
        return result;
    }

    public void explore(int[] nums, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<Integer>(temp));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue; // key
            }
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue; // key
            }
            temp.add(nums[i]);
            visited[i] = true;
            explore(nums, temp, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,1,2};
        sol.permuteUnique(nums);
    }
}
