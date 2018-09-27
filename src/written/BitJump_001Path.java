package written;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BitJump_001Path {
//toutiao 
	public static void main(String[] args) {
		List<String> v = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		int i = 0;
		while (i < path.length() - 1) {
			while (path.charAt(i) == '/' && i < path.length())
				++i;
			if (i == path.length())
				break;
			int start = i;
			while (path.charAt(i) != '/' && i < path.length())
				++i;
			int end = i - 1;
			String s = path.substring(start, end -  1);
			if (s == "..") {
				int temp = v.size();
				if (!v.isEmpty())
					v.remove(temp );
			} else if (s != ".") {
				v.add(s);
			}
		}
		if (v.isEmpty()) {
			System.out.println("/");
		}
		String res = "";
		for (int kk = 0; kk < v.size(); ++kk) {
			res += '/';
			res += v.get(kk);
		}
		System.out.println(res);
	}

}
