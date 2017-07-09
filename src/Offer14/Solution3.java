package Offer14;

import java.util.Arrays;
/**
 * Title: 调整数组顺序使奇数位于偶数前面(不保证奇数和奇数，偶数和偶数之间的相对位置不变)：快排划分法
 * Description:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分
 * ，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author rico
 * @created 2017年6月10日 下午2:36:29
 */
public class Solution3 {
	  
	/**     
	 * @description 快排partition函数的基本思想
	 * @author rico       
	 * @created 2017年6月10日 下午4:59:03     
	 * @param array     
	 */
	public void reOrderArray(int[] array) {
		int base_index = 0;
		// 找到第一个偶数作为基准元素
		while((array[base_index] & 1) != 0){
			base_index ++;
		}
		
		int base = array[base_index];
		int index = base_index;   // 基准元素应该在的位置
		for (int i = base_index+1; i < array.length; i++) {
			if ((array[i] & 1) == 1 ) {
				index ++;
				if (i != index) {
					int temp = array[index];
					array[index] = array[i];
					array[i] = temp;
				}
			}
		}
		array[base_index] = array[index];
		array[index] =base;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		new Solution3().reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}
