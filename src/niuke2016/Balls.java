package niuke2016;

public class Balls {
    public int calcDistance(int A, int B, int C, int D) {
    	int res = 0;
    	while(A>1){
    		res += A / 2;
    	}
    	while(B>1){
    		res += B / 2;
    	}
    	while(C>1){
    		res += C / 2;
    	}
    	while(D>1){
    		res += D / 2;
    	}
    	return res;
    }
}