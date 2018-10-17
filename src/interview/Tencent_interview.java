package interview;
//腾讯一面代码题
public class Tencent_interview {// a2b3----aabbb
	public static void print(String str) {
		int n = str.length();
		String ans = "";
		int i = 0;
		while (i < n) {
			String tmp = "";

			while (i < n && str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				tmp += str.charAt(i);
				// System.out.println(str.charAt(i));
				i++;
			}
			String num = "";
			while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				// System.out.println(str.charAt(i));
				num += str.charAt(i);
				i++;
			}
			int nn = Integer.parseInt(num);
			for (int k = 0; k < nn; k++) {
				ans += tmp;
			}

		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		String str = "ab2b13";
		print(str);
	}
}
