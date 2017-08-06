package Offer66;

import java.util.Arrays;

/**
 * Title:矩阵中的路径
 * Description:请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始
 * ，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c
 * s a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 * 
 * 空间复杂度：辅助空间O(rows*cols) + 递归调用栈
 * 
 * @author rico
 * @created 2017年7月9日 下午12:09:59
 */
public class Solution1 {

	/**
	 * @description 尝试所有的入口，寻找与str相匹配的路径
	 * @author rico
	 * @created 2017年7月9日 下午3:25:35
	 * @param matrix
	 *            矩阵
	 * @param rows
	 *            矩阵行数
	 * @param cols
	 *            矩阵列数
	 * @param str
	 *            待匹配路径
	 */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || matrix.length == 0 || str == null
				|| str.length == 0) { // 边界条件
			return false;
		} else {
			int index = 0;
			boolean[] flag = new boolean[matrix.length];
			System.out.println("初始状态 ： " + Arrays.toString(flag));
			System.out.println("-----------------------------------");
			// 尝试从所有入口位置开始查找
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (hasPathCore(matrix, rows, cols, i, j, str, index, flag)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	/**
	 * @description 递归算法，穷举思路
	 * @author rico
	 * @created 2017年7月9日 下午3:24:06
	 * @param matrix
	 *            给定矩阵
	 * @param rows
	 *            矩阵行数
	 * @param cols
	 *            矩阵列数
	 * @param i
	 *            当前所在行数
	 * @param j
	 *            当前所在列数
	 * @param str
	 *            目标串
	 * @param index
	 *            当前字符的位置
	 * @param flag
	 *            记录格子是否被经过
	 */
	public boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j,
			char[] str, int index, boolean[] flag) {
		if (i >= 0 && i < rows && j >= 0 && j < cols && !flag[i * cols + j]
				&& str[index] == matrix[i * cols + j]) {
			if (index == str.length-1) {  // 递归终止条件
				return true;
			}
			boolean result = false;
			System.out.println("I : " + i + ", J : " + j);
			System.out.println("index : " + index);
			flag[i * cols + j] = true;
			index++;
			System.out.println("状态 ： " + Arrays.toString(flag));
			System.out.println("-----------------------------------");

			// 穷举四种可能
			boolean r1 = false;
			boolean r2 = false;
			boolean r3 = false;
			boolean r4 = false;

			// 向右
			r1 = hasPathCore(matrix, rows, cols, i, j + 1, str, index, flag);
			// 向下
			r2 = hasPathCore(matrix, rows, cols, i + 1, j, str, index, flag);
			// 向左
			r3 = hasPathCore(matrix, rows, cols, i, j - 1, str, index, flag);
			// 向上
			r4 = hasPathCore(matrix, rows, cols, i - 1, j, str, index, flag);

			result = r1 || r2 || r3 || r4; // 穷举

			// 路径回退
			if (!result) {
				--index;
				flag[i * cols + j] = false;
				System.out.println("回退状态 ： " + Arrays.toString(flag));
			}
			return result;
		} else { // 递归终止条件
			return false;
		}
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
//		char[] matrix = { 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G', 'S', 'F',
//				'C', 'S', 'L', 'O', 'P', 'Q', 'A', 'D', 'E', 'E', 'M', 'N',
//				'O', 'E', 'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M', 'V', 'C',
//				'E', 'I', 'F', 'G', 'G', 'S' };
		 char[] matrix = { 'A', 'B', 'D', 'B', 'C', 'O' };
		 int rows = 2;
		 int cols = 3;
//		int rows = 5;
//		int cols = 8;
//		char[] str = { 'S', 'G', 'G', 'F', 'I', 'E', 'C', 'V', 'A', 'A', 'S',
//				'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G', 'Q', 'E', 'M' };
		 char[] str = { 'A', 'B', 'C', 'B', 'D' };
		System.out.println(s.hasPath(matrix, rows, cols, str));
	}
}
