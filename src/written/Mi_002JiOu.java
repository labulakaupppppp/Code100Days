package written;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mi_002JiOu {

	public static void reOrderArray(int[] a) {
		int len = a.length;
		int oddstart = 0;
		int oddcount = 0;
		int[] newArray = new int[len];
		//先计算偶数的个数
		for (int i = 0; i < len; i++) {
			if (a[i] % 2 == 0) {
				oddcount++;
			}
		}
		for (int i = 0; i < len; i++) {
			//奇数在前
			if (a[i] % 2 != 0) {
				newArray[oddstart++] = a[i];
			} else {
				//偶数在后
				newArray[oddcount++] = a[i];
			}
		}
		for (int i = 0; i < len; i++) {
			a[i] = newArray[i];
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		
		// 奇数排在偶数前面 没有n
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		// 输入没有处理好的。。。。。。hasNextInt方法 不能判断下面是否还有输入  
//		while (sc.hasNextInt()) {
//			list.add(sc.nextInt());
//		}
		int[] b= {2,3,5,1,8,0};
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i);
			System.out.println(list.get(i));
			
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		reOrderArray(b);
	}

}
