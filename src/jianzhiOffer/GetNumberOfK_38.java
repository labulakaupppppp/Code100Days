package jianzhiOffer;

public class GetNumberOfK_38 {
	//统计一个数字在排序数组中出现的次数。
	/**
	 * 数组有序，可以想到二分，实现log（n）的解法。
	 * 找到k第一次出现的位置，与最后一次出现的位置，坐差即可求得k出现的次数。
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length <= 0)
			return 0;
		int left = getLeft(array, k, 0, array.length - 1);
		int right = getRight(array, k, 0, array.length - 1);

		if (left == -1 || right == -1) {
			return 0;
		} else
			return right-left+1;
	}
//找到第一个k出现的位置。
	private int getLeft(int[] array, int k, int low, int high) {
		if (low > high)
			return -1;

		while (low <= high) {
			int mid = (high + low) >> 1;
		//第一次遇见k，要继续判断前面的数字是否为k
			if (array[mid] == k) {
				if ((mid > 0 && array[mid - 1] != k) || (mid == 0))
					//前面已经不是k了，直接返回当前位置，就是k第一次出现的位置
					return mid;
				else
					//前面仍是我的k，那么继续前进吧
					high = mid - 1;
			} else if (array[mid] < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	private int getRight(int[] array, int k, int low, int high) {
		if (low > high)
			return -1;

		while (low <= high) {
			int mid = (high + low) >> 1;
		//仍是第一次遇见k
			if (array[mid] == k) {
				if ((mid < high && array[mid + 1] != k) || (mid == high))
					return mid;
				else
					//后面还是我的k，继续同行
					low = mid + 1;
			} else if (array[mid] < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 4, 4, 4, 4, 4, 5 };
		GetNumberOfK_38 an = new GetNumberOfK_38();
		System.out.println(an.GetNumberOfK(array, 4));
	}
}
