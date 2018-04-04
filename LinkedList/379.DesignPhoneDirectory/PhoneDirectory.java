// HashSet (visited), Queue (available)
// 109ms (100ms)

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class PhoneDirectory {
	Set<Integer> visited = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    int max;
    
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        for (int i = 0; i < maxNumbers; i++) {
            q.offer(i);
        }
    }
 	
 	public int get() {
        Integer n = q.poll();
        if (n == null) {
            return -1;
        }
        visited.add(n);
        return n;
    }
    
    public boolean check(int number) {
        if (number < 0 || number >= max || visited.contains(number)) {
            return false;
        }
        return true;
    }
    
    public void release(int number) {
        if (visited.remove(number)) {
            q.offer(number);
        }
    }

	public static void main(String[] args) {
		PhoneDirectory directory = new PhoneDirectory(3);
		int num = directory.get();
		System.out.println(num);
		boolean check = directory.check(num);
		System.out.println(check);
		directory.release(num);
		check = directory.check(num);
		System.out.println(check);
	}
}
