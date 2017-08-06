package Offer67;

import java.util.Arrays;

/**
 * Title:机器人的运动范围(机器人所有可以达到的格子的总数)
 * Description:地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格
 * ，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 =
 * 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * @author rico
 * @created 2017年7月9日 下午12:11:09
 */
public class Solution1 {

	public int movingCount(int threshold, int rows, int cols) {
		if (rows < 0 || cols < 0 || threshold < 0) { // 边界条件
			return 0;
		} else {
			boolean[] matrix = new boolean[rows * cols]; // 记录机器人是否进过每个方格
			System.out.println("矩阵初始状态 ： " + Arrays.toString(matrix));
			System.out.println("-----------------------------------");
			return movingCountCore(matrix, rows, cols, 0, 0, threshold); // 从位置(0,0)开始
		}
	}

	/**
	 * @description 递归算法
	 * @author rico
	 * @created 2017年7月9日 下午7:34:45
	 * @param matrix
	 *            机器人的运动矩阵
	 * @param rows
	 *            矩阵行数
	 * @param cols
	 *            矩阵列数
	 * @param i
	 *            机器人当前所在行
	 * @param j
	 *            机器人当前所在列
	 * @param threshold
	 *            阈值
	 * @return
	 */
	public int movingCountCore(boolean[] matrix, int rows, int cols, int i,
			int j, int threshold) {
		if (!iscontinue(matrix, rows, cols, i, j, threshold)) {     //当前位置不可达或者已到过
			return 0; 	//简单情境下的处理
		} else {
			System.out.println("I : " + i + ", J : " + j);
			matrix[i * cols + j] = true;  // 到达该格子
			System.out.println(Arrays.toString(matrix));
			System.out.println("-----------------------------------");

			int result1 = 0;
			int result2 = 0;
			int result3 = 0;
			int result4 = 0;

			// 向右能够到达的格子
			result1 = movingCountCore(matrix, rows, cols, i, j + 1, threshold);

			// 向下能够到达的格子
			result2 = movingCountCore(matrix, rows, cols, i + 1, j, threshold);

			// 向左能够到达的格子
			result3 = movingCountCore(matrix, rows, cols, i, j - 1, threshold);

			// 向上能够到达的格子
			result4 = movingCountCore(matrix, rows, cols, i - 1, j, threshold);

			// 当前的格子 + 左、右、上、下能够到达的格子
			return 1 + result1 + result2 + result3 + result4;
		}
	}

	/**
	 * @description 十进制各位数的和
	 * @author rico
	 */
	public int count(int i) {
		int result = 0;
		while (i != 0) {
			result += i % 10;
			i = i / 10;
		}
		return result;
	}

	/**
	 * @description 判断机器人在当前位置是否可移动
	 * @author rico
	 */
	public boolean iscontinue(boolean[] matrix, int rows, int cols, int i,
			int j, int threshold) {
		int sum = count(i) + count(j);
		// 不超出矩阵边界、行坐标和列坐标的数位之和不大于threshold、所要去的位置还未到达过
		if (i >= 0 && i < rows && j >= 0 && j < cols && sum <= threshold
				&& !matrix[i * cols + j]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int threshold = 3;
		int rows = 3;
		int cols = 2;
		System.out.println("机器人能够达到多少个格子 : "
				+ s.movingCount(threshold, rows, cols));
	}
}
