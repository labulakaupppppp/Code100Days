package written;

import java.util.Arrays;
import java.util.Scanner;

public class Qunar_001Jump {

	// 67%
	/*
	 * 输入一个所有元素都是自然数的数组, 初始状态你的位置位于第1个元素, 每个元素的位置表示1步, 当前所在位置的元素数值表示你下一次前进能够移动的最大步数,
	 * 你的目标是以最小的前进次数从数组的第一个元素移动到数组的最后一个元素位置. 你需要输出每次前进的步数.
	 * 
	 * 举个例子, 输入: [2,3,1,1,4], 输出: [1,3]
	 * 
	 * 解释：你第一次跳的时候index为0，数值是2，可以跳1-2步，跳到index为1的3或index为2的1，这时跳到index为1的3，
	 * 然后第二次3步到index为4的4，结束。
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();
		String[] num = t.split(" ");
		int count = num.length;
		int[] nums = new int[count];
		for (int i = 0; i < count; i++) {
			nums[i] = Integer.parseInt(num[i]);
		}
		int ans;
		ans = jump1(nums);
		System.out.println(ans);
	}

	public static int jump1(int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		int[] r = new int[nums.length];
		int[] ans = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int max = nums[0];
		for (int i = 1, j = 0; i < nums.length; i++) {
			if (i <= max) {
				for (; j <= i - 1; j++) {
					if (j + nums[j] >= i) {
						if (dp[i] > dp[j] + 1) {
							dp[i] = dp[j] + 1;
							r[i] = i - j;
						}
						break;
					}
				}
				max = Math.max(max, nums[i] + i);
			} else {
				return -1;
			}
		}
		for (int k = 0; k < dp.length; k++) {
			System.out.print(dp[k] + " ");

		}
		System.out.println();
		int k = nums.length - 1;
		int count = 0;
		ans[count++] = r[k];
		k = k - r[k];
		while (k != 0) {
			ans[count++] = r[k];
			k = k - r[k];

		}

		for (int i = count - 1; i >= 0; i--) {
			System.out.print(ans[i] + " ");
		}
//		for(int i=0;i<count;i++) {
//			System.out.print(ans[i]+" ");
//		}

		return dp[nums.length - 1];
	}

	public static int jump(int[] nums) {
		// 输出走的步数
		if (nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int max = nums[0];
		for (int i = 1, j = 0; i < nums.length; i++) {
			if (i <= max) {
				// can reach
				for (; j <= i - 1; j++) {
					if (j + nums[j] >= i) {
						dp[i] = Math.min(dp[j] + 1, dp[i]);
						break;
					}
				}
				max = Math.max(max, nums[i] + i);
			} else {
				return -1;
			}
		}
		return dp[nums.length - 1];
	}
}
