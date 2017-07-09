package Offer67;

/**
 * Title:机器人的运动范围 Description:
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格
 * ，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 =
 * 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * @author rico
 * @created 2017年7月9日 下午12:11:09
 */
public class Solution {

	public int movingCount(int threshold, int rows, int cols) {
		if (rows < 0 || cols < 0 || threshold < 0) {   // 边界条件
			return 0;
		} else {    
			boolean[] matrix = new boolean[rows * cols];  // 记录机器人是否进过每个方格
			return movingCountCore(matrix, rows, cols, 0, 0, threshold);   // 从位置(0,0)开始
		}
	}

	/**     
	 * @description 递归算法
	 * @author rico       
	 * @created 2017年7月9日 下午7:34:45     
	 * @param matrix 机器人的运动矩阵
	 * @param rows 矩阵行数
	 * @param cols 矩阵列数
	 * @param i 机器人当前所在行
	 * @param j 机器人当前所在列
	 * @param threshold 阈值
	 * @return     
	 */
	public int movingCountCore(boolean[] matrix, int rows, int cols, int i, int j,
			int threshold) {
		if (!iscontinue(rows, cols, i, j, matrix, threshold)) {  // 递归终止条件
			return 0;   // 简单情境下的处理
		} else {
			int k = i;
			int m = j;
			System.out.println("K : " + k + ", M : " + m);
			matrix[k * cols + m] = true;

			int result1 = 0;
			int result2 = 0;
			int result3 = 0;
			int result4 = 0;

			// 向右
			if (m + 1 < cols && !matrix[k * cols + m + 1]
					&& count(k) + count(m + 1) <= threshold) {
				result1 = movingCountCore(matrix, rows, cols, k, m + 1, threshold);
			}

			// 向下
			if (k + 1 < rows && !matrix[k * cols + m + cols]
					&& count(k + 1) + count(m) <= threshold) {
				result2 = movingCountCore(matrix, rows, cols, k + 1, m, threshold);
			}

			// 向左
			if (m - 1 >= 0 && !matrix[k * cols + m - 1]
					&& count(k) + count(m - 1) <= threshold) {
				result3 = movingCountCore(matrix, rows, cols, k, m - 1, threshold);
			}

			// 向上
			if (k - 1 >= 0 && !matrix[k * cols + m - cols]
					&& count(k - 1) + count(m) <= threshold) {
				result4 = movingCountCore(matrix, rows, cols, k - 1, m, threshold);
			}
			return 1 + result1 + result2 + result3 + result4;
		}
	}

	/**
	 * @description 十进制各位数的和
	 * @author rico
	 */
	public int count(int i) {
		int result = 0;
		do {
			result += i % 10;
			i = i / 10;
		} while (i != 0);
		return result;
	}

	/**
	 * @description 判断机器人在当前位置是否可移动
	 * @author rico
	 */
	public boolean iscontinue(int rows, int cols, int k, int m, boolean[] flag,
			int threshold) {
		int sum = count(k) + count(m);
		boolean flag1 = m < cols && !flag[k * cols + m] && sum <= threshold;
		boolean flag2 = k < rows && !flag[k * cols + m] && sum <= threshold;
		boolean flag3 = m >= 0 && !flag[k * cols + m] && sum <= threshold;
		boolean flag4 = k >= 0 && !flag[k * cols + m] && sum <= threshold;
		return flag1 || flag2 || flag3 || flag4;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int threshold = 3;
		int rows = 3;
		int cols = 2;
		// System.out.println(s.count(0, 1));
		System.out.println(s.movingCount(threshold, rows, cols));
	}
}
