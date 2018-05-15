package niueke.招商银行;

import java.util.Scanner;

public class 人数抽取 {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int K = scanner.nextInt();
		int[] person = new int[N];
		if (K <= 0 || N <= 0 || M <= 0 || K > N) {
			System.out.println(0);
			return;
		}
		for (int i = 0; i < M; i++) {
			Add(person, K - 1);
		}
		System.out.println(person[K - 1]);
	}

	private static void Add(int[] person, int k) {
		if (k - 1 >= 0 && person[k] > person[k - 1]) {
			Add(person, k - 1);
		} else if (k + 1 < person.length && person[k] > person[k + 1]) {
			Add(person, k + 1);
		} else {
			person[k]++;
		}
	}
}
