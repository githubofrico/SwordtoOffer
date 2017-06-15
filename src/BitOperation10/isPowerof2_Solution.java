package BitOperation10;

/**        
 * Title:判断一个数是2的整数次方
 * Description: 底层思想：消1法
 * 把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把原整数的二进制表示中的最右边一个1变成0
 * @author rico       
 * @created 2017年6月5日 下午4:23:23    
 */      
public class isPowerof2_Solution {
	  
	/**     
	 * @description 若一个数是2的整数次方，那么它的二进制格式中只有一个1
	 * @author rico       
	 * @created 2017年6月5日 下午4:21:44     
	 * @param n
	 * @return     
	 */
	public boolean isPowerof2(int n){
		return (n & (n - 1)) == 0;  
	}
	
	
	public static void main(String[] args) {
		System.out.println(new isPowerof2_Solution().isPowerof2(5));
		System.out.println(new isPowerof2_Solution().isPowerof2(11122));
		System.out.println(new isPowerof2_Solution().isPowerof2(64));
	}
}
