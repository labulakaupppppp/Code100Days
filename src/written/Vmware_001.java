package written;


import java.util.Scanner;
/*
 * n为点数
 * 分别输出线数 、与三角形数量
 */
public class Vmware_001 {
	//pass
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print((n-2)*3+" ");
		System.out.println((n-3)*3+1);	
	}

}
