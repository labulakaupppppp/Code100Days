package interview;

public class Didi_02 {
//青蛙跳台阶
	public static int  jump(int n) {
		if(n==1 || n==2) return n;
		return jump(n-1)+jump(n-2);
	}
	public static void main(String[] args) {
		int n=4;
		System.out.println(jump(n));
	}
}
