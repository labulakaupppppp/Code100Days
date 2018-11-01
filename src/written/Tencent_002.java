package written;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


//fail

/*
 * 4
2 1
3 2
null
Exception in thread "main" java.lang.NullPointerException
	at written.Tencent_002.main(Tencent_002.java:28)
 */
public class Tencent_002 {
	int n, m;
	// static ArrayList<Integer> v= new ArrayList<>();
	static Vector[] v = new Vector[1111];
	// List<Integer> have= new ArrayList<>();
	static Vector[] have = new Vector[1111];
	static int[] vis = new int[1111];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x, y;
			x = sc.nextInt();
			y = sc.nextInt();
			System.out.println(v[x]);
			v[x].add(y);
		}
		for (int i = 1; i <= n; i++) {

			vis[i] = i;
			dfs(i, i);
		}
		int[] u = new int[1111];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < have[i].size(); j++) {

				u[(int) have[i].get(j)]++;
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (u[i] > have[i].size()) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	static void dfs(int x, int l) {
		for (int i = 0; i < v[x].size(); i++) {
			if (vis[(int) v[x].get(i)] != 0) {
				have[l].add(((int) v[x].get(i)));
				vis[(int) v[x].get(i)] = 1;
				dfs((int) v[x].get(i), l);
			}
		}
	}

}
