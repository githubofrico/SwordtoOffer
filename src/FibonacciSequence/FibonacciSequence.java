package FibonacciSequence;
/**
 * Title: 斐波纳契数列
 * 
 * Description: 斐波纳契数列，又称黄金分割数列，指的是这样一个数列：1、1、2、3、5、8、13、21、……
 * 在数学上，斐波纳契数列以如下被以递归的方法定义：F0=0，F1=1，Fn=F(n-1)+F(n-2)（n>=2，n∈N*）。
 * 
 * 两种递归解法：经典解法和优化解法
 * 两种非递归解法：递推法和数组法
 * 
 * @author rico
 */
public class FibonacciSequence {

	/**
	 * @description 经典递归法求解
	 * 
	 * 斐波那契数列如下：
	 * 
	 * 	1,1,2,3,5,8,13,21,34,...
	 * 
	 * 那么，计算fib(5)时，需要计算1次fib(4),3次fib(3),3次fib(2)和两次fib(1)，即：
	 * 
	 *  fib(5) = fib(4) + fib(3)
	 *  
	 * 	fib(4) = fib(3) + fib(2) ；fib(3) = fib(2) + fib(1)
	 *  
	 *  fib(3) = fib(2) + fib(1)
	 *  
	 * 这里面包含了许多重复计算，而实际上我们只需计算fib(4)、fib(3)、fib(2)和fib(1)各一次即可，
	 * 后面的optimizeFibonacci函数进行了优化，使时间复杂度降到了O(n).
	 * 
	 * @author rico
	 * @created 2017年5月10日 下午12:00:42
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n) {
		if (n > 0) {
			if (n == 1 || n == 2) { // 递归终止条件
				return 1;
			}
			return fibonacci(n - 1) + fibonacci(n - 2); // 递归调用，缩小问题的规模
		}
		return -1;
	}


	/**     
	 * @description 对经典递归法的优化
	 * 
	 * 斐波那契数列如下：
	 * 
	 * 	1,1,2,3,5,8,13,21,34,...
	 * 
	 * 那么，我们可以这样看：fib(1,1,5) = fib(1,2,4) = fib(2,3,3) = 5
	 * 
	 * 也就是说，以1,1开头的斐波那契数列的第五项正是以1,2开头的斐波那契数列的第四项，
	 * 而以1,2开头的斐波那契数列的第四项也正是以2,3开头的斐波那契数列的第三项，
	 * 更直接地，我们就可以一步到位：fib(2,3,3) = 2 + 3 = 5,计算结束。 
	 * 
	 * 注意，前两个参数是数列的开头两项，第三个参数是我们想求的以前两个参数开头的数列的第几项。
	 * 
	 * 时间复杂度：O(n)
	 * 
	 * @author rico       
	 * @param first 数列的第一项
	 * @param second 数列的第二项
	 * @param n 目标项
	 * @return     
	 */
	public static int optimizeFibonacci(int first, int second, int n) {
		if (n > 0) {
			if(n == 1){
				return first;
			}else if(n == 2){
				return second;
			}else if (n == 3) {
				return first + second;
			}
			return optimizeFibonacci(second, first + second, n - 1);
		}
		return -1;
	}
	
	
	/**
	 * @description 非递归解法：有去无回
	 * @author rico
	 * @created 2017年5月10日 下午12:03:04
	 * @param n
	 * @return
	 */
	public static int fibonacci_loop(int n) {

		if (n > 0) {

			if (n == 1 || n == 2) {
				return 1;
			}

			int result = -1;
			int first = 1; // 自己维护的"栈",以便状态回溯
			int second = 1; // 自己维护的"栈",以便状态回溯

			for (int i = 3; i <= n; i++) { // 循环
				result = first + second;
				first = second;
				second = result;
			}
			return result;
		}
		return -1;
	}

	  
	/**     
	 * @description 使用数组存储斐波那契数列
	 * @author rico       
	 * @param n
	 * @return     
	 */
	public static int fibonacci_array(int n) {
		if (n > 0) {
			int[] arr = new int[n];   // 使用临时数组存储斐波纳契数列
			arr[0] = arr[1] = 1;

			for (int i = 2; i < n; i++) {   // 为临时数组赋值
				arr[i] = arr[i-1] + arr[i-2];
			}
			return arr[n - 1];
		}
		return -1;
	}
	

	public static void main(String[] args) {
		System.out.println(fibonacci_loop(7));
		System.out.println(optimizeFibonacci(1, 1, 1000));
		System.out.println(fibonacci(1000));
		System.out.println(fibonacci_array(7));
	}
}
