package 剑指Offer;

public class 整数中1出现的次数 {
	public int NumberOf1Between1AndN_Solution(int n) {
		int res = 0,temp = 0;
		for(int i = 1;i <=n;i++){
			temp = helper(i);
			res += temp;
		}
	    return res;
    }

	private int helper(int n) {
		int res = 0;
		while(n != 0){
			int temp = n % 10;
			if(temp == 1)
				res++;
			n /=10;
		}
		return res;
	}
}
