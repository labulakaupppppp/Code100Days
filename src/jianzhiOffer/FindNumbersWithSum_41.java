package jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * @author miaoyumiao_i
 *
 */
public class FindNumbersWithSum_41 {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (array == null)
			return ans;
		//low 指数字中低位的元素 初始值为0;high指数组中高位的元素 初始值为len-1
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int curSum = array[low] + array[high];
			if (curSum == sum) {
				// return new ArrayList<>(Arrays.asList(array[i], array[j]));
				ans.add(array[low]);
				ans.add(array[high]);
				return ans;
			} else if (curSum < sum) {
				low++;
			} else {
				high--;
			}
		}
		return ans;
	}

	private void MakeSureIfAdd(int[] array, int low, int high, ArrayList<Integer> ans) {
		if (ans.size() == 0) {
			ans.add(array[low]);
			ans.add(array[high]);
		} else {
			int before = ans.get(0) * ans.get(1);
			int now = array[low] * array[high];
			if (before > now) {
				ans.clear();
				ans.add(array[low]);
				ans.add(array[high]);
			}
		}
	}
}
