// DFS (Recursion)
// Key words: Return all possible times
// Idea: separate into hours/mins
//       for each pos, we have choices of 1,2,4,8/1,2,4,8,16,32
// 5ms (2ms) 

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<>();
		int[] nums1 = new int[]{8, 4, 2, 1};
		int[] nums2 = new int[]{32, 16, 8, 4, 2, 1};

		for (int i = 0; i <= num; i++) {
			List<Integer> lst1 = generateDigit(nums1, i); // hours
			List<Integer> lst2 = generateDigit(nums2, num - i); // mins
			
			for (int n1: lst1) {
				if (n1 >= 12) {
					continue;
				}
				for (int n2: lst2) {
					if (n2 >= 60) {
						continue;
					}
					result.add(n1 + ":" + (n2 < 10? "0" + n2: n2));
				}
			}

		}
		return result;
	}

	// separate into hours and mins (result1/result2)
	public List<Integer> generateDigit(int[] nums, int count) {
		List<Integer> result = new ArrayList<>();

		explore(result, 0, nums, count, 0);
		return result;
	}

	// DFS
	public void explore(List<Integer> result, int each, int[] nums, int count, int start) {
		if (count == 0) {
			result.add(each);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			explore(result, each + nums[i], nums, count - 1, i + 1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.readBinaryWatch(1);
		sol.readBinaryWatch(0);
	}
}
