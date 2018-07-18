package code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//2018  7 18
public class BFS {
	// 广度优先
	public static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist,
			char start) {
		Queue<Character> queue = new LinkedList<>();
		queue.add(start);
		dist.put(start, 0);
		int i = 0;
		while (!queue.isEmpty()) {
			char top = queue.poll();
			//queue.remove();
			i++;
			System.out.println("The " + i + "th element:" + top + " Distance from start is:" + dist.get(top));
			int d = dist.get(top) + 1;
			for (Character c : graph.get(top)) {
				if (!dist.containsKey(c)) {
					dist.put(c, d);
					queue.add(c);
				}
			}

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
		graph.put('5',a5);
		

		HashMap<Character, Integer> dist = new HashMap<Character, Integer>();
		char start = '1';
		bfs(graph, dist, start);

	}
}
