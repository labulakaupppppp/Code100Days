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
	public static String LeftRotateString2(String s, int n) {
		int len =s.length();
		String ans = "";
		if (s == null ||len == 0)
			return ans;
		char[] ch=s.toCharArray();
		n = n % len;
		reverse(ch,0,n-1);
		reverse(ch,n,len-1);
		reverse(ch,0,len-1);
		ans = new String(ch);
		System.out.println(ans);
		return ans;
		
	}
	private static void reverse(char[] s, int i, int j) {
		while (i < j) {
			swap(s, i++, j--);
		}
	}

	private static void swap(char[] s, int i, int j) {
		char temp = s[j];
		s[j] = s[i];
		s[i] = temp;
	}
	public static void main(String[] args) {
		LeftRotateString2("abcXY  Zdef", 3);
	}

}
