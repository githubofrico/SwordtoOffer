package BitOperation10;

/**        
 * Title:二进制中1的个数     
 * Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * 正数移位后仍然是正数(有一特例，在计算机中，-0是最小的负数，而不是0)
 * 负数移位后仍然是负数
 * 
 * @author rico       
 * @created 2017年6月4日 下午5:37:32    
 */      
public class NumberOf1_Solution1 {
	  
	/**     
	 * @description 给定整数二进制表示有几位便循环几次
	 * @author rico       
	 * @created 2017年6月5日 下午3:28:36     
	 * @param n
	 * @return     
	 */
	public int NumberOf1(int n) {
		int temp = 1;
		int count = 0;
		while (temp != 0) {
			//若(temp & n) == temp,说明n的二进制在对应位置上为1
			count = (temp & n) == temp ? ++count : count;  
			temp = temp << 1;  // temp 不断向左移
		}
		return 	count;
	}
	
	public static void main(String[] args) {
		System.out.println(new NumberOf1_Solution1().NumberOf1(-5));
		System.out.println(new NumberOf1_Solution1().NumberOf1(5));
	}
}
