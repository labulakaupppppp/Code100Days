package written;

import java.util.Scanner;

import java.util.Stack;

//fail

/*
 * q:问题数
 * k:进制
 * [l,r]:范围(10进制)
 * 问题：求在[l,r]范围内k-1出现次数最多的数字，出现次数相同的输出小者
 */
public class T360_002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		
		for(int i=0;i<q;i++) {
			int k=sc.nextInt();
			int l=sc.nextInt();
			int r=sc.nextInt();
			int[] ans=new int[r-l+1];
			for(int j=l;j<r;j++) {
				Count(k,j,ans);
			}
		}

	}

	private static void Count(int k, int j, int[] ans) {
		// TODO Auto-generated method stub
		//进制转换
	String str=_10_to_N(j, k);
	System.out.println(str);
		
	}
	private static char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();
    private static String numStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	  public static String _10_to_N(long number, int N) {
	        Long rest = number;
	        Stack<Character> stack = new Stack<Character>();
	        StringBuilder result = new StringBuilder(0);
	        while (rest != 0) {
	            stack.add(array[new Long((rest % N)).intValue()]);
	            rest = rest / N;
	        }
	        for (; !stack.isEmpty();) {
	            result.append(stack.pop());
	        }
	        return result.length() == 0 ? "0":result.toString();

	    }
}
