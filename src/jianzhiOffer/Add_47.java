package jianzhiOffer;

public class Add_47 {
	//不使用 加减乘除计算加法
	/**
	 * 例如：5+7（101+111）
	 * num1^num2:010
	 * (num1 & num2) << 1:1010
	 *  num1^num2:1000
	 * (num1 & num2) << 1=(010&1010)<<1:100
	 * num1^num2=1000^100 = 1100，
	 * (num1 & num2) << 1= (1000^100)<<1=0进位值为0
	 * 结束
	 */
	public int Add(int num1, int num2) {
		while (num2 != 0) {
			int temp = num1 ^ num2;
			num2 = (num1 & num2) << 1;
			num1 = temp;
		}
		return num1;

	}
}
