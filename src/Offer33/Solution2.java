package Offer33;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:把数组排成最小的数(利用全排列暴力比较法)
 * Description:输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组
 * {3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author rico
 * @created 2017年6月21日 上午9:08:42
 */     
public class Solution2 {

	public String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0 ) {
			return "";
		}else if (numbers.length == 1) {
			return String.valueOf(numbers[0]);
		}else{
			List<String> list = getAllPermutations(numbers, 0, numbers.length - 1);
			String min = list.get(0);
			for (String str : list) {
				if (Long.valueOf(min) > Long.valueOf(str)) {
					min = str;
				}
			}
			return min;
		}
	}

	  
	/**     
	 * @description 全排列算法
	 * @author rico       
	 * @created 2017年6月21日 下午1:46:40     
	 * @param numbers
	 * @param from
	 * @param to
	 * @return     
	 */
	public List<String> getAllPermutations(int[] numbers, int from, int to) {
		List<String> list = new ArrayList<String>();
		if (numbers != null) {
			if (from == to) {
				list.add(String.valueOf(numbers[from]));
				return list;
			} else {
				for (int i = from; i <= to; i++) {
					swap(numbers, i, from);
					int first = numbers[from];
					List<String> tmpList = getAllPermutations(numbers,
							from + 1, to);
					for (String str : tmpList) {
						list.add(first + str);
					}
					swap(numbers, from, i);

				}
				return list;
			}
		}
		return list;
	}

	/**     
	 * @description 对调交换
	 * @author rico       
	 * @created 2017年6月21日 下午1:46:59     
	 * @param s
	 * @param from
	 * @param to     
	 */
	public static void swap(int[] s, int from, int to) {
		int temp = s[from];
		s[from] = s[to];
		s[to] = temp;
	}

	public static void main(String[] args) {
		Solution2 s1 = new Solution2();
		int[] numbers = { 3334,3,3333332 };
		System.out.println(s1
				.getAllPermutations(numbers, 0, numbers.length - 1).size());
		System.out.println(s1
				.getAllPermutations(numbers, 0, numbers.length - 1));
		System.out.println(s1.PrintMinNumber(numbers));
	}
}
