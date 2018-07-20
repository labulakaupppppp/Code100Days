package code;

public class Heap_sort {
	public static void heap_sort(int[] nums) {
		// 从最后一个非叶节点开始 调整堆 使堆得堆顶为最大或最小元素
		for (int i = nums.length / 2 -1; i >= 0; i--) {
			adjustHeap(nums, i, nums.length);
		}
		for (int i = nums.length - 1; i > 0; i--) {
			swap(nums, 0, i);
			adjustHeap(nums, 0, i);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		System.out.println("swap: one:"+i+" two:"+j);
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void adjustHeap(int[] nums, int i, int len) {
		int father = nums[i];
		for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
			if (k + 1 < len && nums[k] < nums[k + 1]) {
				k++;
			}
			if (nums[k] > father) {
				nums[i]=nums[k];
				i=k;
			} else {
				break;
			}
		}
		nums[i]=father;
	}
	private static void adjustHeap1(int[] nums, int i, int len) {
		int father = nums[i];
		for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
			if (k + 1 < len && nums[k] < nums[k + 1]) {
				k++;
			}
			if (nums[k] > father) {
				//小标从0 开始，当1的左孩子值小于右孩子的值时，需要交换 下标为1 与4的value，
				//此时,4/2=2 已经不是下标为4的父节点了 ，
				//所以 遇到这种情况，计算父节点下标的方法改为 （4-1）/2
				if(k%2==0) {
					swap(nums, k,(k-1)/2);
				}
				else {
					swap(nums, k,k/2);
				}
			} else {
				break;
			}
		}
	}

	private static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] nums = { 4, 6, 8, 5, 9 ,1,7,0,2,11};
		heap_sort(nums);
		print(nums);
	}
}
