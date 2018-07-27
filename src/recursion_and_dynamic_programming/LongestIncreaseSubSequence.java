package recursion_and_dynamic_programming;

import java.util.Arrays;

public class LongestIncreaseSubSequence {
	// O(n2)
	public static int[] getdp1(int[] arr) {
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	// O(n)
	public static int[] getIncreaceSubSequence(int[] arr, int[] dp) {
		// 先找到dp数组中的最大值，代表了最长的递增子序列长度
		int index = 0;
		int len = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;// arr中下标
			}
		}
		int[] ans = new int[len];
		ans[--len] = arr[index];
		for (int i = index; i >= 0; i--) {
			if (dp[i] == dp[index] - 1 && arr[i] < arr[index]) {
				ans[--len] = arr[i];
				index = i;
			}

		}
		return ans;
	}

	public static int[] op1(int[] arr) {
		if (arr.length == 0 || arr == null)
			return null;
		int[] dp = getdp1(arr);
		int[] ans = getIncreaceSubSequence(arr, dp);
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 5, 4, 6, 8, 9, 7 };
		int[] ans = op1(arr);
		System.out.println("op1" + Arrays.toString(ans));
		int[] arr1 = { 2, 1, 3, 5, 4, 6, 8, 9, 7 };
		int[] ans1 = op2(arr1);
		System.out.println("op2" + Arrays.toString(ans1));
	}

	public static int[] getdp2(int[] arr) {
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];// 保存递增序列最小结尾数序列
		ends[0] = arr[0];
		dp[0] = 1;
		int right = 0;// right之前为有效的序列
		int low = 0;
		int high = 0;
		int mid = 0;
		for (int i = 1; i < arr.length; i++) {
			low = 0;
			high = right;
			// 二分查找需要将arr[i]插入的位置
			while (low <= high) {
				mid = low + (high - low) / 2;
				if (arr[i] > ends[mid]) {
					low = mid + 1;
				} else {
					high = mid-1 ;
				}
			}
//			System.out.println("right:"+right+" high:"+high);
			right = Math.max(right, low);
			//System.out.println("max right:"+right);
			//System.out.println("i:"+i+" high:"+high);
			ends[low] = arr[i];
			//System.out.println("ends[right]:"+ends[right]);
			//System.out.println();
			dp[i] = low + 1;
		}
		return dp;
	}

	public static int[] op2(int[] arr) {
		if (arr.length == 0 || arr == null)
			return null;
		int[] dp = getdp2(arr);
		return getIncreaceSubSequence(arr, dp);
	}
}
