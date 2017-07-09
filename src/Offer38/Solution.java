package Offer38;

/**
 * Title: 数字在排序数组中出现的次数(双指针法)
 * Description: 统计一个数字在排序数组中出现的次数。
 * 
 * 算法时间复杂度：O(n)
 * 
 * @author rico
 * @created 2017年6月25日 下午4:47:51
 */
public class Solution {
	public int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0) {  // 边界值
			return 0;
		} else if (k < array[0] || k > array[array.length - 1]) {  // 边界值
			return 0;
		} else if(array.length == 1){  
			return array[0] == k ? 1:0;
		}else {
			int i = 0;
			int j = array.length - 1;
			while (array[i] != k && array[j] != k && j > i) {
				i++;
				j--;
			}
			if (j <= i) {
				return 0;
			} else if (array[i] == k) {
				while (array[j] != k) {
					j--;
				}
			} else if (array[j] == k) {
				while (array[i] != k) {
					i++;
				}
			}
			return j - i + 1;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] array = {3};
		System.out.println(s.GetNumberOfK(array, 3));
	}
}
