package jianzhiOffer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符， 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 * @author miaoyumiao_i
 * @since 2018-09-13
 *
 */
public class Match {
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null)
			return false;
		int m = str.length;
		int n = pattern.length;
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		// 找到第一个非* 的字符
		for (int i = 1; i <= n; i++) {
			if (pattern[i - 1] == '*') {
				dp[0][i] = dp[0][i - 2];
			}
		}
		for (int i = 1; i <= m; i++) {// str
			for (int j = 1; j <= n; j++) {// pattern
				//匹配上了
				if (pattern[j - 1] == str[i - 1] || pattern[j - 1] == '.') {
					dp[i][j] = dp[i - 1][j - 1];
					//下一个字符是*
				} else if (pattern[j - 1] == '*') {
					if (pattern[j - 2] != str[i - 1] && pattern[j - 2] != '.')
						dp[i][j] = dp[i][j - 2];
					else {//分别对应* 1次，0次，多次
						dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
					}
				}
			}
		}
		return dp[m][n];

	}

	public static void main(String[] args) {
		Match c = new Match();
		char[] str = { 'a', 'a', 'a' };
		char[] pattern = { '.', 'a', 'b', '*', 'a', 'b' };
		boolean ans = c.match(str, pattern);
		System.out.println(ans);
	}
}
