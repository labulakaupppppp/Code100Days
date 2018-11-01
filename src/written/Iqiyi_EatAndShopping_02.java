package written;

import java.util.Scanner;

import jianzhiOffer.Sum_Solution;

public class Iqiyi_EatAndShopping_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int p = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {

			String type = sc.next();
			int food = sc.nextInt();
			if (type.equals("A")) {// buy
				a[food - 1]++;
			}
			if (type.equals("B")) {
				a[food - 1]--;
			}
		}
		int kk = a[p-1];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] > kk) {
				ans++;
			}
		}
		System.out.println(ans + 1);
	}
}
