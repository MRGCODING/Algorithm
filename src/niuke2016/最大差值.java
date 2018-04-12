package niuke2016;

public class 最大差值 {
	public int getDis(int[] A, int n) {
		int max = 0;
		for(int i =0;i<n;i++){
			for(int j = i + 1;j < n;j++){
				if(A[j] - A[i] > max)
					max = A[j] - A[i];
			}
		}
		return max;
	}
}
