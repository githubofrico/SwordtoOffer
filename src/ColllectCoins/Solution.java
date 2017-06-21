package ColllectCoins;

/**
 * Title: 凑硬币问题(动态规划) Description: 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够n元？
 * 
 * 动态规划算法通常基于一个递推公式及一个或多个初始状态。当前子问题的解将由上一次子问题的解推出。使用动态规划来解题只需要多项式时间复杂度，因此它比回溯法、
 * 暴力法等要快许多。
 * 
 * 状态转移方程： d(i) = min{ d(i-vj)+ 1 }，其中i-vj >=0，vj表示第j个硬币的面值
 * 
 * @author rico
 * @created 2017年6月20日 下午5:18:28
 */
public class Solution {

	public int calculateCoins(int target, int[] coins) {

		// 从状态0~状态target,共 (target+1)个状态
		int[] dp = new int[target + 1];
		dp[0] = 0;   // 初始状态
		for (int i = 1; i < dp.length; i++) {  // 各状态的初始化
			dp[i] = Integer.MAX_VALUE;
		}

		// 利用递推公式计算各状态下的取值
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j] && dp[i - coins[j]] + 1 < dp[i]) {
					dp[i] = dp[i - coins[j]] + 1;
				}
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 3, 5 };
		System.out.println(new Solution().calculateCoins(11, coins));
	}
}
