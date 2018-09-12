package jianzhiOffer;

public class StrToInt_48 {
	boolean g_status = false;
	boolean minus = false;

	public int StrToInt(String str) {
		if (str == null || str.length() <= 0) {
			g_status = false;
			return 0;
		}
		int count = 0;
		if (str.charAt(0) == '+') {
			count++;

		} else if (str.charAt(0) == '-') {
			count++;
			minus = true;
		}
		int num = 0;
		for (int i = count; i < str.length(); i++) {
			char temp = str.charAt(i);
			// System.out.println("0"+Integer.valueOf('0'));//48
			if (temp >= '0' && temp <= '9') {
				num = num * 10 + Integer.valueOf(temp - '0');
			}else {
				g_status=false;
				return 0;
			}
		}
		if (minus == true) {
			num = 0 - num;
		}
		return num;
	}

	public static void main(String[] args) {
		String str = "11111111a";
		StrToInt_48 c = new StrToInt_48();
		int num = c.StrToInt(str);
		System.out.println(num);
	}
}
