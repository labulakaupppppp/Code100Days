package jianzhiOffer;

public class Sum_Solution {
	public int Sum_Solution(int n) {
		int sum = n;
		boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
		return sum;
	}
}
