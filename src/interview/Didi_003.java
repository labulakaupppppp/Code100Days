package interview;

public class Didi_003 {
//判断回文序列
	public static boolean isH(String str) {
		if(str==null || str.length()==0 || str.length()==1) {
			return true;
		}
		int low=0;
		int high=str.length()-1;
		while(low<=high) {
			if(str.charAt(low)==str.charAt(high)) {
				low++;
				high--;
			}else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String str="abaa";
		boolean ans=isH(str);
		System.out.println(ans);
	}
}
