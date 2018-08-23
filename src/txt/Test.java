package txt;

import java.util.ArrayList;

public class Test {
	/**泛型的 类型擦除
	 * ArrayList<String>还是ArrayList<Integer>，到了运行期间，JVM统统视为ArrayList<Object>
	 * 由于运行时期类型信息已经被擦除，JVM实际上根本就不知道new ArrayList<String>()和new
	 * ArrayList<Integer>()的区别
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Class c1 = new ArrayList<String>().getClass();
		Class c2 = new ArrayList<Integer>().getClass();
		System.out.println(c1 == c2); // true

	}
}
