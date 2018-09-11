package jianzhiOffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 * @author miaoyumiao_i
 *
 */
public class Sum_Solution {
	public int Sum_Solution(int n) {
		int sum = n;
		//使用 && 短路机制， 前面条件判断失败就不继续执行后面的判断。这样可以作为递归结束的条件。
		boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
		return sum;
	}
}
