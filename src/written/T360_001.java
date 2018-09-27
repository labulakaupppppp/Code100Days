package written;

import java.util.Arrays;
import java.util.Scanner;

public class T360_001 {
	static int[] a = new int[10001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			a[i]=sc.nextInt();
		}
		if(n<3) {
			System.out.println("-1");
			return;
		}
		int[] p=new int[3];
		p[0] = a[0]; p[1] = a[1]; p[2] = a[2];
		Arrays.sort(p);
		if (p[0] + p[1] > p[2]) {
			System.out.println(3);
			return ;
		}
		int ma = p[2];
		int all = p[0] + p[1] + p[2];
		for (int i = 3; i < n; i++) {
			int u = a[i];
			if (u > ma) {
				if (all > u) {
					System.out.println(i+1);
					return ;
				}
				ma = u;
			} else {
				if (all - ma + u > ma) {
					System.out.println(i+1);
					return ;
				}
			}
			all += u;
		}
		System.out.println(-1);
		return;
	}
}
