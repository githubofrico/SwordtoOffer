package StrToInt49;

/**
 * Title: 把字符串转换成整数 Description:将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0 输入描述: 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:如果是合法的数值表达则返回该数字，否则返回0
 *
 *
 * 输入： +2147483647 1a33
 * 
 * 
 * 输出 2147483647 0
 * 
 * @author rico
 * @created 2017年7月2日 下午3:03:46
 */
public class Solution1 {

	/**
	 * @description 逐位计算
	 * @author rico
	 * @created 2017年7月2日 下午3:15:39
	 * @param str
	 * @return
	 */
	public int StrToInt(String str) {
		if (str != null && str.length() != 0) {
			char[] arr = str.toCharArray();
			int num = 0;
			int end = arr.length - 1;

			// 除首位之外的字符
			for (int i = end; i > 0; i--) {
				if ('0' <= arr[i] && arr[i] <= '9') {
					num += (arr[i] - 48) * power_optimized(10, end - i);
				} else {
					return 0;
				}
			}
			
			// 单独考虑首位
			if (arr[0] == '+') {
				return num;
			} else if (arr[0] == '-') {
				return -num;
			} else if ('0' <= arr[0] && arr[0] <= '9') {
				num += (arr[0] - 48) * power_optimized(10, end);
				return num;
			} else {
				return 0;
			}
		}
		return 0;
	}

	/**
	 * @description 幂运算
	 * @author rico
	 * @created 2017年7月2日 下午4:06:24
	 * @param a
	 * @param b
	 * @return
	 */
	public int power(int a, int b) {
		if (b == 0) {
			return 1;
		} else {
			return a * power(a, b - 1);
		}
	}

	/**
	 * @description 优化后的幂运算(减少相乘的次数)
	 * @author rico
	 * @created 2017年7月2日 下午4:06:41
	 * @param a
	 * @param b
	 * @return
	 */
	public int power_optimized(int a, int b) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a;
		} else {
			int mid = b >> 1;
			int result = power_optimized(a, mid);
			result *= result;
			if ((b & 1) == 1) {
				result *= a;
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String str = "-1209";
		System.out.println(s.StrToInt(str));
	}
}
