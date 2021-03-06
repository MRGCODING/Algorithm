package worktime19;

public class 斐波那契 {
	public int Fibonacci(int n) {
		if(n<=1){
		    return n;
		}
		int[] record = new int[n+1];
		record[0] = 0;
		record[1] = 1;
		for(int i=2;i<=n;i++){
		    record[i] = record[i-1] + record[i-2];//StackOverFlow
		}
		return record[n];
	}
}
