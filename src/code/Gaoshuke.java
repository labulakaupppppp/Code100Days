package code;

import java.util.Scanner;

public class Gaoshuke {
public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
     int n = scanner.nextInt();
     int k = scanner.nextInt();
     int[] weight = new int[n];
     boolean[] q = new boolean[n];
     for (int i = 0; i < n; i++) {
         weight[i] = scanner.nextInt();
     }
     for (int i = 0; i < n; i++) {
         q[i] = scanner.nextInt() == 1 ? true : false;
     }
     boolean qingxing = true;
     int slow = 0;
     int high = 0;
     int max = 0;
     int currentmax = 0;
     int currentslow = 0;
     int currIndex = 0;
     int zSum = 0;
     for (int i = 0; i < n; i++) {
         if (currIndex < k) {
             currentmax += weight[i];
             currIndex++;
             if (q[i]) {
                 zSum += weight[i];
             }
         } else {
             currIndex--;
             currentmax -= weight[i - k];
             if(q[i-k]){
                 zSum-=weight[i-k];
             }

         }
         if (currentmax - zSum > max) {
             max = currentmax - zSum;
         }

     }

     for (int i = 0; i < n; i++) {
         if (!q[i]) continue;
         max += weight[i];
     }
     // System.out.print(s);
     //s += max;
     System.out.println(max);
}
}
