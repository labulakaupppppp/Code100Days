package jianzhiOffer;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * @author miaoyumiao_i
 *
 */
public class UglyNumber_34 {
//按照自然数的顺序计算每一个数字是不是丑数，如果某数能被2整除就一直除2，能被3、5整除就一直除3、5.
//最后剩下的数字变为1 即为丑数
	// 该种算法 即使不是丑数也需要计算，超时。
	public static boolean CalUgly(int number) {
		if (number <= 0)
			return false;
		while (number % 2 == 0) {
			number = number / 2;
		}
		while (number % 3 == 0) {
			number = number / 3;
		}
		while (number % 5 == 0) {
			number = number / 5;
		}
		return number == 1 ? true : false;

	}

	public static int getUgly(int index) {
		if (index <= 0)
			return 0;
		int number = 0;// 从1开始遍历整数
		int count = 0;// 第count个丑数
		while (count < index) {
			++number;
			if (CalUgly(number)) {
				count++;
			}
		}
		return number;
	}

	/**
	 * 第二方式：第一个丑数是1； 之后的丑数都是使用 之前的丑数乘以 2、3、5得到的 【1】*{2，3，5}->{2,3,5} 找到最小的数字2
	 * 加入丑数数组。ugly：【1，2】 【1，2】*{2，3，5}->{4。3，6。5，10} 找到最小的3加入丑数数组【1，2，3】 之后类似，只需要维护乘
	 * 2 3 5的最小值 p2,p3,p5
	 * 
	 * @param index
	 * @return
	 */
	public static int getUgly2(int index) {
		int[] ugly = new int[index + 1];
		if (index < 7)
			return index;
		int p2 = 0, p3 = 0, p5 = 0;
		ugly[0] = 1;
		int cur = 1;
		for (cur = 1; cur < index; cur++) {
			int min = getMin(ugly[p2], ugly[p3], ugly[p5]);
			ugly[cur] = min;
			if (ugly[p2] * 2 == min)
				p2++;
			if (ugly[p3] * 3 == min)
				p3++;
			if (ugly[p5] * 5 == min)
				p5++;

		}
		return ugly[cur - 1];
	}

	private static int getMin(int i, int j, int k) {
		// TODO Auto-generated method stub
		int min = Math.min(i * 2, Math.min(j * 3, k * 5));
		return min;
	}

	public static void main(String[] args) {
		int number = 1500;
		// 第一种方法
		System.out.println("第一种方法");
		long start = System.currentTimeMillis(); // 获取开始时间
		System.out.println(getUgly(number)); // 测试的代码段
		long end = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (end - start) + "ms");
		// 第二种方法运行时间：
		System.out.println("第二种方法");
		long startTime = System.currentTimeMillis(); // 获取开始时间
		System.out.println(getUgly2(number)); // 测试的代码段
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
	}
	/**
	 * 第一种方法 859963392 程序运行时间： 28790ms 
	 * 第二种方法 859963392 程序运行时间： 1ms
	 */
}
