package code;

public class SubMaxValue {
	/**
	 * 
	 * 
	 * 给定k个整数的序列{N1,N2,...,Nk }，其任意连续子序列可表示为{ Ni, Ni 1, ..., Nj }，其中 1 <= i <= j <=
	 * k。最大连续子序列是所有连续子序中元素和最大的一个，例如给定序列{ -2, 11, -4, 13, -5, -2
	 * }，其最大连续子序列为{11,-4,13}，最大连续子序列和即为20
	 * 
	 * @param nums
	 * @return
	 */
	public static int getMaxSubValue(int[] nums) {
		/**
		 * 求最长连续子数组的 和
		 */
		if (nums == null || nums.length <= 0)
			return 0;
		int sum = nums[0];
		int cur = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (cur <= 0) {
				cur = nums[i];
			} else {
				cur += nums[i];
			}
			if (cur > sum) {
				sum = cur;
			}
		}
		return sum;
	}

	public static int getMaxSubLength2(int[] nums) {
		/**
		 * 求最大连续子数组的连续长度
		 */
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 11, -4, 13, -5, -2 };
		System.out.println(getMaxSubValue(nums));

	}
}
