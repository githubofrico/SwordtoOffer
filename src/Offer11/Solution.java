package Offer11;

/**        
 * Title: 数值的整数次方     
 * Description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。 
 * @author rico       
 * @created 2017年6月5日 下午4:49:19    
 */      
public class Solution {
	  
	public double Power(double base, int exponent) {
		if (base == 0) {  // 边界情况
			return 0;
		}else if (exponent == 0) {    // 边界情况
			return 1;
		}
		
		double result = base;
		int e = Math.abs(exponent);  // e的绝对值
		for (int i = 0; i < e-1; i++) {
			result *= base;
		}
		
		// 根据exponent的正负性，决定是否取倒数
		return exponent > 0 ? result : (1/result);  
	}
}
