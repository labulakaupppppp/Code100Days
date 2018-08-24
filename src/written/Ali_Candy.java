package written;

import java.util.*;

public class Ali_Candy {
	/**
	 * 现在很多家长都会送小孩子去培训中心学习舞蹈，有一次舞蹈培训中心考试，
	 * 因为小孩子要哄着才能更喜欢学，所以老师给孩子们准备了小贴纸奖励孩子，
	 * 考试结束以后孩子们按照大小个站成一排，老师按照顺序给孩子们发小贴纸，
	 * 每个孩子都会至少得到一个小贴纸，因为是按照大小个站成一排的，
	 * 所以相邻的孩子成绩略有高低，为了鼓励相邻孩子向成绩好的孩子学习，
	 * 成绩高的孩子会比成绩弱的孩子得到的小贴纸多，请问需要多少小贴纸发给孩子们？
	 * @return
	 */

	public static int candy() {
		Scanner sc = new Scanner(System.in);
		String ans=sc.nextLine();
		String[] kid=ans.split(",");
		//System.out.println(kid[0]);
		int[] kids=new int[kid.length];
		for(int i=0;i<kid.length;i++) {
			kids[i]=Integer.parseInt(kid[i]);
		}
		
		if (kids == null || kids.length == 0)
			return 0;
		int len = kids.length;
		int num = 0;
		int[] candy = new int[len];
		Arrays.fill(candy, 1);// 把candy的元素初始化为1；
		for (int i = 0; i < len; i++) {
			if (i != len - 1 && kids[i] > kids[i + 1] && candy[i] <= candy[i + 1]) {
				candy[i] = candy[i + 1] + 1;
			}
			if (i > 0 && kids[i] > kids[i - 1] && candy[i] <= candy[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			}
		}
		for (int i = 0; i < len; i++)
			num += candy[i];
		System.out.println(num);
		return num;
	}
	public static void main(String[] args) {
		int[] k = {2,4,5,2,3};
		candy();
	}
}
