package Offer52;

/**
 * Title:构建乘积数组(使用除法)
 * Description:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]
 * *A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * @author rico
 * @created 2017年7月3日 下午4:53:46
 */
public class Solution {
	public int[] multiply(int[] A) {
		if (A != null && A.length != 0) {
			int product = calculateProduct(A, 0, A.length - 1);
			int[] B = new int[A.length];
			for (int i = 0; i < A.length; i++) {
				if (A[i] == 0) {
					B[i] = calculateProduct(A, 0, i - 1)
							* calculateProduct(A, i + 1, A.length - 1);
				} else {
					B[i] = product / A[i];
				}
			}
			return B;
		}
		return A;
	}

	public int calculateProduct(int[] a, int from, int to) {
		if (from <= to) {
			int product = 1;
			for (int i = from; i <= to; i++) {
				product *= a[i];
			}
			return product;
		} else {
			return 1;
		}
	}
}