package written;

import java.util.Scanner;
/**
 * 题意：

一个整数序列S的LCM（最小公倍数）是指最小的正整数X使得它是序列S中所有元素的倍数，那么LCM(S)=X。

例如，LCM(2)=2,LCM(4,6)=12,LCM(1,2,3,4,5)=60。
现在给定一个整数N（1<=N<=1000000）,需要找到一个整数M，满足M>N，同时LCM(1,2,3,4,...,N-1,N) 整除 LCM(N+1,N+2,....,M-1,M)，即LCM(N+1,N+2,....,M-1,M)是LCM(1,2,3,4,...,N-1,N) 的倍数.求最小的M值。

分析：
51分类上说的是一个四级的算法，然后就一直想啊想啊的。让我们求1,2,3,,,,,n的lcm还是比较容易的，就是求解这个区间中的质数的最大倍数小于等于n的那些数，乘起来就可以得到lcm，当然了这一题我们不需要乘，只需要将这些数字都记录写来就可以了的。

我们不需要求出n,n+1....m的lcm，只需要保证这个lcm可以被前面的lcm整数就可以了，也就是可以整除前面记录的所有值


 * @author miaoyumiao_i
 *
 */
public class Tencent_001 {
	static int maxN = 1000005;

	static int flag; // 最大的质数
	static int num; // 质数的个数
	int[] a = new int[maxN+1];
	static boolean[] prime = new boolean[maxN+1];

	public static void Prime() {
		for (int i = 0; i < maxN; i++) {
			prime[i] = true;
		}
		prime[0] = false;
		prime[1] = false;
		int i;
		for (i = 2; i * i <= maxN; i++) {
			if (prime[i]) {
				int j = i * 2;
				while (j <= maxN) {
					prime[j] = false;
					j += i;
				}
			}
		}
	}

	public static void main(String[] args) {
		Prime();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		num = 2;
		flag = 0;
		for (int i = 1; i <= n; i++) {
			if (prime[i]) {
				int ans = i;
				while (ans <= n / i) {
					ans *= i;
				}

				flag = (n / ans + 1) * ans;
				if (num < flag)
					num = flag;
			}
			// cout<<a[i]<<endl;
		}
		System.out.println(num);
	}
}
