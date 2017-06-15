package BitOperation10;

/**        
 * Title:二进制中1的个数     
 * Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * 底层思想：消1法，异或运算
 * 把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把原整数的二进制表示中的最右边一个1变成0
 * 
 * @author rico       
 * @created 2017年6月4日 下午5:37:32    
 */      
public class NumberOf1_Solution2 {
	  
	/**     
	 * @description 给定整数二进制中有几个1便循环几次
	 * @author rico       
	 * @created 2017年6月5日 下午3:27:58     
	 * @param n
	 * @return     
	 */
	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			++count;  
			n = (n-1) & n;  // 把一个整数减去1,再将其和原整数做与运算,会把该整数最右边的1变成0
		}
		return 	count;
	}
	
	public static void main(String[] args) {
		System.out.println(new NumberOf1_Solution2().NumberOf1(-5));
		System.out.println(new NumberOf1_Solution2().NumberOf1(5));
	}
}
