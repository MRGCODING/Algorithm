package concurrent.model;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class Main1 {
	public static void main(String[] args) {
		ReferenceQueue<String> queue = new ReferenceQueue<String>();
		PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
		SoftReference<String> p = new SoftReference<String>(new String("a"));
		System.out.println(p.get());
		System.out.println(pr.get());
	}
}
