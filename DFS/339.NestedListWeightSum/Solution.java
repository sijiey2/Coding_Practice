// DFS (Recursion)
// 4ms (1ms)

interface NestedInteger {
	public NestedInteger();
	public NestedInteger(int value);
	public boolean isInteger();
	public Integer getInteger();
	public void setInteger(int value);
	public void add(NestedInteger ni);
	public List<NestedInteger> getList();
}

public class Solution {
	int sum = 0;

	public int depthSum(List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return 0;
		}

		explore(nestedList, 1);
		return sum;
	}

	public void explore(List<NestedInteger> nestedList, int level) {
		if (nestedList.size() == 0) {
			return;
		}

		for (NestedInteger ni: nestedList) {
			if (ni.isInteger()) {
				sum += level * ni.getInteger();
			} else {
				explore(ni.getList(), level + 1);
			}
		}
	}
}
