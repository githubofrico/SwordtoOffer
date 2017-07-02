package StrToInt49;

/**
 * Title: 把字符串转换成整数
 * Description:将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述: 输入一个字符串,包括数字字母符号,可以为空 
 * 输出描述:如果是合法的数值表达则返回该数字，否则返回0
 *
 *
 * 输入：
 * +2147483647
 * 1a33
 * 
 * 
 * 输出
 * 2147483647
 * 0
 * @author rico
 * @created 2017年7月2日 下午3:03:46
 */
public class Solution {
	  
	/**     
	 * @description 使用Integer的构造方法解题
	 * @author rico       
	 * @created 2017年7月2日 下午3:15:39     
	 * @param str
	 * @return     
	 */
	public int StrToInt(String str) {
		try{
			Integer num = new Integer(str);
			return num;
		}catch(Exception e){
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = null;
		System.out.println(s.StrToInt(str));
	}
}
