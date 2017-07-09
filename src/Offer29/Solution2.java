package Offer29;

/**
 * Title:数组中出现次数超过一半的数字 
 * Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次， 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * @author rico
 * @created 2017年6月2日 下午4:55:15
 */
public class Solution2 {

	/**
	 * @description 数组中有一个数字出现的次数超过数组长度的一半,
	 * 那么这个数字出现的次数比其他所有数字出现次数的和还要多。
	 * 
	 * 使用两个变量A和B，其中A存储数组中的某个数，B用来计数。开始时将B初始化为0。 
	 * 遍历数组，如果B=0，则令A等于当前数，令B等于1；如果当前数与A相同，则B=B+1；
	 * 如果当前数与A不同，则令B=B-1。遍历结束时，A中的数就是要找的数。
	 *  
	 * @author rico
	 * @created 2017年6月2日 下午8:48:10
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array != null && array.length != 0) {
			int target = 0;  // 存储数组中的某个数
			int count = 0;    // 计数
			for (int i = 0; i < array.length; i++) {
				if (count == 0) {  
					target = array[i];  
					count = 1;   
				} else {
					if (target == array[i]) {
						count++;
					} else {
						count--;
					}
				}
			}

			// 验证Target是否是所求数字
			if (count > 0) {   // 若最终的count不大于0，必然不存在上述需要的数字
				count = 0;  // 统计target出现次数
				for (int i = 0; i < array.length; i++) {
					if (target == array[i]) {
						count++;
					}
				}
				return count > array.length / 2 ? target : 0;
			}
		}
		return 0;
	}

	/**
	 * @description
	 * @author rico
	 * @created 2017年6月2日 下午8:43:55
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(new Solution2().MoreThanHalfNum_Solution(array));
	}
}
