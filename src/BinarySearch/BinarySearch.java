package BinarySearch;

/**
 * Title: 二分查找的实现 
 * Description: 递归 + 非递归
 * 
 * @author rico
 */
public class BinarySearch {

	/**     
	 * @description 递归搜索目标值，若搜索成功，则返回目标值的次序(从1开始)；否则，返回-1
	 * @author rico       
	 * @param arr 目标数组
	 * @param high 右边界
	 * @param low 左边界
	 * @param target 目标值
	 * @return     
	 */
	public static int binarySearch(int[] arr, int high, int low, int target) {
		
		if (high >= low) { // 递归终止条件
			int mid = (high + low) >> 1;
			if (arr[mid] == target) {
				return mid + 1;
			} else if (arr[mid] > target) { //arr[mid]肯定不是目标值，可剔出搜索范围
				return binarySearch(arr, mid - 1, low, target);  // 递归搜索，缩小问题的规模
			} else { //arr[mid]肯定不是目标值，可剔出搜索范围
				return binarySearch(arr, high, mid + 1, target);  // 递归搜索，缩小问题的规模
			}
		}
		return -1;
	}
	
	/**     
	 * @description 二分查找的非递归实现
	 * @author rico       
	 * @param arr 目标数组
	 * @param high 右边界
	 * @param low 左边界
	 * @param target 目标值
	 * @return     
	 */
	public static int binarySearch_Loop(int[] arr, int high, int low, int target) {
		
		while (high >= low) { // 循环终止条件
			int mid = (high + low) >> 1;
			if (arr[mid] == target) {
				return mid + 1;
			} else if (arr[mid] > target) { 
				high = mid -1;   //arr[mid]肯定不是目标值，可剔出搜索范围
			} else { 
				low = mid + 1;   //arr[mid]肯定不是目标值，可剔出搜索范围
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3};
		System.out.println("Recursive : " + binarySearch(arr, arr.length-1, 0, 3));
		System.out.println("Loop : " + binarySearch(arr, arr.length-1, 0, 3));
	}
}
