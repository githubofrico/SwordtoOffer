package Offer65;

import java.util.ArrayList;

/**
 * Title:滑动窗口的最大值
 * Description:给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,
 * 2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * 
 * @author rico
 * @created 2017年7月9日 上午11:34:37
 */
public class Solution {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (num == null || num.length == 0 || size < 1 || size > num.length) {
			return result;
		} else {
			int from = 0; // 窗口边界
			int to = size - 1; // 窗口边界
			int tmp = Integer.MAX_VALUE;
			for (int i = to; i < num.length; i++) {
				// 获取窗口内的最大值
				if (tmp != Integer.MAX_VALUE) {
					if (num[i] > tmp) {
						tmp = num[i];
					} else if (tmp == num[from - 1]) {
						tmp = getMax(num, from, i);
					}
					from ++;  // 不可忽略
				} else {
					tmp = getMax(num, from++, i);
				}
				result.add(tmp);
			}
		}
		return result;
	}

	/**
	 * @description 获取最大数/最小数算法、第K大数的算法复杂度均为O(n)
	 * @author rico
	 */
	public int getMax(int[] num, int from, int to) {
		int max = num[from];
		for (int i = from + 1; i <= to; i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		return max;
	}
}
