package Fibonacci_JumpFloor9;

/**
 * Title: 跳台阶 Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author rico
 * @created 2017年6月4日 下午3:45:34
 */
public class Solution2 {

	// 跳法总数
	int count = 0;
	
	public int JumpFloor(int target) {
		
		if (target > 0) {
			JumpFloor(target - 1);  // 可以一步跳
			JumpFloor(target - 2);  // 也可以两步跳
		}
		if (target == 0) {  // 青蛙成功跳上一个n级的台阶,跳法总数加1
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution2().JumpFloor(10));
	}
}
