package reOrderArray14;

import java.util.Arrays;
/**
 * Title: 调整数组顺序使奇数位于偶数前面(不保证奇数和奇数，偶数和偶数之间的相对位置不变)
 * Description:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分
 * ，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author rico
 * @created 2017年6月10日 下午2:36:29
 */
public class Solution1 {
	public void reOrderArray(int[] array) {
		int index1 = -1; // 指向最新的奇数
		int index2 = -1; // 指向最老的偶数
		for (int i = 0; i < array.length; i++) { // 从左到右依次遍历序列
			if ((array[i] & 1) == 1) { // index1 指向最新的奇数
				index1 = i;
			} else if (index2 == -1) {
				index2 = i; // index2指向最老的偶数
			}
			if (index2 != -1 && index1 > index2) { // 将最新奇数与最老偶数交换
				int temp = array[index1];
				array[index1] = array[index2];
				array[index2] = temp;
				index1 = index2;   // 更新index1
				index2++; // 更新index2：奇数移到偶数前面，偶数位置移后
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		new Solution1().reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}
