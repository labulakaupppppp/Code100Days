package jianzhiOffer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * @author miaoyumiao_i
 *
 */
public class Multiply {
	//抽象出一个数组，对角线均为1.
	//先计算左下半三角，在计算右上半三角
	public int[] multiply(int[] A) {
		int[] B = new int[A.length];
		B[0] = 1;
		int n = A.length;
		for (int i = 1; i < n; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		double temp = 1.0;
		for (int i = n - 2; i >= 0; i--) {
			temp *= A[i + 1];
			B[i] *= temp;
		}
		return B;
	}
}
