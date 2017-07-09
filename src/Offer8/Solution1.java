package Offer8;

/**
 * Title: 旋转数组的最小数字 (二分搜索的应用，序列有序或者部分有序) —— 递归算法和非递归算法 
 * Description:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * @author rico
 * @created 2017年6月4日 上午11:26:50
 */
public class Solution1 {
	public int minNumberInRotateArray(int[] array) {
		return minNumberInRotateArray(array, 0, array.length - 1);
	}

	/**
	 * @description 折半搜索，并判断最小元素位于哪个子序列：前子序列或者后子序列
	 * @author rico
	 * @created 2017年6月4日 下午1:42:12
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public int minNumberInRotateArray(int[] array, int low, int high) {
		int mid = 0;
		while (array[low] >= array[high]) {
			if (high - low == 1) { // 循环退出条件
				mid = high;
				break;
			}

			mid = (low + high) / 2;
			if (array[mid] >= array[low]) { // 最小值只可能位于它的右边(包括自身)
				low = mid;
			} else if (array[mid] <= array[high]) { // 最小值只可能位于它的左边(包括自身)
				high = mid;
			}

		}
		return array[mid];
	}

	  
	/**     
	 * @description 折半搜索，并判断最小元素位于哪个子序列：前子序列或者后子序列
	 * @author rico       
	 * @created 2017年6月4日 下午2:01:43     
	 * @param array
	 * @param low
	 * @param high
	 * @return     
	 */
	public int minNumberInRotateArray_Recursive(int[] array, int low, int high) {
		if (high - low != 1) {   			// 递归终止条件
			int mid = (low + high) / 2;
			if (array[mid] >= array[low]) {
				return minNumberInRotateArray_Recursive(array, mid, high);  
			} else if (array[mid] <= array[high]) {
				return minNumberInRotateArray_Recursive(array, low, mid);
			}
		}
		return array[high];
	}

	public static void main(String[] args) {
		int[] input = { 1, 1, 1, 1, 1 };
		System.out.println(new Solution1().minNumberInRotateArray(input));
	}
}
