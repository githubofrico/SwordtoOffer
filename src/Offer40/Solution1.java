package Offer40;

/**
 * Title:数组中只出现一次的数字 (异或运算，异或运算满足交换律)
 * Description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @author rico
 * @created 2017年6月28日 下午5:11:23
 */
public class Solution1 {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		// 边界条件
		if (array == null || array.length < 2) {
			return;
		}
		
		// 异或运算满足交换律，两个不同的数字异或运算后必然不为0
		int or = 0;
		for (int i = 0; i < array.length; i++) {
			or ^= array[i];
		}
		
		// 对于一个数字的二进制表示，从右搜索其第一个为1的Bit位
		int index = findFirstBitis1(or);
		
		for (int i = 0; i < array.length; i++) {
			// 以 index 位是否为 1 分为两组
			if (isBit1(array[i], index)) {
				num1[0] ^= array[i];  // 一个数字与0异或后还是原来的数字
			}else{
				num2[0] ^= array[i];  // 一个数字与0异或后还是原来的数字
			}
		}
	}

	  
	/**     
	 * @description 对于一个数字的二进制表示，从右搜索其第一个为1的Bit位
	 * @author rico       
	 * @created 2017年6月28日 下午6:21:22     
	 */
	public int findFirstBitis1(int tmp) {
		int i = 1;
		int index = 0;
		while ((i & tmp) != i) {
			i <<= 1;
			index++;
		}
		return index;
	}

	/**     
	 * @description 对于一个数字的二进制表示，判断其index位是否为1
	 * @author rico       
	 * @created 2017年6月28日 下午6:21:22     
	 */
	public boolean isBit1(int tmp, int index){
		tmp = tmp >> index;
		return (tmp & 1) == 1 ? true : false ;
	}
}
