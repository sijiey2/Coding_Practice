// PriorityQueue
// 127ms (17ms)

import java.util.PriorityQueue;

class Num {
    int val;
    int pos;
    int prime;
    Num (int val, int pos, int prime) {
        this.val = val;
        this.pos = pos;
        this.prime = prime;
    }
}

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] result = new int[n];
        PriorityQueue<Num> pq = new PriorityQueue<>(
            (a, b) -> (a.val - b.val));

        for (int i = 0; i < primes.length; i++) {
            pq.offer(new Num(primes[i], 1, primes[i]));
        }
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = pq.peek().val;
            while (pq.peek().val == result[i]) {
                Num next = pq.poll();
                pq.add(new Num(next.prime * result[next.pos], next.pos + 1, next.prime));
            }
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] primes = {2,7,13,19};
        System.out.println(sol.nthSuperUglyNumberHeap(4, primes));
    } 
}
