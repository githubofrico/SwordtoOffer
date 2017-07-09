package Offer9_1;

/**
 * Title: 矩阵覆盖(数学归纳法)---斐波那契数列的应用
 * Description:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * @author rico
 * @created 2017年6月4日 下午3:45:34
 */
public class Solution {
	
	public int RectCover(int target) {
		return RectCover(target, 1, 2);
	}

	public int RectCover(int target, int first, int second) {
		if (target > 0) {
			if (target == 1) {
				return 1;
			} else if (target == 2) {
				return 2;  
			} else if (target == 3) {
				return first + second;
			}
			return RectCover(--target, second, first + second);
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().RectCover(4));
	}
}
