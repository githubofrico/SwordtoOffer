package NumOverHalfInArray29;

/**
 * Title:数组中出现次数超过一半的数字 
 * Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次， 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * @author rico
 * @created 2017年6月2日 下午4:55:15
 */
public class Solution {
	/**     
	 * @description 如果数组中存在出现次数超过一半的数字，那么其必然是array[array.length/2];
	 * 换句话说，如果array[array.length/2]出现的次数没有超过一半，那么就不存在这样的数字
	 * @author rico       
	 * @created 2017年6月2日 下午6:18:51     
	 * @param array
	 * @return     
	 */
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array != null && array.length != 0) {
			int mid = array[array.length / 2];    
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				if (mid == array[i]) {
					count++;
				}
			}
			return count > array.length / 2 ? mid : 0;
		}
		return 0;
	}
}
