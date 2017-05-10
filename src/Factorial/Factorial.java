package Factorial;

/**
 * Title: 阶乘的实现 
 * Description:
 * 		递归解法
 * 		非递归解法
 * @author rico
 */
public class Factorial {

	  
	/**     
	 * @description 阶乘的递归实现
	 * @author rico       
	 * @created 2017年5月10日 下午8:45:48     
	 * @param n
	 * @return     
	 */
	public static long f(int n) {
		if (n == 1) // 递归终止条件
			return 1;

		return n * f(n - 1); // // 递归调用，缩小问题的规模
	}

	  
	/**     
	 * @description 阶乘的非递归实现
	 * @author rico       
	 * @created 2017年5月10日 下午8:46:43     
	 * @param n
	 * @return     
	 */
	public static long f_loop(int n) {
		long result = n;
		while (n > 1) {
			n--;
			result = result * n;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Recursive : " + f(6));
		System.out.println("Recursive : " + f(20));
		System.out.println("Loop : " + f_loop(6));
		System.out.println("Loop : " + f_loop(20));
	}
}
