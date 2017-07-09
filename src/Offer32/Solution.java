package Offer32;

/**
 * Title: 整数中1出现的次数（从1到n整数中1出现的次数）
 * Description: 时间复杂度：O(n*lgn)
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1
 * 、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * 
 * 类似计算每个数的二进制表示中1的个数：二进制数通过除2(只考虑正数)来计算1的个数，十进制通过除10来计算1的个数
 * 
 * 十进制的位数：lgN+1
 * 
 * @author rico
 * @created 2017年6月20日 下午9:15:47
 */
public class Solution {
      
    /**     
     * @description 逐个计算	
     * @author rico       
     * @created 2017年6月20日 下午10:45:31     
     * @param n
     * @return     
     */
    public int NumberOf1Between1AndN_Solution(int n) {
    	int count = 0;
    	for (int i = 1; i <= n; i++) {
			count += NumberOf1(i);
		}
    	return count;
    }
      
    /**     
     * @description 计算每个数中1的个数：二进制数通过除2(只考虑正数)来计算1的个数，十进制通过除10来计算1的个数
     * @author rico       
     * @created 2017年6月20日 下午10:45:09     
     * @param n
     * @return     
     */
    public int NumberOf1(int n) {
    	int count = 0;
    	while( n != 0){
    		if (n%10 == 1) {
				count ++;
			}
    		n = n/10;
    	}
    	return count;
    }
    
      
    /**     
     * @description 计算一个十进制数的位数
     * @author rico       
     * @created 2017年6月21日 上午7:36:00     
     * @param N
     * @return     
     */
    public static int countDigit(int N){
    	return (int) (Math.log10(N) + 1);
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.NumberOf1Between1AndN_Solution(101));
		
		System.out.println(Solution.countDigit(1000));
	}
}
