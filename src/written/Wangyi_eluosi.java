package code;

import java.util.HashMap;
import java.util.Scanner;

public class XiaoYi_eluosi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();//列数
		int m=sc.nextInt();
		int[] nums = new int[m];
		for(int i=0;i<m;i++) {
			nums[i]=sc.nextInt();
		}
		HashMap<Integer,Integer> map = new HashMap<>();
		int[] key=new int[n];
		int kk=0;
		for(int i=0;i<m;i++) {
			if(map.containsKey(nums[i])) {
				int temp=map.get(nums[i]);
				map.put(nums[i], temp+1);
			}else {
				key[kk++]=nums[i];
				map.put(nums[i],1);
			}
		}
		int[] c= new int[n];
		for(int i=0;i<kk;i++) {
			c[i]=map.get(key[i]);
		}
		int min=c[0];
		for(int i=0;i<c.length;i++) {
			if(c[i]<min) {
				min=c[i];
			}
		}
		System.out.println(min);
	}
}
