package jianzhiOffer;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student.
 * a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a
 * student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

 *先翻转每个单词（以" "为分界），自后再翻转整个句子。
 *
 *注意：不多占用空间资源
 */
public class ReverseSentence_42 {
	public static String ReverseSentence(String str) {
		int n = str.length();
		if (str == null || n <= 0)
			return "";
		char[] s = str.toCharArray();
		int i = 0, j = 0;
		while (j <= n) {
			//翻转每个单词
			if (j == n || s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
			j++;
		}
		//翻转整个单词
		reverse(s, 0, n - 1);
		String ans = new String(s);
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
		ReverseSentence("abcde ca ha");
	}
}
