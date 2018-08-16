package newCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinSubNum_33 {
	/**
	 * 求出数组中经过拼接组成的最小的数字
	 */
	public static String getMin(int[] nums) {
		String ans = "";
		// 存在字符串拼接的问题，int可能不够，需要开辟新的String类型的数组
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			arr.add(nums[i]);
		}

		Collections.sort(arr, new Comparator<Integer>() {
			public int compare(Integer str1, Integer str2) {
				String s1 = str1 + "" + str2;
				String s2 = str2 + "" + str1;
				return s1.compareTo(s2);
			}
		});
		for (int j = 0; j < arr.size(); j++) {
			ans += arr.get(j);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 32, 3, 321 };
		System.out.println(getMin(nums));
	}
}
