package Offer32;

/**
 * Title: 整数中1出现的次数（从1到n整数中1出现的次数） 
 * Description:时间复杂度：O(lgn)
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1
 * 、10、11、12、13因此共出现6次
 * ,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * 
 * 类似计算每个数的二进制表示中1的个数：二进制数通过除2(只考虑正数)来计算1的个数，十进制通过除10来计算1的个数
 * 
 * 十进制的位数：lgN+1
 * 
 * @author rico
 * @created 2017年6月20日 下午9:15:47
 */
public class Solution1 {

	/**
	 * @description
	 * @author rico
	 * @created 2017年6月20日 下午10:45:31
	 * @param n
	 * @return
	 */
	public int NumberOf1Between1AndN_Solution(int n) {
		if (n <= 0) {
			return 0;
		}
		return NumberOf1(String.valueOf(n));
	}

	/**
	 * @description 计算每个数中1的个数：二进制数通过除2(只考虑正数)来计算1的个数，十进制通过除10来计算1的个数
	 * @author rico
	 * @created 2017年6月20日 下午10:45:09
	 * @param n
	 * @return
	 */
	public int NumberOf1(String str) {
		int first = str.charAt(0) - '0';
		int length = str.length();

		if (length == 1) {
			return first > 0 ? 1 : 0;
		}

		// 假设str是21345
		// numFirstDigit就是10000~19999的第一个位中的数目
		int numFirstDigit = 0;
		if (first > 1) {
			numFirstDigit = (int) Math.pow(10, length - 1);
		} else if (first == 1) {
			numFirstDigit = Integer.valueOf(str.substring(1)) + 1;
		}

		// numOtherDigits是1346~21345除了第一位之外的数位中数目， 2 * 4 * 10^3
		int numOtherDigits = (int) (first * (length - 1) * Math.pow(10,
				length - 2));
		
		// numRecursive是1~1345中的数目
		int numRecursive = NumberOf1(str.substring(1));

		return numFirstDigit + numOtherDigits + numRecursive;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		Solution1 s1 = new Solution1();
		int target = 9;
		System.out.println("s : " + s.NumberOf1Between1AndN_Solution(target));
		System.out.println("s1 : " + s1.NumberOf1Between1AndN_Solution(target));

	}
}
