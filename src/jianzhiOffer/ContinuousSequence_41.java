package jianzhiOffer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good
 * Luck!
 * 
 * @author miaoyumiao_i
 *
 */
public class ContinuousSequence_41 {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (sum < 3)
			return ans;
		int mid = (1 + sum) / 2;
		int low = 1;
		int high = 2;
		int count = low + high;
		while (low < mid) {
			if (count == sum) {
				addNewList(low, high, ans);
			}
			while (low < mid && count > sum) {
				count -= low;
				low++;
				if (count == sum) {
					addNewList(low, high, ans);
				}
			}
			high++;
			count += high;
		}
		return ans;
	}

	private void addNewList(int low, int high, ArrayList<ArrayList<Integer>> ans) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = low; i <= high; i++) {
			list.add(i);
		}
		ans.add(list);

	}
	public static void main(String[] args) {
		ContinuousSequence_41 c41 = new ContinuousSequence_41();
		ArrayList<ArrayList<Integer>> ans=c41.FindContinuousSequence(20);
		System.out.println(ans.toString());
	}
}
