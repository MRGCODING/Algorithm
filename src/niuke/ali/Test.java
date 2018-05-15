package niuke.ali;

public class Test {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 1000;i < 2000;i++){
			if(new StringBuffer(i).charAt(0) == '0')count++;
		}
		System.out.println(count);
	}
}
