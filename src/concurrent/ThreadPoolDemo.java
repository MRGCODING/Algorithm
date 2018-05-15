package concurrent;

import java.util.concurrent.ExecutorService;

/**
 * https://blog.csdn.net/zhou_shaowei/article/details/54562177
 * @author Lenovo
 *
 */
public class ThreadPoolDemo {  
	  
    public static void main(String[] args) {  
        // 1.创建线程池  
//      1.创建60s的线程池  
//        ExecutorService threadPool = Executors.newCachedThreadPool();  
//      2.创建一个固定线程数的线程池，存活时间很长  
//      ExecutorService threadPool2 = Executors.newFixedThreadPool(5);  
//      3.创建一个只有一个线程的线程池，存活时间很长  
//      ExecutorService threadPool3 = Executors.newSingleThreadExecutor();  
//      4.用封装好的单例模式ThreadPoolUtils.java来创建线程池         
      ExecutorService threadPool = ThreadPoolUtils.getThreadPool();  
          
        // 2.创建Runnable对象  
        MyRunnable task = new MyRunnable();  
          
        // 3.使用submit提交runnable实例  
        threadPool.submit(task);  
          
        // 4.关闭线程池  
        threadPool.shutdown();//一般不用关闭线程池  
          
    }  
  
}  
  
class MyRunnable implements Runnable {  
  
    @Override  
    public void run() {  
        System.out.println("shanglele");  
    }  
  
}  