// Union-Find (Hashmap, TreeSet)
// 1. Build find func.
// 2. Create & Update Map
// 3. Union
// 181ms (53ms)

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> parents = new HashMap<>();
		Map<String, String> owners = new HashMap<>();
		Map<String, TreeSet<String>> union = new HashMap<>();
		List<List<String>> result = new ArrayList<>();

		// create Map
		for (List<String> account: accounts) {
			String name = account.get(0);

			for (int i = 1; i < account.size(); i++) {
				owners.put(account.get(i), name);
				parents.put(account.get(i), account.get(i));
			}
		}

		// update Map
		for (List<String> account: accounts) {
			String parent = find(account.get(1), parents);

			for (int i = 1; i < account.size(); i++) {
				parents.put(find(account.get(i), parents), parent);
			}
		}

		// union
		for (List<String> account: accounts) {
			for (int i = 1; i < account.size(); i++) {
				String parent = find(account.get(i), parents);

				if (!union.containsKey(parent)) {
					union.put(parent, new TreeSet<String>());
				}
				union.get(parent).add(account.get(i));
			}
		}

		// get result
		for (String p: union.keySet()) {
			List<String> info = new ArrayList(union.get(p));

			info.add(0, owners.get(p));
			result.add(info);
		}
		return result;
	}

	// find
	public String find(String str, Map<String, String> map) {
		if (map.get(str).equals(str)) {
			return str;
		}
		return find(map.get(str), map);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
	}
}
