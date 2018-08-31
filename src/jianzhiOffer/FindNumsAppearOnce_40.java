package jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。 请写程序找出这两个只出现一次的数字。
 * 
 * @author miaoyumiao_i
 *
 */
public class FindNumsAppearOnce_40 {
	// num1,num2分别为长度为1的数组。传出参数
	// 将num1[0],num2[0]设置为返回结果
	public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], 2);
			}
		}
		int count = 0;
		int[] ans = new int[2];
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				ans[count++] = entry.getKey();
			}
		}
		/**
		 * 根据key找value for(Integer key : map.keySet()) { if(map.get(key)==1) {
		 * ans[count++]=key; } }
		 **/
		num1[0] = ans[0];
		num2[0] = ans[1];
	}

	public void findNumsAppearOnce2(int[] array, int num1[], int num2[]) {
		/**
		 * 异或的方式，两个相同的数字异或 结果为0 将所有数字异或后，得到一个数字，可以将数组分为两组，每组包含一个 只出现一次的数字。
		 */
		int mid = array[0];
		// 所有的数字异或
		for (int i = 1; i < array.length; i++) {
			mid ^= array[i];
		}
		int temp = 0;
		// 找到右数第一个1 temp为右数第一个为1的位置
		while ((mid & 1) == 0) {
			temp++;
			mid = mid >> 1;
		}

		// 分组

		for (int i = 0; i < array.length; i++) {
			if (isBit(array[i], temp)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

	private boolean isBit(int i, int temp) {
		i = i >> temp;
		return (i & 1) == 1 ? true : false;
	}
}
