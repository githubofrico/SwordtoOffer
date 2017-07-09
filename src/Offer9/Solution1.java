package Offer9;

/**
 * Title: 跳台阶(斐波那契数列的应用),优化算法
 * Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author rico
 * @created 2017年6月4日 下午3:45:34
 */
public class Solution1 {

	public int JumpFloor(int target) {
		return JumpFloor(target, 1, 2);
	}

	/**
	 * @description 青蛙跳上一个n级台阶的跳法总数 = 青蛙跳上一个n-1级台阶的跳法总数 + 青蛙跳上一个n-2级台阶的跳法总数
	 * @author rico
	 * @created 2017年6月4日 下午3:47:34
	 * @param target
	 * @param first
	 * @param second
	 * @return
	 */
	public int JumpFloor(int target, int first, int second) {
		if (target == 1) {
			return 1;
		} else if (target == 2) {
			return 2;
		} else if (target == 3) {
			return first + second;
		}
		return JumpFloor(--target, second, first + second);
	}

	public static void main(String[] args) {
		System.out.println(new Solution1().JumpFloor(10));
	}
}
