package written;

import java.util.Scanner;

public class Iqiyi_LuckyNum_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] num = new int[6];
		for (int i = 0; i < 6; i++) {
			num[i] = Integer.valueOf(str.substring(i, i + 1));
		}
		int left = num[0] + num[1] + num[2];
		int right = num[3] + num[4] + num[5];
		//System.out.println(left + " " + right);
		if (left == right) {
			System.out.println("0");
			return;
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <= 9; j++) {
				if (i < 3) {
					int temp = left - num[i] + j;
					if (temp == right) {
						System.out.println("1");
						return;
					}
				} else {
					int temp = right - num[i] + j;
					if (temp == left) {
						System.out.println("1");
						return;
					}
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (i == j)
					continue;
				for (int k = 0; k <= 9; k++) {
					for (int l = 0; l <= 9; l++) {
						int temp1 = left, temp2 = right;
						if (i < 3) {
							temp1 = temp1 - num[i] + k;
						} else {
							temp2 = temp2 - num[i] + k;
						}
						if (j < 3) {
							temp1 = temp1 - num[j] + l;
						} else {
							temp2 = temp2 - num[j] + l;
						}
						if (temp1 == temp2) {
							System.out.println("2");
							return;
						}

					}
				}
			}
		}
		System.out.println("3");
		return;
	}
}
