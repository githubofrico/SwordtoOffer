package reOrderArray14;

import java.util.Arrays;
/**
 * Title: 调整数组顺序使奇数位于偶数前面(不保证奇数和奇数，偶数和偶数之间的相对位置不变)：双指针法
 * Description:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分
 * ，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author rico
 * @created 2017年6月10日 下午2:36:29
 */
public class Solution2 {
	public void reOrderArray(int[] array) {
		int index1 = 0;  
		int index2 = array.length - 1; 
		while(index2 > index1){
			while(index1 < index2 && (array[index1] & 1)!= 0){  // index1不断左移，直到指向偶数
				index1 ++;
			}
			while(index2 > index1 && (array[index2] & 1)!= 1){  // index2不断右移，直到指向奇数
				index2 --;
			}
			if (index2 > index1) {  // 交换
				int temp = array[index2];
				array[index2] = array[index1];
				array[index1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		new Solution2().reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}
