package Offer28_3;

import java.util.Arrays;

/**
 * Title: 八皇后问题(全排列的应用,规则约束)
 * Description:8*8的棋盘摆放8个皇后，并且任意两个皇后不能在同一列，同一行或者同一对角线上
 *
 * 核心思想：全排列的应用，列举出所有可能性，再用具体条件逐一验证，剔除不满足条件的结果
 * 
 * @author rico
 * @created 2017年6月20日 上午8:03:39
 */
public class Solution {
	static int count = 0;

	/**
	 * @description 八皇后问题
	 * @author rico
	 * @created 2017年6月20日 上午8:25:48
	 * @param target target[i] = j, 表示第i行第j列存在皇后(这种表示方法下，皇后绝对不会在同一行/列中)
	 * @param from
	 * @param to
	 */
	public static void eightQueen(int[] target, int from, int to) {
		if (from == to) { // 递归终止条件,简单情景下的处理
			boolean flag = true;
			for (int i = 0; i < target.length; i++) {
				if (!flag)
					break; // 跳出第一层循环
				for (int j = i + 1; j < target.length; j++) {
					// (i - j)表示两个皇后所在行的差，(target[i] - target[j])表示这两个皇后所在列的差
					// 若二者相等或者互为相反数，那么这两个皇后就在同一条对角线上
					if (((i - j) == (target[i] - target[j]))
							|| ((j - i) == (target[i] - target[j]))) {
						flag = false; // 用于跳出第一层循环
						break; // 跳出当前循环
					}
				}
			}
			// flag为true,表示当前序列满足条件，进行打印
			if (flag) {
				System.out.println("第 " + ++count + "种 ： "
						+ Arrays.toString(target));
			}
		} else { // 缩小规模，递归调用
			for (int i = from; i <= to; i++) {
				swap(target, from, i);
				eightQueen(target, from + 1, to);
				swap(target, from, i);
			}
		}
	}

	/**
	 * @description 交换指定两个元素
	 * @author rico
	 * @created 2017年6月19日 下午10:38:27
	 * @param target
	 * @param from
	 * @param index
	 */
	public static void swap(int[] target, int from, int index) {
		int tmp = target[from];
		target[from] = target[index];
		target[index] = tmp;
	}

	public static void main(String[] args) {
		int[] target = { 0, 1, 2, 3, 4, 5, 6, 7 };
		eightQueen(target, 0, 7);
	}
}
