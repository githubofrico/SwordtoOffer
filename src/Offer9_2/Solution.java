package Offer9_2;

/**
 * Title: 变态跳台阶(数学归纳法)
 * Description:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author rico
 * @created 2017年6月4日 下午3:45:34
 */
public class Solution {
	public int JumpFloorII(int target) {
		if (target > 0) {
			if (target == 1) {
				return 1;
			}
			if (target > 1) {
				return 2*JumpFloorII(target-1);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().JumpFloorII(4));
	}
}
