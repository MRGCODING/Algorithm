package JVM;

/**
 * 在 1.7 之前：该方法会去通过 equals() 方法判断，如果字符串常量池中已经有了等于该 String
 * 对象的字符串，则直接返回常量池中的地址引用，没有，则会 copy 字符串到常量池，并返回常量池中的地址引用。 从 1.7 开始：intern()
 * 方法会首先去字符串常量池中查询是否存在，如果存在，则直接返回常量池中的地址引用。但是，如果在常量池中找不到，则不会再将字符串 copy
 * 到常量池，而会在常量池中生成一个对堆中原字符串的引用。
 * 
 * 以 JDK1.6 运行如上代码，会得到 false、false 的结果。那我们就先来分析下 JDK1.6 时上面的代码都做了些什么。 由于在 JDK1.7
 * 之前，字符串常量池是放在方法区当中的，所以 s1.intern() 返回的是方法区常量池中的引用地址，而 s1 则是 Java 堆当中的地址。所以结果为
 * false。s2 结果同上。 https://blog.csdn.net/Airsaid/article/details/50723968
 * 
 * @author Lenovo
 *
 */
public class InternTest {
	public static void main(String[] args) {
		test();
	}

	static void test() {
		String s1 = new StringBuilder("Air").append("said").toString();
		System.out.println(s1.intern() == s1);// 在 JDK 1.6 或之前返回 false, 1.7
												// 或以后返回 true
		String s2 = new StringBuilder("ja").append("va").toString();
		System.out.println(s2.intern() == s2);// 一直返回 false
	}
}
