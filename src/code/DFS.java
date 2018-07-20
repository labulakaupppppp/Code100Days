package code;

import java.util.LinkedList;
import java.util.HashMap;

public class DFS {
	// 用一个静态变量count记录进入节点 与 离开节点的时间
	static int count;

	public static void dfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited,
			char start) {
		// 未访问过才能进行下一步
		if (!visited.containsKey(start)) {
			count++;
			System.out.println("The time into element " + start + ":" + count);
			visited.put(start, true);
			for (Character c : graph.get(start)) {
				if (!visited.containsKey(c)) {
					dfs(graph, visited, c);
				}
			}
			count++;
			System.out.println("the time leave :" + start + ":" + count);
		}

	}

	public static void main(String[] args) {
		//无向图
		HashMap<Character, LinkedList<Character>> graph = new HashMap<>();
		LinkedList<Character> a1 = new LinkedList<>();
		a1.add('2');
		a1.add('3');
		graph.put('1', a1);
		LinkedList<Character> a3 = new LinkedList<>();
		a3.add('5');
		a3.add('1');
		graph.put('3', a3);
		LinkedList<Character> a2 = new LinkedList<>();
		a2.add('1');
		a2.add('4');
		graph.put('2', a2);
		LinkedList<Character> a4 = new LinkedList<>();
		a4.add('5');
		a4.add('2');
		graph.put('4', a4);
		LinkedList<Character> a5 = new LinkedList<>();
		a5.add('3');
		a5.add('4');
		graph.put('5', a5);

		HashMap<Character, Boolean> visit = new HashMap<Character, Boolean>();
		char start = '1';
		dfs(graph, visit, start);
		System.out.println("==============");
		// 有向图
		HashMap<Character, LinkedList<Character>> graph_v = new HashMap<>();
		LinkedList<Character> a1_v = new LinkedList<>();
		a1_v.add('2');
		a1_v.add('3');
		graph_v.put('1', a1_v);
		LinkedList<Character> a3_v = new LinkedList<>();
		a3_v.add('5');
		graph_v.put('3', a3_v);
		LinkedList<Character> a2_v = new LinkedList<>();
		a2_v.add('4');
		graph_v.put('2', a2_v);
		LinkedList<Character> a4_v = new LinkedList<>();
		a4_v.add('5');
		graph_v.put('4', a4_v);
		LinkedList<Character> a5_v = new LinkedList<>();
		graph_v.put('5', a5_v);
		HashMap<Character, Boolean> visit_v = new HashMap<Character, Boolean>();
		char start_v = '1';
		dfs(graph_v, visit_v, start_v);
	}
}
