// DFS (Recursion)
// swap method, instead of using int[] visited
// 7ms (2ms)

public class Solution1 {
	int result = 0;

	public int countArrangement(int N) {
		if (N == 0) {
			return 0;
		}
		int[] nums = new int[N + 1];

		// create int[] nums
		for (int i = 0; i <= N; i++) {
			nums[i] = i;
		}
		explore(nums, N);
		return result;
	}

	public void explore(int[] nums, int start) {
		if (start == 0) {
			result++;
			return;
		}

		for (int i = start; i > 0; i--) {
			swap(nums, start, i);
			if (nums[start] % start == 0 || start % nums[start] == 0) {
				explore(nums, start - 1);
			}
			swap(nums, start, i);
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		System.out.println(sol.countArrangement(2));
	}
}
