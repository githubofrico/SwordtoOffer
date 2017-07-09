package Offer43;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: n 个骰子的点数(递归解法)
 * Description: 把n个骰子扔在地上，所有骰子朝上的一面点数之和记为s.
 * 输入n,打印出s的所有可能的值出现的概率。
 * 
 * 把n个骰子分为两堆，一堆只有一个骰子，另一堆共n-1个骰子。其中，第一堆中唯一的骰子出现的点数可以是1~6，剩下的第二堆中的所有骰子的点数和为(n-6)~
 * (n-1),依次类推
 * 
 * @author rico
 * @created 2017年6月29日 下午2:54:34
 */
public class Solution {

	Map<Integer, Double> map = new HashMap<Integer, Double>();

	public static Map<Integer, Integer> caculate(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (n > 0) {
			int min = n;
			int max = 6 * n;
			int mid = (min + max) / 2;
			for (int i = min, j = max; i <= mid; i++, j--) { // 点数之和出现的频数是对称的
				int num = count(n, i);
				map.put(i, num);
				map.put(j, num);
			}
		}
		return map;
	}

	/**
	 * @description 计算n个骰子点数和为sum的总数
	 *              算法：把n个骰子分为两堆，一堆只有一个骰子，另一堆共n-1个骰子。其中，第一堆中唯一的骰子出现的点数可以是1~6，
	 *              剩下的第二堆中的所有骰子的点数和为(n-6)~(n-1),依次类推。
	 * @author rico
	 * @param n
	 * @param sum
	 */
	public static int count(int n, int sum) {
		int result = 0;
		if (n == 1) { // 递归终止条件
			// 简单情景下的处理
			if (sum > 6 || sum < 1) {
				return result;
			} else {
				result = 1;
				return result;
			}
		} else { // 缩小规模，递归解决
			for (int i = 1; i <= 6; i++) {
				result += count(n - 1, sum - i);
			}
			return result;
		}
	}

	public static void main(String[] args) {
		int n = 3;
		int sum = 7;
		System.out.println(Solution.count(n, sum));
		Map<Integer, Integer> map = Solution.caculate(n);
		int s = 0;
		for (int tmp : map.values()) {
			s += tmp;
		}
		System.out.println(s);
		System.out.println(map);
	}
}
