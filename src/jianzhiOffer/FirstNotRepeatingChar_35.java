package jianzhiOffer;

import java.util.HashMap;

public class FirstNotRepeatingChar_35 {

	public static int getfirstNoRepeatChar(String str) {
		int ans =-1;
		if(str==null || str.length()<=0)
			return -1;
		int temp;
		char c;
		HashMap<Character,Integer> map = new HashMap<>();
		//第一次遍历str，统计每个字符出现的次数
		for(int i=0;i<str.length();i++) {
			c= str.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}else {
				temp=map.get(c);
				map.put(c, temp+1);
			}
		}
		
		//再次遍历str，如果map中出现的次数是1则是第一个只出现一次的字符
		for(int i=0;i<str.length();i++) {
			char cc=str.charAt(i);
			if(map.get(cc)==1){
				return i;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String str="123452345610";
		System.out.println(getfirstNoRepeatChar(str));
	}
}
