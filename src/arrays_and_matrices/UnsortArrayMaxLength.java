package arrays_and_matrices;

import java.util.HashMap;

public class UnsortArrayMaxLength {
	/**
	 * 求 未排序正数数组中累加和为给定值的最长子数组的长度
	 * arr={1,2,1,1,1} k=3
	 * 最长子数组为{1,1,1} 所以len=3
	 */
	public static int getMaxLen(int[] arr,int k){
		//数组中的数字全都是正数
		if(arr==null|| arr.length<=0)
			return 0;
		int left =0;
		int right = 0;
		int sum=arr[0];
		int len =0;
		while(right < arr.length){
			if(sum==k){
				len=Math.max(len,right-left+1);
				sum-=arr[left++];
			}else if(sum<k){
				right++;
				//注意判断right++之后，是否越界
				if(right==arr.length)
					break;
				sum+=arr[right];
			}else{
				sum-=arr[left++];
			}
		}
		return len;
	}
	public static int maxLength(int[] arr,int k){
		if(arr==null || arr.length<=0 )
			return 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		int len=0;
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
			if(map.containsKey(sum-k)){
				len=Math.max(i-map.get(sum-k),len);
			}
			if(!map.containsKey(sum)){
				map.put(sum,i);
			}
		}
		return len;
	}
public static void main(String[] args) {
	int[] arr={1,2,1,1,1};
	int k=3;
	int ans=getMaxLen(arr, k);
	System.out.println(ans);
	int[] arr1={1,-1,3,1,-5,8};
	System.out.println(maxLength(arr1,k));
}
}
