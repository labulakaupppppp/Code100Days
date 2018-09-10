package jianzhiOffer;

public class LeftRotateString_42 {
	// S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
	public static String LeftRotateString(String s, int n) {
		String ans = "";
		if (s == null || s.length() == 0)
			return ans;
		int len = s.length();
		if (n == len)
			return s;
		n = n % len;

		String head = s.substring(0, n);
		String tail = s.substring(n);
		ans = tail + head;
		System.out.println(ans);

		return ans;
	}

	public static void main(String[] args) {
		LeftRotateString("abcXYZdef", 3);
	}

}
