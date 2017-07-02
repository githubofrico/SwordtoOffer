package NDice43;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: n 个骰子的点数(迭代解法)
 * Description: 把n个骰子扔在地上，所有骰子朝上的一面点数之和记为s.
 * 输入n,打印出s的所有可能的值出现的概率。
 * 
 * 求骰子个数为k时和为i的频数时,实质上是骰子个数为k-1时，和为i-1,i-2,...,i-6的频数的和
 * 
 * @author rico
 * @created 2017年6月29日 下午2:54:34
 */
public class Solution1 {

	public static Map<Integer, Integer> printProbability(int number) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (number < 1)
			return map;
		int g_maxValue = 6;
		int[][] probabilities = new int[2][];
		probabilities[0] = new int[g_maxValue * number + 1];
		probabilities[1] = new int[g_maxValue * number + 1];
		int flag = 0;
		
		// 只有一个骰子的情形
		for (int i = 1; i <= g_maxValue; i++)
			probabilities[0][i] = 1;
		
		for (int k = 2; k <= number; ++k) {
			// k个骰子点数和最小为k,因此数组的前k个位置初始化为0
			for (int i = 0; i < k; ++i)
				probabilities[1 - flag][i] = 0;

			// 从最小和k起,在骰子个数为k-1时的和的分布的基础上，依次计算在骰子个数为k时的和值的分布
			for (int i = k; i <= g_maxValue * k; ++i) {
				probabilities[1 - flag][i] = 0; // 先初始化为0
				// 求骰子个数为k时和为i的频数时,实质上是骰子个数为k-1时，和为i-1,i-2,...,i-6的频数的和
				for (int j = 1; j <= i && j <= g_maxValue; ++j)
					probabilities[1 - flag][i] += probabilities[flag][i - j];
			}
			flag = 1 - flag;
		}
		
		
		for (int i = number; i <= g_maxValue * number; i++) {
			map.put(i, probabilities[flag][i]);
		}
		return map;
	}

	public static void main(String[] args) {
		int n = 3;
		Map<Integer, Integer> map = Solution1.printProbability(n);
		int s = 0;
		for (int tmp : map.values()) {
			s += tmp;
		}
		System.out.println(s);
		System.out.println(map);
	}
}
