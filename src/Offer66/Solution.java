package Offer66;

/**
 * Title:矩阵中的路径 Description:
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始
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
public class Solution {

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
			boolean result = false;
			int index = 0;
			char target = str[index];
			// 搜寻并尝试从所有入口位置开始查找，直到有路径与str匹配或没有对应的入口可以使路径与str匹配
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (matrix[i * cols + j] == target) { // 入口处
						boolean[] flag = new boolean[matrix.length];
						result = hasPathCore(matrix, rows, cols, i, j, str,
								index, flag);
						if (result) { // 若成功，则直接返回；否则，从下一个入口处尝试
							return result;
						}
					}
				}
			}
			return result;
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
		if (index == str.length - 1) {
			return true;
		} else {
			boolean result = false;
			int k = i;
			int m = j;
			System.out.println("K : " + k + ", M : " + m);
			System.out.println("index : " + index);
			flag[k * cols + m] = true;

			// 穷举四种可能
			boolean r1 = false;
			boolean r2 = false;
			boolean r3 = false;
			boolean r4 = false;

			// 向右
			if (m + 1 < cols && !flag[k * cols + m + 1]
					&& str[index + 1] == matrix[k * cols + m + 1]) {
				flag[k * cols + m + 1] = true;
				r1 = hasPathCore(matrix, rows, cols, i, j + 1, str, index + 1,
						flag);
			}

			// 向下
			if (k + 1 < rows && !flag[k * cols + m + cols]
					&& str[index + 1] == matrix[k * cols + m + cols]) {
				flag[k * cols + m + cols] = true;
				r2 = hasPathCore(matrix, rows, cols, i + 1, j, str, index + 1,
						flag);
			}

			// 向左
			if (m - 1 >= 0 && !flag[k * cols + m - 1]
					&& str[index + 1] == matrix[k * cols + m - 1]) {
				flag[k * cols + m - 1] = true;
				r3 = hasPathCore(matrix, rows, cols, i, j - 1, str, index + 1,
						flag);
			}

			// 向上
			if (k - 1 >= 0 && !flag[k * cols + m - cols]
					&& str[index + 1] == matrix[k * cols + m - cols]) {
				flag[k * cols + m - cols] = true;
				r4 = hasPathCore(matrix, rows, cols, i - 1, j, str, index + 1,
						flag);
			}
			result = r1 || r2 || r3 || r4;  // 穷举
			return result;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		char[] matrix = { 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G', 'S', 'F',
				'C', 'S', 'L', 'O', 'P', 'Q', 'A', 'D', 'E', 'E', 'M', 'N',
				'O', 'E', 'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M', 'V', 'C',
				'E', 'I', 'F', 'G', 'G', 'S' };
		int rows = 5;
		int cols = 8;
		char[] str = { 'S', 'G', 'G', 'F', 'I', 'E', 'C', 'V', 'A', 'A', 'S',
				'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G', 'Q', 'E', 'M' };
		System.out.println(s.hasPath(matrix, rows, cols, str));
	}
}
