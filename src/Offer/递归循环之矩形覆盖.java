package Offer;

public class 递归循环之矩形覆盖 {
	public int RectCover(int target) {
		if(target <= 3)
			return target;
		return RectCover(target - 1) + RectCover(target - 2);
    }
}
