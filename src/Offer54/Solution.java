package Offer54;

/**
 * Title: 表示数值的字符串(整数/小数 + (E/e) + (整数))
 * Description:请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123"
 * ,"3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 
 * @author rico
 * @created 2017年7月6日 下午2:19:42
 */
public class Solution {

	/**
	 * @description 字符串是否表示数值
	 * @author rico
	 * @created 2017年7月6日 下午3:21:49
	 * @param str
	 * @return
	 */
	public boolean isNumeric(char[] str) {
		if (str == null || str.length == 0) {
			return false;
		} else {
			String s = String.valueOf(str);
			int index = s.indexOf('e');
			if (index == -1) {
				index = s.indexOf('E');
			}
			if (index != -1) {
				return (isRoundNumber(s.substring(0, index).toCharArray()) || isDecimalNumber(s
						.substring(0, index).toCharArray()))
						&& isRoundNumber(s.substring(index + 1, s.length())
								.toCharArray());
			} else {
				return isRoundNumber(str) || isDecimalNumber(str);
			}
		}

	}

	/**
	 * @description 字符串是否表示整数(正负号 + 数字)
	 * @author rico
	 * @created 2017年7月6日 下午3:22:17
	 * @param str
	 * @return
	 */
	public boolean isRoundNumber(char[] str) {
		if (str.length == 0) {
			return false;
		} else {
			for (int i = 0; i < str.length; i++) {
				if (i == 0) {
					if (str[0] == '+' || str[0] == '-') {
						continue;
					}
				}
				if (!(str[i] >= '0' && str[i] <= '9')) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * @description 字符串是否表示小数(正负号 + 数字 + 数字之间的小数点)
	 * @author rico
	 * @created 2017年7月6日 下午3:22:59
	 * @param str
	 * @return
	 */
	public boolean isDecimalNumber(char[] str) {
		if (str.length == 0) {
			return false;
		} else {
			boolean flag = false; // 只能出现一个小数点
			for (int i = 0; i < str.length; i++) {
				if (i == 0) {
					if (str[0] == '+' || str[0] == '-') {
						continue;
					}
				}
				if (!(str[i] >= '0' && str[i] <= '9')) {
					if (str[i] == '.' && !flag && i != 0 && i != str.length - 1) {
						flag = true;
						continue;
					}
					return false;
				}
			}
			return flag;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "123.45e+6";
		System.out.println("是否为整数 ： " + s.isRoundNumber(str.toCharArray()));
		System.out.println("是否为小数 ： " + s.isDecimalNumber(str.toCharArray()));
		System.out.println("是否为数 ： " + s.isNumeric(str.toCharArray()));
	}
}
