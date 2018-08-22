package jianzhiOffer;

public class MoreThanHalfNum_29 {
	/**
	 * 剑指offer 29题
	 * @param nums
	 * @return 数组中超过一半的数字
	 */
	public static int more_than_half_num(int[] nums) {
		int key = nums[0];
		int count = 1;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				key = nums[i];
				count = 1;
			}
			if (nums[i] == key) {
				count++;
			} else {
				count--;
			}
		}
		boolean ismore=isMoreThanHalf(nums,key);
		if(ismore==true)
			return key;
		else 
			return 0;
	}
public static boolean  isMoreThanHalf(int[] nums, int key) {
	int count=0;
	boolean ismore=false;
	for(int i=0;i<nums.length;i++) {
		if(nums[i]==key) {
			count++;
		}
	}
	if(count>=nums.length/2+1) {
		ismore=true;
		}
	return ismore;
}
	public static void main(String[] args) {
		int[] a = {  2, 5, 2, 6, 2, 7, 2, 2 };
		int [] b= {1,2,3};
		int ans = more_than_half_num(b);
		System.out.println(ans);
	}
}
