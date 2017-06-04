package Fibonacci9;

/**
 * Title: 斐波那契数列 (低复杂度递归解法，优化解法)
 * Description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * 
 * @author rico
 * @created 2017年6月4日 下午2:12:34
 */
public class Solution2 {

	public int Fibonacci(int n) {
		return Fibonacci(n, 0, 1);
	}

	  
	/**     
	 * @description 以first，second为头的斐波那契数列第n个值的计算
	 * 等价于以second，first+second为头的斐波那契数列第n-1个值的计算
	 * @author rico       
	 * @created 2017年6月4日 下午2:57:19     
	 * @param n
	 * @param first
	 * @param second
	 * @return     
	 */
	public int Fibonacci(int n, int first, int second) {
		if (n == 0) {
			return 0;
		}else if (n == 1) {
			return 1;
		}else if (n == 2) {
			return first + second;
		}
		return Fibonacci(--n, second, first + second);
	}

	  
	/**     
	 * @description 测试
	 * @author rico       
	 * @created 2017年6月4日 下午3:02:18     
	 * @param args     
	 */
	public static void main(String[] args) {
		System.out.println(new Solution2().Fibonacci(42));
	}
}
