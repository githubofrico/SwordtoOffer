package ClockwisePrintMatrix20;

/**        
 * Title: 顺时针打印矩阵(不一定是方阵)    
 * Description:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10. 
 * @author rico       
 * @created 2017年6月15日 下午12:13:22    
 */
import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix != null) {
			int minrow = 0;
			int maxrow = matrix.length - 1;
			int mincol = 0;
			int maxcol = matrix[0].length - 1;
			result = printMatrix(matrix, minrow, maxrow, mincol, maxcol);
		}
		return result;
	}

	/**
	 * @description 打印一圈(共有四种情形：完整一圈，只有一行，只有一列，只有一个元素)，递归算法
	 * @author rico
	 * @created 2017年6月15日 下午3:43:39
	 * @param matrix
	 *            原始矩阵
	 * @param minrow
	 *            本圈中的最上行
	 * @param maxrow
	 *            本圈中的最下行
	 * @param mincol
	 *            本圈中的最左列
	 * @param maxcol
	 *            本圈中的最右列
	 * @return
	 */
	public ArrayList<Integer> printMatrix(int[][] matrix, int minrow,
			int maxrow, int mincol, int maxcol) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (maxrow < 0 || maxcol < 0 || minrow > maxrow || mincol > maxcol) { // 递归终止条件1：不符合条件
			return result;
		} else if (minrow == maxrow && mincol == maxcol) { // 递归终止条件2：只剩矩阵中间一个元素
			result.add(matrix[minrow][minrow]);
			return result;
		} else if (minrow == maxrow) { // 递归终止条件3：只剩一列
			for (int i = mincol; i <= maxcol; i++) {
				result.add(matrix[minrow][i]);
			}
			return result;
		} else if (mincol == maxcol) { // 递归终止条件4：只剩一行
			for (int i = minrow; i <= maxrow; i++) {
				result.add(matrix[i][maxcol]);
			}
			return result;
		} else { // 多行多列，缩小规模，递归执行
			for (int i = mincol; i < maxcol; i++) {
				result.add(matrix[minrow][i]);
			}
			for (int i = minrow; i < maxrow; i++) {
				result.add(matrix[i][maxcol]);
			}
			for (int i = maxcol; i > mincol; i--) {
				result.add(matrix[maxrow][i]);
			}
			for (int i = maxrow; i > minrow; i--) {
				result.add(matrix[i][mincol]);
			}
			result.addAll(printMatrix(matrix, ++minrow, --maxrow, ++mincol,
					--maxcol)); // 递归执行
			return result;
		}
	}
}
