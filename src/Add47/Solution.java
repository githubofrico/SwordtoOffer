package Add47;

/**
 * Title:不用加减乘除做加法 
 * Description: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 
 * 关于数字的计算，除了加减乘除外，就剩移位运算(五种：&,|,^,<<,>>)了
 * 
 * @author rico
 * @created 2017年7月2日 下午2:07:34
 */
public class Solution {
	public int Add(int num1, int num2) {
		// 先对两个数进行求和(此步不作进位，进位在下一步做),实质上是异或运算
		int sum = num1 ^ num2;
		// 处理进位运算，实质上是与运算
		int carry = (num1 & num2) << 1;

		if (carry == 0) { 	// 递归终止条件(简单情景)：没有进位
			return sum;	  // 简单情境下的处理
		} else { 	// 递归求解sum与进位的和
			return Add(sum, carry);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.Add(15, 87));
	}
}
