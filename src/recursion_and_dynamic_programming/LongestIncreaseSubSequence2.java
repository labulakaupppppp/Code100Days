package recursion_and_dynamic_programming;

import java.util.Arrays;

public class LongestIncreaseSubSequence2 {
	
	public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        int len = 0;
        int[] min = new int[nums.length];
        min[len++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min[len - 1]) {
                min[len++] = nums[i];
            } else {
                int position = findPosition(min, 0, len - 1, nums[i]);
               // System.out.println(position);
                min[position] = nums[i];
            }
        }
        System.out.println("min:"+Arrays.toString(min));
        return len;
    }

    private static  int findPosition(int[] min, int low, int high, int k) {
        // 在min【】中找到k可以换的位置
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (min[mid] == k) {
                return mid;
            } else if (min[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 5, 4, 6, 8, 9, 7 };
		int ans = lengthOfLIS(arr);
		System.out.println("length:" + ans);
		
		
	}

}
