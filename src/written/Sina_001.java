package written;

import java.util.Scanner;

/**
 * 设三个余数分别为abc则原来那个数为70a+21b+15c-105n.其中n的取值应该使最后的结果大于零小于105. 追问：
 * 我用具体数字算了，貌似可以，可以说一下依据嘛？…… 追答：
 * ‘今有物不知其数，三三数之剩二，五五数之剩三，七七数之剩二，问物几何？’我知道这是二十三，不过那是硬凑出来的，要列一个每数皆可通用的算式，却是想破了脑袋也想不出。”
 * 黄蓉笑道：“这容易得紧。以三三数之，余数乘以七十；五五数之，余数乘以二十一；七七数之，余数乘十五。三者相加，如不大于一百零五，即为答数；否则须减去一百零五或其倍数。”瑛姑在心中盘算了一遍，果然丝毫不错，低声记诵道：“三三数之，余数乘以七十；五五数之……”黄蓉道：“也不用这般硬记，我念一首诗给你听，那就容易记了：三人同行七十稀，五树梅花廿一枝，七子团圆正半月，余百零五便得知。”
 * 
 * @author miaoyumiao_i
 *
 */
//fail 50%
public class Sina_001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		if (x + y + z == 0) {
			System.out.println(3 * 5 * 7);
			return;
		}

		int ans = x * 35 + y * 21 + z * 15;
		ans %= 105;
		if (ans == 0)
			System.out.println("fail");
		else {
			System.out.println(ans);
		}
	}
}
