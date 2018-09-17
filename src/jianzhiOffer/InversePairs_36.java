package jianzhiOffer;

/**
 * 题目描述 在数组中的两个数字，如果前面一个数字大于后面的数字， 则这两个数字组成一个逆序对。输入一个数组, 求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 * @author miaoyumiao_i
 *思路：
 *将数组分成子数组，先计算子数组中的逆序对数量，并排序；在计算相邻子数组之间的逆序对数量。加和
 */
public class InversePairs_36 {
	public static int inversePairs(int[] array) {
		if (array.length <= 0 || array == null)
			return 0;
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		return getInInversePairs(array, copy, 0, array.length - 1);

	}

	private static int getInInversePairs(int[] array, int[] copy, int start, int end) {
		if (start >= end)
			return 0;
		int mid = (end + start) >> 1;
		int leftcount = getInInversePairs(array, copy, start, mid) % 1000000007;
		int rightcount = getInInversePairs(array, copy, mid + 1, end) % 1000000007;
		int count = 0;
		int i = mid;
		int j = end;
		int locCopy = end;
		while (i >= start && j > mid) {
			if (array[i] > array[j]) {
				count += j - mid;
				copy[locCopy--] = array[i--];
				if (count >= 1000000007)
					count %= 1000000007;
			} else {
				copy[locCopy--] = array[j--];
			}

		}
		while (i >= start) {
			copy[locCopy--] = array[i--];
		}
		while (j > mid) {
			copy[locCopy--] = array[j--];
		}
		for (int k = start; k <= end; k++) {
			array[k] = copy[k];
		}

		return (leftcount + rightcount + count) % 1000000007;
	}
	public static int inversePairs2(int[] array) {
		//超时的解法
		if (array.length <= 0 || array == null)
			return 0;
		int count=0;
		for (int i = 0; i < array.length; i++) {
			for(int j=i;j<array.length;j++) {
				if(array[i]>array[j])
					count++;
			}
		}
		return count>1000000007? count%1000000007:count;

	}
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 0 };
		System.out.println(inversePairs(arr));
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 0 };
		System.out.println(inversePairs2(arr1));
	}
}
