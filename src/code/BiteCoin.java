package code;

import java.util.Scanner;

public class BiteCoin {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int[] arr = new int[11111];
        int count=0;
        while (sc.hasNextInt()) {//注意while处理多个case
            arr[count++]=sc.nextInt();
        }
        int ans=0;
        int mi=arr[0];
        for (int i = 0; i < count; i++) {
        	ans = Math.max(ans, arr[i] - mi);
        	mi = Math.min(mi, arr[i]);
        }

        System.out.println(ans);
    }

}
