package Offer52;

import java.util.Arrays;

/**
 * Title:构建乘积数组(以当前A[i]为界,左右子序列求积分别找规律)
 * Description:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]
 * *A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * @author rico
 * @created 2017年7月3日 下午4:53:46
 */
public class Solution1 {
	public int[] multiply(int[] A) {
		if (A != null && A.length != 0) {
			int[] c = new int[A.length];
			int[] d = new int[A.length];
			int[] b = new int[A.length];

			// 计算D
			d[0] = 1;
			for (int i = 1; i < A.length; i++) {
				d[i] = d[i - 1] * A[i - 1];
			}

			// 计算C
			c[A.length - 1] = 1;
			for (int j = A.length - 1; j > 0; j--) {
				c[j - 1] = c[j] * A[j];
			}

			// 计算B
			for (int i = 0; i < A.length; i++) {
				b[i] = d[i] * c[i];
			}

			return b;
		}
		return A;
	}

	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		int[] A = { 1, 2, 3, 4, 5 };
		int[] b = s1.multiply(A);
		System.out.println(Arrays.toString(b));
	}
}