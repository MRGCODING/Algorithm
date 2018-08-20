package 剑指Offer;

/**
 * 在循环遍历中将0元素全部集中起来，整体向后移位，但是由于连续的0元素都是相等的，
 * 因此就算往前移位，也只需要将最前面的0元素和连续0元素的结束位置的后一位元素进行调换，相当于整个0元素块都向后移动了一位。
 * 由于数组中可能有多个0，因此，第一次循环的时候，就将第一个0元素找出，并且记录当前0元素的游标(此时0元素开始的游标和结束的游标相等)，
 * 第二次循环的时候，直接从0元素结束的游标的后一位开始循环遍历，如果循环遍历过程中，遇到了0元素，则将0元素的结束游标+1；
 * 如果没有遇到0元素，则将0元素开始位置和当前位置的数进行置换，并且将0元素的开始游标和结束游标都+1。
 * 
 * @author Lenovo
 *
 */
public class 数组移动0 {
	static int start = 0, end = 0,flag = 0;

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
		System.out.println(start + "," + end);
	}

	// 操作数尽量少
	public static void moveZeroes(int[] nums) {
		int size = nums.length;
		int currentNum;
//		int i = 0;
		// 第一步：找到第一个0元素开始的位置
		// 并将第一个0元素的游标赋值给start&end
		for(int i = 0;i < nums.length;i++){
			if(nums[i] == 0){
				start = i;
				end = i;
				flag = i;
				break;
			}
		}
//		while (i < size) {
//			currentNum = nums[i];
//			if (currentNum == 0) {
//				start = i;
//				end = i;
//				break;
//			}
//			++i;
//		}
		// 如果当前数组中没有找到0元素，则推出
		if (nums[flag] != 0)
			return;

		// 将当前i的值加1；直接从刚才0元素位置的后一位置开始循环
		++flag;
		while (flag < size) {
			currentNum = nums[flag];
			if (currentNum == 0) {// 如果当前元素等于0，则将i值赋值给end
//				end = flag;
				end++;
			} else {
				// 如果不为0
				// 则将当前元素赋值给nums[start]
				// 并将当前位置的元素赋值为0
				// start和end都加1；
				nums[start] = currentNum;
				nums[flag] = 0;
				++start;
				++end;
			}
			++flag;
		}
	}
}
