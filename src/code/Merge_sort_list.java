package code;

public class Merge_sort_list {

	public static void merge_sort(int[] nums, int low, int high, int[] ans) {

		if (low < high) {
			int mid = low + (high - low) / 2;
			System.out.println("mid" + nums[mid]);
			merge_sort(nums, low, mid, ans);
			merge_sort(nums, mid + 1, high, ans);
			merge(nums, low, mid, high, ans);

		}
	}

	private static void merge(int[] nums, int low, int mid, int high, int[] ans) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		int k = 0;

		while (i <= mid && j <= high) {

			if (nums[i] <= nums[j]) {
				System.out.println("k:"+k+",i:"+i);
				ans[k++] = nums[i++];

			} else {
				System.out.print("k:"+k+",j:"+j+"  ");
				ans[k++] = nums[j++];
				System.out.println("ans[k]:"+ans[k-1]);
			}
		}
		while (i <= mid) {
			ans[k++] = nums[i++];
		}
		while (j <=high) {
			System.out.println("k:"+k+",j:"+j);
			ans[k++] = nums[j++];
			
		}
	}

	public static void main(String[] args) {

		int[] nums = { 2, 5, 7};
				//, 1, 3, 6, 0 };
		int low = 0;
		int high = nums.length;
		int[] ans = new int[high];
		merge_sort(nums, low, high - 1, ans);
		for (int i = 0; i < high; i++) {
			System.out.println(nums[i]);
		}
	}
}
