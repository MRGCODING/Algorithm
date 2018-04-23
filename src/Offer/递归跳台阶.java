package Offer;

public class 递归跳台阶 {
	public int JumpFloor(int target) {
		if (target <= 0)
			return -1;
		else if (target == 1)
			return 1;
		else if (target == 2)
			return 2;
		else
			return JumpFloor(target - 1) + JumpFloor(target - 2);
	}

	// 预备之斐波那契数列
	public int Fibonacci(int n) {
			if(n<=1){
			    return n;
			}
			int[] record = new int[n+1];
			record[0] = 0;
			record[1] = 1;
			for(int i=2;i<=n;i++){
			    record[i] = record[i-1] + record[i-2];
			}
			return record[n];
	}
}
