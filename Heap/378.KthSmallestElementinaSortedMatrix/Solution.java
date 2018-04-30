// PriorityQueue

import java.util.PriorityQueue;

class Tuple {
	int x;
	int y;
	int val;
	Tuple(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}

public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(
			(a, b) -> a.val - b.val);

		// add first row
		for (int i = 0; i < n; i++) {
			pq.offer(new Tuple(0, i, matrix[0][i]));
		}

		// get k numbers
		while (k - 1 > 0) {
			Tuple cur = pq.poll();

			k--;
			if (cur.x == n - 1) {
				continue;
			}
			pq.offer(new Tuple(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
		}
		return pq.poll().val;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		System.out.println(sol.kthSmallest(matrix, 8));
	}
}
