package code;

public class Sort {
	static int count;

	public static void quick_sort(int[] nums, int low, int high) {
		if (low >= high)
			return;
		count++;
		System.out.println();
		System.out.println("count:" + count + "low:" + low + " high:" + high);
		int index = partition(nums, low, high);
		System.out.println("第" + count + "次排序结果为：");
		print(nums);
		quick_sort(nums, low, index - 1);
		quick_sort(nums, index + 1, high);

	}

	private static int partition(int[] nums, int low, int high) {
		// TODO Auto-generated method stub
		int start = low;
		int end = high;
		int mid = low + (high - low) / 2;
		int key = nums[mid];
		System.out.println("key:" + key);
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
	}
}
