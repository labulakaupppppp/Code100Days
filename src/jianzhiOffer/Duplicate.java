package jianzhiOffer;

public class Duplicate {
	// Parameters:
	// numbers: an array of integers
	// length: the length of array numbers
	// duplication: (Output) the duplicated number in the array number,length of
	// duplication array is 1,so using duplication[0] = ? in implementation;
	// Here duplication like pointor in C/C++, duplication[0] equal *duplication in
	// C/C++
	// 这里要特别注意~返回任意重复的一个，赋值duplication[0]
	// Return value: true if the input is valid, and there are some duplications in
	// the array number
	// otherwise false
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers == null || numbers.length <= 0) {
			return false;
		}
		/**
		 * 注意到数组中的数字都在0——n-1的范围内。如果没有重复数字，那么排序之后数字i将出现在下标为i的位置
		 * 从头到尾依次扫描这个数组中的每个数字。当扫描到下标为i的数字时，首先比较这个数字（m）是不是等于i。
		 * 如果是，接着扫描下一个数字。如果不是，再拿m和第m个数字比较。如果相等，就找到了一个重复数字。
		 * 如果不等，就把第i个数字和第m个数字交换，把m放到属于它的位置。接下来重复比较，直到找到重复数字。
		 */
		for (int i = 0; i < length; i++) {
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;
				}
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] num = { 2, 3, 2, 5, 4, 7 };
		int[] dup = new int[num.length];
		Duplicate c = new Duplicate();
		c.duplicate(num, num.length, dup);
		System.out.println(dup[0]);
	}
}
