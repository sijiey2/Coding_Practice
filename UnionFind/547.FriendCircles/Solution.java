// Union-Find (HashMap & HashSet)
// create find func
// create & update map
// union
// 25ms (9ms)

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Solution {
	public int findCircleNum(int[][] M) {
		if (M == null || M.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> union = new HashSet<>();

		// create map
		for (int i = 0; i < M.length; i++) {
			map.put(i, i);
		}

		// update map
		for (int i = 0; i < M.length; i++) {
			int parent = find(i, map);

			for (int j = 0; j < M.length; j++) {
				if (M[i][j] == 1) {
					map.put(find(j, map), parent);
				}
			}
		}

		// union
		for (int i = 0; i < M.length; i++) {
			int parent = find(i, map);

			union.add(parent);
		}
		return union.size();
	}

	public int find(int num, Map<Integer, Integer> map) {
		if (map.get(num) == num) {
			return num;
		}
		return find(map.get(num), map);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(sol.findCircleNum(M));
	}
}
