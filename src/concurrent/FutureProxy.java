package concurrent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
/**
 * java.util.concurrent下主要的接口和类：
	
	Executor：具体Runnable任务的执行者。
	
	ExecutorService:一个线程池管理者，其实现类有多种，比如普通线程池，定时调度线程池ScheduledExecutorService等，我们能把一个
	
	Runnable,Callable提交到池中让其调度。
	
	Future：是与Runnable,Callable进行交互的接口，比如一个线程执行结束后取返回的结果等等，还提供了cancel终止线程。
	
	BlockingQueue：阻塞队列。
 * @author Lenovo
 *
 * @param <T>
 */
public abstract class FutureProxy<T> {

	private final class CallableImpl implements Callable<T> {

		public T call() throws Exception {
			return FutureProxy.this.createInstance();
		}
	}

	private static class InvocationHandlerImpl<T> implements InvocationHandler {

		private Future<T> future;

		private volatile T instance;

		InvocationHandlerImpl(Future<T> future) {
			this.future = future;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			synchronized (this) {
				if (this.future.isDone()) {
					this.instance = this.future.get();
				} else {
					while (!this.future.isDone()) {
						try {
							this.instance = this.future.get();
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
						}
					}
				}

				return method.invoke(this.instance, args);
			}
		}

	}

	/**
	 * 实现java.util.concurrent.ThreadFactory接口
	 * 
	 * @author chenpeng
	 *
	 */
	private static final class ThreadFactoryImpl implements ThreadFactory {

		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r);
			thread.setDaemon(true);
			return thread;
		}
	}

	private static ExecutorService service = Executors.newCachedThreadPool(new ThreadFactoryImpl());

	protected abstract T createInstance();

	protected abstract Class<? extends T> getInterface();

	/**
	 * 返回代理的实例
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final T getProxyInstance() {
		Class<? extends T> interfaceClass = this.getInterface();
		if (interfaceClass == null || !interfaceClass.isInterface()) {
			throw new IllegalStateException();
		}

		Callable<T> task = new CallableImpl();

		Future<T> future = FutureProxy.service.submit(task);

		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] { interfaceClass },
				new InvocationHandlerImpl(future));
	}
}
