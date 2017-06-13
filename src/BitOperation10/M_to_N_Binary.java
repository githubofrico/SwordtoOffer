package BitOperation10;

/**        
 * Title: M的二进制表示需要改变多少位才能变成N的二进制表示    
 * Description: 底层思想是：把一个整数减去1之后再和原来的整数做位与运算，
 * 		得到的结果相当于把原整数的二进制表示中的最右边一个1变成0
 * @author rico       
 * @created 2017年6月5日 下午4:27:46    
 */      
public class M_to_N_Binary {
	  
	/**     
	 * @description 问题的本质：M和N的二进制表示中有多少位不同
	 * @author rico       
	 * @created 2017年6月5日 下午4:31:21     
	 * @param M
	 * @param N
	 * @return     
	 */
	public int changeMtoN(int M, int N){
		int temp = M^N;
		int count = 0;
		
		while(temp != 0){
			count ++;
			temp = temp & (temp - 1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new M_to_N_Binary().changeMtoN(10, 13));
	}
}
