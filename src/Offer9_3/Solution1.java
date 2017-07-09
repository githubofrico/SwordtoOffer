package Offer9_3;

/**        
 * Title: 斐波那契数列(高复杂度递归解法)
 * Description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * @author rico       
 * @created 2017年6月4日 下午2:12:34    
 */      
public class Solution1 {
	
	public int Fibonacci(int n) {
		if (n == 0) {   // 递归终止条件
			return 0;
		}else if (n == 1) {   // 递归终止条件
			return 1;
		}
		return Fibonacci(n-1) + Fibonacci(n-2);  //缩小范围，递归求解
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Solution1().Fibonacci(42));
	}
}

