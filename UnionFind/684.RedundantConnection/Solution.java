// Union-Find (HashMap)
// 16ms (4ms)

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
	public int[] findRedundantConnection(int[][] edges) {
		int[] result = new int[2];
		if (edges == null || edges.length == 0) {
			return result;
		}
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i < edges.length + 1; i++) {
			map.put(i, i);
		}

		for (int[] edge: edges) { 
			if (find(edge[0], map) == find(edge[1], map)) {
				result[0] = edge[0];
				result[1] = edge[1];
				
				return result;
			}
			map.put(find(edge[0], map), find(edge[1], map));
		}
		return result;
	}

	public int find(int num, Map<Integer, Integer> map) {
		if (map.get(num) == num) {
			return num;
		}
		return find(map.get(num), map);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] edges = {{1,2},{1,3},{2,3}};
		int[] result = sol.findRedundantConnection(edges);
		System.out.println(Arrays.toString(result));
	}
}
