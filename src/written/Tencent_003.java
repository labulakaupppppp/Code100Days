package written;

import java.util.Scanner;

public class Tencent_003 {
//pass
	public static int gcd(int x, int y) {
		return y != 0 ? gcd(y, x % y) : x;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int k = gcd(a, b);
			if (c % k != 0)
				System.out.println("NO");
			else
				System.out.println("YES");
		}

	}

}
