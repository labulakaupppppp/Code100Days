package interview;

//滴滴一面
//两个万位数字计算
public class Didi_001 {
	public static void sum(String num1, String num2) {
		int len1 = num1.length() - 1;
		int len2 = num2.length() - 1;
		//System.out.println("len1:" + len1 + ",len2:" + len2);
		int[] n1 = new int[len1 + 1];
		int[] n2 = new int[len2 + 1];
		for (int i = 0; i <= len1; i++) {
			n1[i] = Integer.parseInt(String.valueOf(num1.charAt(i)));
			//System.out.println("n1:" + n1[i]);
		}
		for (int i = 0; i <= len2; i++) {
			n2[i] = Integer.parseInt(String.valueOf(num2.charAt(i)));
			//System.out.println("n2:" + n2[i]);
		}
		int max = Math.max(len1, len2);// 3
		int f_len = max + 1;// 4
		int[] sum = new int[f_len + 1];// len=5
		int tag = 0;
		int i, j;
		for (i = len1, j = len2; i >= 0 && j >= 0; j--, i--) {
			sum[f_len]=(n1[i] + n2[j]+tag)%10;
			//System.out.print("sum[" + f_len + "]" + sum[f_len]);
			//System.out.println( " n1:" + n1[i] + " n2:" + n2[j]);
			tag=(n1[i] + n2[j]+tag)/10;
			//System.out.println("进位"+tag);
			f_len--;
		}
		
		
		while (i >= 0) {
			//System.out.println("i"+i);
			sum[f_len] = (sum[f_len]+n1[i]+tag)%10;
			tag=(sum[f_len]+n1[i]+tag)/10;
			i--;f_len--;
		}
		while (j >= 0) {
			sum[f_len] = (sum[f_len]+n2[j]+tag)%10;
			tag=(sum[f_len]+n2[j]+tag)/10;
			j--;f_len--;
			
		}
		String ans = "";
		int count = 0;
		if(tag!=0) {
			sum[f_len]=tag;
		}
		while (sum[count] == 0) {

			if (sum[count] != 0)

				break;
			count++;
		}
		//System.out.println("count"+count);
		for (int k = count; k < sum.length; k++) {
			ans += sum[k];
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		String str1="1273";
		String str2="2447";//3720
		sum(str1,str2);
		String str11="999";
		String str21="999";//1998
		sum(str11,str21);
		String str12 = "5";
		String str22 = "997";//1002
		sum(str12, str22);

	}

}
