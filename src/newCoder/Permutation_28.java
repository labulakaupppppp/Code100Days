package newCoder;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c
 * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @param str
 * @return
 */
	public static ArrayList<String> permutation(String str) {
		ArrayList<String> ans = new ArrayList<>();
		if (str == null || str.length() <= 0)
			return ans;
		char[] ch = str.toCharArray();
		permutation_main(ch, 0, ans);
		Collections.sort(ans);
		return ans;
	}

	private static ArrayList<String> permutation_main(char[] ch, int i, ArrayList<String> ans) {
		if (i == ch.length - 1) {
			String temp = String.valueOf(ch);
			if (!ans.contains(temp)) {
				ans.add(temp);
			}
		} else {
			for (int j = i; j < ch.length; j++) {
				swap(ch, i, j);
				permutation_main(ch, i + 1, ans);
				swap(ch, i, j);
			}
		}
		return ans;
	}

	private static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(permutation("abc").toString());
		
	}
}
