package jianzhiOffer;

public class IsNumeric {
	/*
	 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123",
	 * "3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
	 */
	int index = 0;

	public boolean isNumeric(char[] str) {
		if (str.length < 1)
			return false;
		int len = str.length;
		boolean flag = scannerInteger(str);

		if (index < len && str[index] == '.') {
			index++;
			flag = scannerUnsignedInteger(str) || flag;
		}
		if (index < len && (str[index] == 'e' || str[index] == 'E')) {
			index++;
			flag = flag && scannerInteger(str);
		}
		return flag && index == len;
	}

	private boolean scannerUnsignedInteger(char[] str) {
		// TODO Auto-generated method stub
		int start = index;
		while (index < str.length && isNum(str[index])) {
			index++;
		}
		return start < index;
	}

	private boolean scannerInteger(char[] str) {
		if (index < str.length && (str[index] == '-' || str[index] == '+'))
			index++;
		return scannerUnsignedInteger(str);

	}

	private boolean isNum(char c) {
		// TODO Auto-generated method stub
		if (c >= '0' && c <= '9')
			return true;
		else
			return false;
	}
	// 正则表达式解法

	public boolean isNumeric2(char[] str) {
		String string = String.valueOf(str);
		return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
	}

	/*
	 * 以下对正则进行解释: 
	 * [\\+\\-]? -> 正或负符号出现与否 
	 * \\d* -> 整数部分是否出现，如-.34 或 +3.34均符合
	 * (\\.\\d+)? -> 如果出现小数点，那么小数点后面必须有数字； 否则一起不出现
	 * ([eE][\\+\\-]?\\d+)? ->
	 * 如果存在指数部分，那么e或E肯定出现，+或-可以不出现， 紧接着必须跟着整数；或者整个部分都不出现
	 */
	public static void main(String[] args) {
		char[] c = { '1', '2', 'e' };
		IsNumeric isn = new IsNumeric();
		boolean ans = isn.isNumeric2(c);
		System.out.println(ans);
	}
}
