package BitOperation10;

  
/**        
 * Title: 判断一个整数的奇偶性    
 * Description: 
 * @author rico       
 * @created 2017年6月6日 上午10:06:29    
 */      
public class OddorEven {
	
	/**     
	 * @description 判断一个整数的奇偶性     
	 * @author rico       
	 * @created 2017年6月6日 上午10:07:54     
	 * @param target
	 * @return  true:奇数, false:偶数   
	 */
	public static boolean isodd(int target){
		return (target & 1) == 1;
	}
	
	public static void main(String[] args) {
		System.out.println(OddorEven.isodd(1));
		System.out.println(OddorEven.isodd(2));
		System.out.println(OddorEven.isodd(0));
		System.out.println(OddorEven.isodd(823));
		System.out.println(OddorEven.isodd(988));
		System.out.println(OddorEven.isodd(-1));
		System.out.println(OddorEven.isodd(-12));
	}
}
