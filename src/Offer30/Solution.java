package Offer30;

import java.util.ArrayList;

/**
 * Title: 最小的K个数 
 * Description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。
 * 
 * @author rico
 * @created 2017年6月2日 下午9:17:15
 */
public class Solution {
	  
	/**     
	 * @description 通过堆调整算法找出最小K个元素，时间复杂度 O(nlgn)
	 * @author rico       
	 * @created 2017年6月2日 下午10:19:47     
	 * @param input
	 * @param k
	 * @return     
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (input != null && k > 0 && k <= input.length) {
			
			// 调整为最小堆: O(nlgn) = O(n) * O(lgn)
			int pos = (input.length - 2) / 2;
			while (pos >= 0) {          // O(n)
				shiftDown(input, pos, input.length - 1);  // O(lgn)
				pos--;
			}

			// 通过堆调整算法获取最小K个元素
			int end = input.length - 1;
			for (int i = 0; i < k; i++) {   // K
				int temp = input[0];
				input[0] = input[end];
				input[end] = temp;
				end--;
				shiftDown(input, 0, end);  // O(lgn)
				list.add(temp);
			}
		}
		return list;
	}

	  
	/**     
	 * @description 堆调整算法，自上向下调整(各子树均为最小堆)
	 * @author rico       
	 * @created 2017年6月2日 下午10:16:19     
	 * @param input 待调整数组
	 * @param start 调整范围：起始位置
	 * @param end   调整范围：终止位置  
	 */
	public void shiftDown(int[] input, int start, int end) {
		int i = start;
		int j = 2 * start + 1;
		int temp = input[i];
		while (j <= end) {
			if (j < end) {  // 找出最小的子女
				j = input[j] < input[j + 1] ? j : j + 1;
			}
			if (input[j] < temp) {   // 自上而下不断调整为最小堆
				input[i] = input[j];
				i = j;
				j = 2 * i + 1;
			} else {  // 已是最小堆，不用调整，直接退出
				break;
			}
		}
		input[i] = temp;
	}

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(new Solution().GetLeastNumbers_Solution(input, 4));
	}
}
