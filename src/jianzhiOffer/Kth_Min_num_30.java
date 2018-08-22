package newCoder;
//剑指offer 30
import java.util.ArrayList;

public class Kth_Min_num_30 {
	// 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
	// 则最小的4个数字是1,2,3,4,。
	public static ArrayList<Integer> get_kth_min_nums(int[] nums, int k) {
		/**
		 * 思想：建立一个大根堆 容量为k，先将前k个数字放入，之后一次对比nums[i]与k的根节点的大小 nums[i]<root 替换 nums[i]>root
		 * i++
		 */
		ArrayList<Integer> ans = new ArrayList<>();
		if (nums == null || nums.length < 0 || k <= 0 || nums.length < k)
			return ans;
		//建堆 调整为大根堆
		for (int i = k / 2 - 1; i >= 0; i--) {
			adjustHeap(nums, i, k - 1);
		}
		//k之后的nums数值若小于堆顶，则交换
		int temp;
		for (int i = k; i < nums.length; i++) {
			print(nums);
			if (nums[i] < nums[0]) {
				temp = nums[0];
				nums[0] = nums[i];
				nums[i] = temp;
				adjustHeap(nums, 0, k - 1);
			}
		}

		// 将数组赋值给arraylist
		for (int kk = 0; kk < k; kk++) {
			ans.add(nums[kk]);
		}
		return ans;
	}

	private static void adjustHeap(int[] nums, int i, int length) {
		int father = nums[i];
		for (int k = 2 * i + 1; k <= length; k = k * 2 + 1) {
			if (k + 1 < length && nums[k] < nums[k + 1])
				k++;
			if (nums[k] > father) {
				nums[i] = nums[k];
				i = k;
			} else
				break;
		}
		nums[i] = father;
	}

	private static void print(int[] temp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] ll = { 4, 5, 1, 6, 2, 7, 3, 8 };
		ArrayList<Integer> ans = get_kth_min_nums(ll, 4);
		System.out.println("~~~~~~~~~~~~~");
		System.out.println(ans.toString());
	}

}
