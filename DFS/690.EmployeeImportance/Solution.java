// DFS (Recursion)
// 12ms (10ms)

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Employee {
	int id;
	int importance;
	List<Integer> subordinates;
	Employee(int id, int importance, List<Integer> subordinates) {
		this.id = id;
		this.importance = importance;
		this.subordinates = subordinates;
	}
}

public class Solution {
	int result = 0;
	Map<Integer, Employee> map = new HashMap<>();

	public int getImportance(List<Employee> employees, int id) {
		// create map
		for (Employee e: employees) {
			map.put(e.id, e);
		}
		explore(id);
		return result;
	}

	public void explore(int id) {
		Employee cur = map.get(id);

		result += cur.importance;
		for (int sub: cur.subordinates) {
			explore(sub);
		}
		return;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		List<Employee> employees = new ArrayList<>();
		Employee e1 = new Employee(1,5,new ArrayList<Integer>(Arrays.asList(2,3)));
		Employee e2 = new Employee(2,3,new ArrayList<Integer>());
		Employee e3 = new Employee(3,3,new ArrayList<Integer>());
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		System.out.println(sol.getImportance(employees, 1));
	}
}
