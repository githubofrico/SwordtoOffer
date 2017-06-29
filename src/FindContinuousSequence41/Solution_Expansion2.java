package FindContinuousSequence41;

import java.util.ArrayList;

/**
 * Title:和为S的序对 (双指针法) 
 * Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * @author rico
 * @created 2017年6月28日 下午8:18:42
 */

public class Solution_Expansion2 {
	public ArrayList<Integer> FindPairs(int[] arr, int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (arr != null && arr.length < 2) {
			return result;
		} else {
			int p1 = 0; // 首指针
			int p2 = arr.length - 1; // 尾指针
			int cursum;
			while (p1 < p2) {
				cursum = arr[p1] + arr[p2];
				if (cursum == sum) { // cursum == sum 成立时, 首尾指针继续合拢
					result.add(arr[p1]);
					result.add(arr[p2]);
					return result;
				} else if (cursum < sum) { // cursum < sum 成立时，首指针右移
					p1++;
				} else { // cursum > sum 成立时，尾指针左移
					p2--;
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution_Expansion2 s = new Solution_Expansion2();
		int[] arr = { 1, 3, 4, 4, 7, 11, 12, 15 };
		int sum = 15;
		System.out.println(s.FindPairs(arr, sum));
	}
}
