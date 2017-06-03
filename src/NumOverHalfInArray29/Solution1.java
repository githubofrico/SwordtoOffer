package NumOverHalfInArray29;

/**
 * Title:数组中出现次数超过一半的数字 -----> 转换成求中位数问题
 * Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次， 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * @author rico
 * @created 2017年6月2日 下午4:55:15
 */
public class Solution1 {
	
	/**
	 * @description 若数组中存在出现次数超过一半的数字，则其必然是数组的中位数；
	 * 反之，中位数则不一定是数组中出现次数超过一半的数字。因此，先根据快排的划分算法，
	 * 不断对序列进行划分，找到中位数，然后验证中位数是否符合题目要求。
	 * 
	 * 中位数：对于有限的数集，可以通过把所有观察值高低排序后找出正中间的一个作为中位数。
	 * 
	 * @author rico
	 * @created 2017年6月3日 上午8:38:04
	 * @param input 原始序列
	 * @param k 第K大元素
	 * @return
	 */
	 public int MoreThanHalfNum_Solution(int[] input) {
		int target = 0; // 存储目标值
		int count = 0;   // 计数，验证
		int n = input.length;   // 给定序列长度
		int mid = n/2;     // 中位
		if (input != null && input.length != 0) {
			int start = 0;
			int end = n - 1;
			int index = partition(input, start, end);
			while (index != mid) { // 循环终止条件：划分的正好
//			System.out.println(Arrays.toString(input));
				if (index > mid) {
					end = index - 1;
					index = partition(input, start, end);
				} else {
					start = index + 1;
					index = partition(input, index + 1, end);
				}
			}
			
			// 找到中位数
			target = input[index];
			
			//检查该数字出现次数是否超过一半
			for (int i = 0; i < input.length; i++) {
				if (target == input[i]) {
					count ++;
				}
			}
		}
		return count > n/2 ? target : 0;
	}

	/**
	 * @description 快排的划分算法,时间复杂度O(n)
	 * @author rico
	 * @created 2017年6月3日 上午8:17:54
	 * @param input
	 * @param start
	 * @param end
	 * @return
	 */
	private int partition(int[] input, int start, int end) {
		int base = input[start];
		int base_index = start;
		for (int i = 1 + start; i <= end; i++) {
			if (input[i] < base) {
				base_index++;
				if (base_index != i) {
					int temp = input[base_index];
					input[base_index] = input[i];
					input[i] = temp;
				}
			}
		}
		input[start] = input[base_index];
		input[base_index] = base;
		return base_index;
	}

	public static void main(String[] args) {
		int[] input = {1,2,3,2,2,2,5,4,2};
		System.out.println(new Solution1().MoreThanHalfNum_Solution(input));
	}
}

