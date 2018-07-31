package code;

import java.util.Stack;

public class Quick_Sort {
	static int count;

	public static void quick_sort(int[] nums, int low, int high) {
		if (low >= high)
			return;
		count++;
		//System.out.println("count:" + count + "low:" + low + " high:" + high);
		int index = partition(nums, low, high);
		//print(nums);
		quick_sort(nums, low, index - 1);
		quick_sort(nums, index + 1, high);

	}

	private static int partition(int[] nums, int low, int high) {
		// TODO Auto-generated method stub
		int start = low;
		int end = high;
		int mid = low + (high - low) / 2;
		int key = nums[mid];
		//System.out.println("key:" + key);
		while (start < end) {
			while (nums[end] > key) {
				end--;
			}
			if (nums[end] < key) {
				swap(nums, end, start);
			}
			while (nums[start] < key) {
				start++;
			}
			if (nums[start] > key) {
				swap(nums, start, end);
			}
		}
		return end;
	}
	/*非递归实现快排 
	 * 用栈保存中间变量，即求出index后的前半段与后半段的始末下标
	 * 注意保存的时候先存end 后存start （栈先进后出 倒序）
	 */
	public static void quick_unRec(int[] arr,int low ,int high) {
		Stack<Integer> stack = new Stack<>();
		stack.push(high);
		stack.push(low);
		while(!stack.isEmpty()) {
			int left=stack.pop();
			int right = stack.pop();
			int index=partition(arr, left, right);
			if(left<index-1) {
				stack.push(index-1);
				stack.push(left);
			}
			if(right>index+1) {
				stack.push(right);
				stack.push(index+1);
			}
		}
	}

	private static void swap(int[] nums, int end, int start) {
		// TODO Auto-generated method stub
		int temp = nums[end];
		nums[end] = nums[start];
		nums[start] = temp;

	}

	private static void print(int[] nums) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] nums = { 6, 4, 2, 7, 3, 9, 0, 5, 10, 1 };
		int low = 0;
		int high = nums.length - 1;
		quick_sort(nums, low, high);
		print(nums);
		//非递归
		System.out.println();
		System.out.println("非递归：");
		int[] nums1 = { 6, 4, 2, 7, 3, 9, 0, 5, 10, 1 };
		quick_unRec(nums1,low,high);
		print(nums1);
	}
}
