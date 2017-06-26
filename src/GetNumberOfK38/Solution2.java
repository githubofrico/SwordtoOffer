package GetNumberOfK38;

/**
 * Title: 数字在排序数组中出现的次数(二分查找算法的变形 ：查找数字k首次出现位置和末次出现位置) 
 * Description: 统计一个数字在排序数组中出现的次数。
 * 
 * 算法时间复杂度：O(lgN)
 * 
 * @author rico
 * @created 2017年6月25日 下午4:47:51
 */
public class Solution2 {
	public int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0) { // 边界条件
			return 0;
		} else if (k < array[0] || k > array[array.length - 1]) { // 边界条件
			return 0;
		} else {
			// 先查找数字k首次出现的位置:O(lgN)
			int first = getFirstK(array, 0, array.length - 1, k);
			// 再查找数字k最后出现的位置:O(lgN)
			int last = getLastK(array, 0, array.length - 1, k);

			if (first == -1 || last == -1) {
				return 0;
			} else {
				return last - first + 1;
			}
		}
	}

	/**
	 * @description 二分查找算法的改进，找第一个K出现的位置
	 * @author rico
	 * @created 2017年6月26日 下午3:53:02
	 */
	public int getFirstK(int[] array, int from, int to, int k) {
		if (from > to) { // 递归终止条件
			return -1; // 简单情景下的处理
		} else {
			int mid = (from + to) / 2;
			if (array[mid] == k) {
				if (mid > 0 && array[mid - 1] == k) {
					return getFirstK(array, from, mid - 1, k);
				}
				return mid;
			} else if (array[mid] < k) {
				return getFirstK(array, mid + 1, to, k); // 去右子序列查找
			} else {
				return getFirstK(array, from, mid - 1, k); // 去左子序列查找
			}
		}
	}

	/**
	 * @description 二分查找算法的改进，找最后一个K出现的位置
	 * @author rico
	 * @created 2017年6月26日 下午3:53:02
	 */
	public int getLastK(int[] array, int from, int to, int k) {
		if (from > to) { // 递归终止条件
			return -1; // 简单情景下的处理
		} else {
			int mid = (from + to) / 2;
			if (array[mid] == k) {
				if (mid < array.length - 1 && array[mid + 1] == k) {
					return getLastK(array, mid + 1, array.length - 1, k);
				}
				return mid;
			} else if (array[mid] < k) {
				return getLastK(array, mid + 1, to, k); // 去右子序列查找
			} else {
				return getLastK(array, from, mid - 1, k); // 去左子序列查找
			}
		}
	}

	public static void main(String[] args) {
		Solution2 s1 = new Solution2();
		int[] array = { 3, 3, 3, 3, 3, 3 };
		int k = 3;
		System.out.println("数字 " + k + " 首次出现的位置 ： "
				+ s1.getFirstK(array, 0, array.length - 1, k));
		System.out.println("数字 " + k + " 最后出现的位置 ： "
				+ s1.getLastK(array, 0, array.length - 1, k));
		System.out.println(s1.GetNumberOfK(array, k));
	}
}
