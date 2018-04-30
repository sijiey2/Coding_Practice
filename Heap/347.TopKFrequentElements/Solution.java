// HashMap & PriorityQueue
// 94ms (4ms)


import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
			(a, b) -> b.getValue() - a.getValue());
		List<Integer> result = new ArrayList<>();

		// create map
		for (int n: nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		// create pq
		pq.addAll(map.entrySet());

		// get result
		while (!pq.isEmpty()) {
			if (result.size() == k) {
				break;
			}
			result.add(pq.poll().getKey());
		}

		// print result
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
		}
		System.out.println();
		return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {1,1,1,2,2,3};
		sol.topKFrequent(nums, 2);
	}
}
