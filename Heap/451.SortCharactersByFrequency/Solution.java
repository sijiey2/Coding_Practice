// HashMap & PriorityQueue
// 100ms (6ms)

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
	public String frequencySort(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
			(a, b) -> b.getValue() - a.getValue());
		StringBuilder sb = new StringBuilder();

		// create map
		for (char c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// create pq
		pq.addAll(map.entrySet());

		// create sb
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> entry = pq.poll();
			int value = entry.getValue();
			char key = entry.getKey();
			

			while (value > 0) {
				sb.append(key);
				value--;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.frequencySort("cccaaa"));
		System.out.println(sol.frequencySort("Aabb"));
	}
}
