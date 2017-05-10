package PascalTriangle;

/**
 * Title: Description: 杨辉三角形又称Pascal三角形，它的第i+1行是(a+b)i的展开式的系数。
 * 它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。
 * 
 * 下面给出了杨辉三角形的前4行： 
 *    1 
 *   1 1
 *  1 2 1
 * 1 3 3 1
 * 
 * 输入格式：输入包含一个数 n。
 * 
 * 输出格式：输出杨辉三角形的前n行。每一行从这一行的第一个数开始依次输出，中间使用一个空格分隔。
 * 请不要在前面输出多余的空格。
 * 
 * 样例输入：4
 * 
 * 样例输出：
 * 1 
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 
 * @author rico
 */

public class PascalTriangle {

	private static int[][] arr = null;

	  
	/**     
	 * @description 创建一个具有n行的杨辉三角
	 * @author rico       
	 * @param n     
	 */
	public static void createPascalTriangle(int n) {
		arr = new int[n][n];
		// 初始化杨辉三角
		for (int i = 0; i < n; i++) {
			arr[i][0] = arr[i][i] = 1;   // 第一列和对角线上的值总为 1
			for (int j = 0; j <= i; j++) {
				if (i != j && j != 0) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}
		}
	}

	/**     
	 * @description 递归获取杨辉三角指定行、列(从0开始)的值
	 * 				注意：与是否创建杨辉三角无关
	 * @author rico 
	 * @x  指定行
	 * @y  指定列    
	 */
	public static int getValue(int x, int y) {
		if(y <= x && y >= 0){
			if(y == 0 || x == y){   // 递归终止条件
				return 1; 
			}else{ 
				// 递归调用，缩小问题的规模
				return getValue(x-1, y-1) + getValue(x-1, y); 
			}
		}
		return -1;
	} 
	
	/**     
	 * @description 打印杨辉三角
	 * @author rico       
	 * @created 2017年5月10日 下午4:36:26     
	 * @param n     
	 */
	public static void printPascalTriangle() {
		if (arr == null) {
			System.out.println("请先创建杨辉三角...");
			return;
		}
		
		int n = arr.length;
		
		// 打印杨辉三角
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (j <= i) {
					sb.append(arr[i][j]).append(" ");
				}
			}
			System.out.println(sb.toString().substring(0, sb.length() - 1));
		}
	}

	public static void main(String[] args) {
		createPascalTriangle(8);
		System.out.println("杨辉三角为： ");
		printPascalTriangle();
		
		System.out.println("\n--------------------------\n");
		
		System.out.println("杨辉三角指定位置的值为 ：" + getValue(7, 4)); 

	}
}
