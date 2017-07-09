package Offer3;

import java.util.Arrays;

/**
 * Title : 二维数组中的查找 
 * Description :逐行搜索+二分查找
 * 时间复杂度：O(nlgn)
 * 空间复杂度：O(1)
 * 
 * @author rico
 * @created 2017年5月8日 下午12:02:59
 */
public class Solution1 {

	public static boolean contain(int[][] array, int target) {

		// 边界条件：目标数组是否为空
		if (array == null)
			return false;

		for (int i = 0; i < array.length; i++) {
			int col = array[i].length;
			if (col != 0) { // 若col为零，则当前行数组不包含任何元素，因此不进入执行

				int min = array[i][0]; // 行最小值
				int max = array[i][col - 1]; // 行最大值

				// 优化处理
				// 若目标值小于当前行最小值，则其比当前行下方的任何元素都要小，直接返回 false
				if (target < min) { 
					return false;
					
				} else if (target > max) { // 若目标值大于当前行最大值，则其比当前行中的任何元素都要大，跳出当前行
					continue;
				}

				// 若目标值位于当前行最小值与最大值之间，则进行二叉搜索，若找到，直接返回 true
				if (Arrays.binarySearch(array[i], target) >= 0)
					return true;
				//否则，继续看下一个行数组
				continue;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = {};
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
		// System.out.println(binarySearch(arr, 0, arr.length - 1, 4));
	}
}
