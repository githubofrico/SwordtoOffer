package Offer9;

/**
 * Title: 跳台阶 
 * Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author rico
 * @created 2017年6月4日 下午3:45:34
 */
public class Solution {
	public int JumpFloor(int target) {
		if (target > 0) {
			if (target == 1) {
				return 1;
			} else if (target == 2) {
				return 2;
			}
			// 青蛙跳上一个n级台阶的跳法总数 = 青蛙跳上一个n-1级台阶的跳法总数 + 青蛙跳上一个n-2级台阶的跳法总数
			return JumpFloor(target - 1) + JumpFloor(target - 2);
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().JumpFloor(0));
	}
}
