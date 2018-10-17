package interview;

//滴滴一面
//两个万位数字计算
public class Didi_001 {
	public static void sum(String num1, String num2) {
		int len1 = num1.length() - 1;
		int len2 = num2.length() - 1;
		System.out.println("len1:" + len1 + ",len2:" + len2);
		int[] n1 = new int[len1 + 1];
		int[] n2 = new int[len2 + 1];
		for (int i = 0; i <= len1; i++) {
			n1[i] = Integer.parseInt(String.valueOf(num1.charAt(i)));
			System.out.println("n1:" + n1[i]);
		}
		for (int i = 0; i <= len2; i++) {
			n2[i] = Integer.parseInt(String.valueOf(num2.charAt(i)));
			System.out.println("n2:" + n2[i]);
		}
		int max = Math.max(len1, len2);// 3
		int f_len = max + 1;// 4
		int[] sum = new int[f_len + 1];// len=5
		int tag = 0;
		int i, j;
		for (i = len1, j = len2; i >= 0 && j >= 0; j--, i--) {
			if (tag != 0) {
				sum[f_len]++;
				System.out.println("sum[" + f_len + "]" + sum[f_len]);
				tag = 0;
			}
			int tmp = n1[i] + n2[j];
			System.out.println("tmp:" + tmp + " n1:" + n1[i] + " n2:" + n2[j]);
			if (tmp >= 10) {
				tmp = tmp - 10;
				tag = 1;
				System.out.println("进位");
			}
			sum[f_len--] += tmp;
		}
		if (tag != 0) {
			sum[f_len]++;
		}
		
		while (i >= 0) {
			sum[f_len] += n1[i];
			if(sum[f_len]>=10) {
				sum[f_len]=sum[f_len]-10;
				sum[f_len--]++;
			}
			i--;
		}
		while (j >= 0) {
			sum[f_len] += n2[j--];
			
			if(sum[f_len]>=10) {
				sum[f_len]=sum[f_len]-10;
				sum[f_len--]++;
			}
			
		}
		String ans = "";
		int count = 0;
		while (sum[count] == 0) {

			if (sum[count] != 0)

				break;
			count++;
		}
		for (int k = count; k < sum.length; k++) {
			ans += sum[k];
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
//		String str1="1273";
//		String str2="2447";
//		sum(str1,str2);
//		String str11="999";
//		String str21="999";
//		sum(str11,str21);
		String str1 = "5";
		String str2 = "997";
		sum(str1, str2);

	}

}
