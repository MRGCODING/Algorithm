package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
 * 单例模式创建线程池 
 *       该模式可以保证程序中只创建一个线程池 
 */
public class ThreadPoolUtils {
	private ThreadPoolUtils() {
	}

	private static final ExecutorService threadPool = Executors.newCachedThreadPool();

	public static ExecutorService getThreadPool() {
		return threadPool;
	}
}