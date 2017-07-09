package Offer48;

/**
 * Title:不使用新的变量，交换两个整型变量的值 
 * Description: 比如有两个变量a、b,我们希望在不使用新的变量的前提下交换二者的值
 * 
 * @author rico
 * @created 2017年7月2日 下午2:41:38
 */
public class Solution {
	  
	/**     
	 * @description 利用异或运算，异或运算满足交换律，且一个数与自身异或为0，一个数与0异或为自身
	 * @author rico       
	 * @created 2017年7月2日 下午2:44:19     
	 * @param a
	 * @param b
	 */
	public static void swap(int a, int b) {
		System.out.println("交换前, a = " + a + " , b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("交换后, a = " + a + " , b = " + b);
	}

	public static void main(String[] args) {
		int a = 8;
		int b = 98;
		Solution.swap(a, b);
	}
}
