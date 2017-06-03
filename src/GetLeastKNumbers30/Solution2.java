package GetLeastKNumbers30;

import java.util.ArrayList;

/**
 * Title: 最小的K个数 
 * Description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。
 * 
 * @author rico
 * @created 2017年6月2日 下午9:17:15
 */
public class Solution2 {

	/**
	 * @description 通过最大堆算法找出最小K个元素，时间复杂度 O(nlgK)，空间复杂度O(K),适合海量数据查找
	 * @author rico
	 * @created 2017年6月2日 下午10:19:47
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>(k); // 存储最小K个元素
		int[] target = new int[k]; // 存储最小K个元素
		if (input != null && k > 0 && k <= input.length) {
			for (int i = 0; i < input.length; i++) {
				if (i < k) { // 创建大小为K的最大堆: O(KlgK) = O(K) * O(lgK)
					target[i] = input[i];
					shiftUp(target, 0, i); // 自下向上调整为最大堆
				} else {
					int max = target[0]; // O(1)
					if (max > input[i]) {
						target[0] = input[i]; // 删除最大元素并替换成新读入元素
						shiftDown(target, 0, k - 1); // 自上向下调整为最大堆,O(lgK)
					} else {
						continue;
					}
				}
			}

			// 将target中的元素转存到list中
			for (int i = 0; i < k; i++) {
				list.add(target[i]);
			}
		}
		return list;
	}

	/**
	 * @description 堆调整算法，自上向下调整(原来是最大堆，删除、替换堆顶元素，调整为最大堆)
	 * @author rico
	 * @created 2017年6月2日 下午10:16:19
	 * @param input
	 *            待调整数组
	 * @param start
	 *            调整范围：起始位置
	 * @param end
	 *            调整范围：终止位置
	 */
	public void shiftDown(int[] input, int start, int end) {
		int i = start;
		int j = 2 * start + 1;
		int temp = input[i];
		while (j <= end) {
			if (j < end) { // 找出最大的子女
				j = input[j] > input[j + 1] ? j : j + 1;
			}
			if (input[j] > temp) { // 自上而下不断调整为最大堆
				input[i] = input[j];
				i = j;
				j = 2 * i + 1;
			} else { // 已是最大堆，不用调整，直接退出
				break;
			}
		}
		input[i] = temp;
	}

	/**
	 * @description 堆调整算法，自下向上调整(原来是最大堆，在堆尾插入新元素，调整为最大堆)
	 * @author rico
	 * @created 2017年6月3日 上午10:35:10
	 * @param input
	 *            待调整数组
	 * @param start
	 *            调整范围：起始位置
	 * @param end
	 *            调整范围：终止位置
	 */
	public void shiftUp(int[] input, int start, int end) {
		int i = (end - 1) / 2;
		int j = end;
		int temp = input[j];
		while (j > 0) { // 循环终止条件：调整到堆顶后停止
			if (input[i] < temp) {
				input[j] = input[i];
				j = i;
				i = (j - 1) / 2;
			} else {
				break;
			}
		}
		input[j] = temp;
	}

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(new Solution2().GetLeastNumbers_Solution(input, 4));
	}
}
