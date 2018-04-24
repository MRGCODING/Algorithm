package Lock;

public class ABAB {
	class A implements Runnable{
		@Override
		public void run() {
			System.out.println("A");
		}
	}
	
	class B implements Runnable{
		@Override
		public void run() {
			System.out.println("B");
		}
	}
	public static void main(String[] args) {
		
	}
}
