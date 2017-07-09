package Offer8;

/**        
 * Title: 旋转数组的最小数字    
 * Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author rico       
 * @created 2017年6月4日 上午11:26:50    
 */      
public class Solution2 {

	/**     
	 * @description 先顺序查找旋转点[O(n)],再返回最小元素[O(1)]，总的时间复杂度O(n)
	 * @author rico       
	 * @created 2017年6月4日 上午11:24:41     
	 * @param array
	 * @return     
	 */
	public int minNumberInRotateArray(int[] array) {
		if (array != null || array.length == 0 ) {
			if (array.length != 1) {
				// 顺序查找旋转点:O(n)
				int index = 0;
				for (int i = 0; i < array.length; i++) {
					if (i + 1 < array.length) {
						if (array[i+1] < array[i]) {
							index = i + 1;
							break;
						}
					}
				}
				
				// 二分查找
				return array[index];
			}
			return array[0];
		}
		return 0;
	}
}
