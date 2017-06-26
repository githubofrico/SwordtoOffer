package GetNumberOfK38;

/**
 * Title: 数字在排序数组中出现的次数(二分查找的应用) 
 * Description: 统计一个数字在排序数组中出现的次数。
 * 
 * 算法时间复杂度：O(n)
 * 
 * @author rico
 * @created 2017年6月25日 下午4:47:51
 */
public class Solution1 {
	public int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0) { // 边界条件
			return 0;
		} else if (k < array[0] || k > array[array.length - 1]) { // 边界条件
			return 0;
		} else {
			// 先利用二叉搜索算法查找数字k的位置
			int index = binarySearch(array, 0, array.length - 1, k);
			if (index == -1) { // 没有找到数字k
				return 0;
			} else {
				int start = index;
				int end = index;

				// 数字k的起始位置
				while (start - 1 >= 0) {
					if (array[start - 1] != k) {
						break;
					} else {
						start--;
					}
				}

				// 数字k终止位置
				while (end + 1 <= array.length - 1) {
					if (array[end + 1] != k) {
						break;
					} else {
						end++;
					}
				}
				return end - start + 1;
			}
		}
	}

	/**
	 * @description 二分查找算法
	 * @author rico
	 * @created 2017年6月26日 下午3:53:02
	 */
	public int binarySearch(int[] array, int from, int to, int k) {
		if (from > to) { // 递归终止条件
			return -1; // 简单情景下的处理
		} else {
			int mid = (from + to) / 2;
			if (array[mid] == k) {
				return mid;
			} else if (array[mid] < k) {
				return binarySearch(array, mid + 1, to, k); // 去右子序列查找
			} else {
				return binarySearch(array, from, mid - 1, k); // 去左子序列查找
			}
		}
	}

	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		int[] array = { 3, 3, 3, 3, 4, 5 };
		int k = 3;
		System.out.println(s1.binarySearch(array, 0, array.length - 1, k));
		System.out.println(s1.GetNumberOfK(array, k));
	}
}
