package 真题;

import java.util.Scanner;

public class 重排数列 {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int count=input.nextInt();//运行次数
        String[] result=new String[count];//结果集
        for(int i=0;i<count;i++){
            int num=input.nextInt();//输入的数的多少
            int[] tmp=new int[num];
            int four_times=0;//四的倍数的数的个数
            int two_times=0;//二的倍数的数的个数
            for(int j=0;j<num;j++){
                tmp[j]=input.nextInt();
                if(tmp[j]%4==0){
                    four_times++;
                }else if(tmp[j]%2==0){
                    two_times++;
                }
            }
            /**
             * 判定条件：
             * 4的倍数可以每隔一个数放  如：1 4 1 4
             * 2的倍数必须挨着放 如：2 2 2 2
             * 因此：在将所有的2的倍数的数去掉
             *         总数：num=num-two_times+1
             */
            if(four_times*2>=num-two_times){
                result[i]="Yes";
            }else{
                result[i]="No";
            }
        }
        for(int i=0;i<count;i++){
            System.out.println(result[i]);
        }
    }
}
