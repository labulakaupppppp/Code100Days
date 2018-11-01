package written;

import java.util.Arrays;
import java.util.Scanner;
//求逆序对
//交换相邻的两个数字，求最少交换几次使得最终的序列有序
//fail 50% 超时
public class Vmware_002Swap {
	static int ans=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}

		Merge_Sort(num, n);

		System.out.println(ans);
		System.out.println(Arrays.toString(num));
	}

	private static void Merge_Sort(int[] num, int n) {
		 int length = 1;
		    int[] tmp = new int[n];
		    while (length < n){
		        MergeSort(num,tmp,n,length);
		        length *= 2;
		        MergeSort(tmp,num,n,length);
		        length *= 2;
		    }
		    
	}

	private static void MergeSort(int[] num, int[] tmp, int n, int length) {
		int i;
	    for (i = 0; i <= n - 2 * length; i += 2 * length){
	        Merge(num,tmp,i,i+length,i+2*length-1);
	    }
	    //最后剩下两个子列，进行归并
	    if (i + length < n){
	        Merge(num,tmp,i,i+length,n-1);
	    }
	    else{//只剩最后一个子列，不能成对
	        for (int j = i; j < n; j++){
	            tmp[j] = num[j];
	        }
	    }
		
	}

	private static void Merge(int[] num, int[] tmp, int left, int right, int rightEnd) {
		 int leftEnd = right - 1;
		    int start = left;
		    while (left <= leftEnd && right <= rightEnd){
		        if (num[left] > num[right]){
		            tmp[start++] = num[right++];
		            ans += (leftEnd - left+1); //如果当前left位置上的数大于right位置上的数，那么从left到leftEnd所有的数都大于
		        }
		        else{
		            tmp[start++] = num[left++];
		        }
		    }
		    while (left <= leftEnd){
		        tmp[start++] = num[left++];
		    }
		    while (right <= rightEnd){
		        tmp[start++] = num[right++];
		    }
	}

}
