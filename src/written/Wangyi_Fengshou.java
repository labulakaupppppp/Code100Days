package code;

import java.util.Scanner;

public class Fengshou {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 列数
		int[] a = new int[n];
		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if (i != 0) {
				sum[i] = sum[i - 1] + a[i];
			} else {
				sum[i] = a[i];
			}
		}
		int q = sc.nextInt();
		int x;

		for (int i = 0; i < q; i++) {
			x = sc.nextInt();
			int l = 0, h = n - 1;
			int ans = l;
			while (h >= l) {
				int mid = (l + h) / 2;
				if (sum[mid] > x) {
					h = mid - 1;
					ans = mid;
				} else if (sum[mid] < x) {
					l = mid + 1;
				} else {
					ans = mid;
					break;
				}
			}
			// int* t = lower_bound(sum, sum + n, x);
			System.out.println(ans + 1);
		}

	}
}
