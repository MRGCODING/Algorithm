package test;

public class KillMyself {
	public static void main(String[] args) {
		while (true) {
			new Thread() {
				public void run() {
					while (true) {

					}
				}
			}.start();
		}
	}
}
