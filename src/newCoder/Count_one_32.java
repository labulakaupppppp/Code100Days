package newCoder;

public class Count_one_32 {
	/**
	 * 剑指offer 32 从1到n中 1出现的次数
	 */
	public static int count_one(int n) {
		if (n <= 0)
			return 0;
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans += count_one_main(i);
		}
		return ans;
	}

	private static int count_one_main(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		while (n != 0) {
			if (n % 10 == 1) {
				count++;
			}
			n = n / 10;
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println(count_one(21235));
	}
}
