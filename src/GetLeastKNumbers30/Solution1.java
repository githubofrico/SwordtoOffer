package GetLeastKNumbers30;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Title: 最小的K个数 
 * Description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。
 * 
 * @author rico
 * @created 2017年6月2日 下午9:17:15
 */
public class Solution1 {

	/**
	 * @description 最小的K个元素一定是存在的，因为排序后前K个就满足条件。 划分的大了，end = index - 1，缩小；
	 *              划分的小了， start = index + 1， 扩大； 直到恰好划分完成。
	 * @author rico
	 * @created 2017年6月3日 上午8:38:04
	 * @param input
	 *            输入数组
	 * @param k
	 *            最小K个数
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (input != null && k > 0 && k <= input.length) {
			int start = 0;
			int end = input.length - 1;
			int index = partition(input, start, end);
			while (index != k - 1) { // 循环终止条件：划分的正好
			// System.out.println(Arrays.toString(input));
				if (index > k - 1) { // 划得大了
					end = index - 1;
					index = partition(input, start, end);
				} else { // 划得小了
					start = index + 1;
					index = partition(input, index + 1, end);
				}
			}

			for (int i = 0; i < k; i++) {
				list.add(input[i]);
			}
		}
		return list;
	}

	/**
	 * @description 快排的划分算法,时间复杂度O(n)
	 * @author rico
	 * @created 2017年6月3日 上午8:17:54
	 * @param input
	 * @param start
	 * @param end
	 * @return
	 */
	public int partition(int[] input, int start, int end) {
		int base = input[start];
		int base_index = start;
		for (int i = 1 + start; i <= end; i++) {
			if (input[i] < base) {
				base_index++;
				if (base_index != i) {
					int temp = input[base_index];
					input[base_index] = input[i];
					input[i] = temp;
				}
			}
		}
		input[start] = input[base_index];
		input[base_index] = base;
		return base_index;
	}

	public static void main(String[] args) {
		// int[] input = { 4, 5, 3, 6, 2, 7, 1, 8 };
		int[] input = { 1, 5, 4, 4, 4 };
		// int[] input = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(new Solution1().GetLeastNumbers_Solution(input, 3));
	}
}
