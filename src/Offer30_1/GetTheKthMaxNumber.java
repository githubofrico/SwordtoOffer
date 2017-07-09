package Offer30_1;

import java.util.Arrays;
import java.util.Random;

/**        
 * Title: 元素序列第K大元素    
 * Description: 第K大元素一定是存在的，因为排序后我们就可以直接找到它。该算法见解快排的划分算法，
 * 不断对序列进行划分，直到某次划分完成后基准元素的位置是第n-k个。算法的时间复杂度是O(n)。
 * @author rico       
 * @created 2017年6月3日 下午2:11:48    
 */      
public class GetTheKthMaxNumber {
	/**
	 * @description 第K大元素一定是存在的，因为排序后我们就可以直接找到它。
	 * 该算法见解快排的划分算法，不断对序列进行划分，直到某次划分完成后基准元素的位置是第n-k个。
	 * @author rico
	 * @created 2017年6月3日 上午8:38:04
	 * @param input 原始序列
	 * @param k 第K大元素
	 * @return
	 */
	public int getTheKthMaxNumber(int[] input, int k) {
		int target = -1;
		if (input != null && k > 0 && k <= input.length) {
			int n = input.length;
			int start = 0;
			int end = n - 1;
			int index = partition(input, start, end);
			while (index != n - k) { // 循环终止条件：划分的正好
			// System.out.println(Arrays.toString(input));
				if (index > n - k) {
					end = index - 1;
					index = partition(input, start, end);
				} else {
					start = index + 1;
					index = partition(input, index + 1, end);
				}
			}
			target = input[index];
		}
		return target;
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
	public int partition(int[] input, int start, int end) {
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

		int[] input = new int[1000];
		for (int i = 0; i < input.length; i++) {
			input[i] = new Random().nextInt(10000);
		}

		System.out.println("原数组 ： " + Arrays.toString(input));

		int k = 4;
		System.out.println("第 " + k + " 大元素： "
				+ new GetTheKthMaxNumber().getTheKthMaxNumber(input, k));
		System.out.println("划分结束后的数组(找到目标值时的数组) ： " + Arrays.toString(input));
		Arrays.sort(input);
		System.out.println("排序后的数组(验证) ： " + Arrays.toString(input));
	}
}
