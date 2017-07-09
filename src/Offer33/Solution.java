package Offer33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Title:把数组排成最小的数(定义新的Comparator，创建新的排序规则)，本质上是一个排序问题
 * Description:输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组
 * {3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author rico
 * @created 2017年6月21日 上午9:08:42
 */
public class Solution {
	public String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0) { // 边界条件
			return "";
		} else if (numbers.length == 1) { // 边界条件
			return String.valueOf(numbers[0]);
		} else {
			List<Integer> list = new ArrayList<Integer>();
			for (int tmp : numbers) {
				list.add(tmp);
			}

			// 创建新的排序规则
			sort(list);
			System.out.println(list);

			StringBuilder sb = new StringBuilder();
			for (Integer tmp : list) {
				sb.append(tmp);
			}
			return sb.toString();
		}
	}

	/**
	 * @description 为Integer定义新的排序规则
	 * @author rico
	 * @created 2017年6月21日 下午3:07:46
	 * @param list
	 */
	public void sort(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String s1 = String.valueOf(o1);
				String s2 = String.valueOf(o2);
				// 计算二者长度，并找到较大长度
				int n = Math.max(s1.length(), s2.length()); 
				
				// 将长度较短的数字用其末位补齐，直到 s1与s2长度相等
				if (s1.length() > s2.length()) {
					StringBuilder sb = new StringBuilder(s2);
					char c = s2.charAt(s2.length() - 1);
					for (int i = s2.length(); i < n; i++) {
						sb.append(c);
					}
					s2 = sb.toString();
				} else if (s1.length() < s2.length()) {
					StringBuilder sb = new StringBuilder(s1);
					char c = s1.charAt(s1.length() - 1);
					for (int i = s1.length(); i < n; i++) {
						sb.append(c);
					}
					s1 = sb.toString();
				}
				
				// 逐位比较
				for (int i = 0; i < n; i++) {
					if (s1.charAt(i) > s2.charAt(i)) {
						return 1;
					} else if (s1.charAt(i) < s2.charAt(i)) {
						return -1;
					} else {
						continue;
					}
				}
				return 0;
			}
		});
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = { 3334, 3, 3333332 };
		System.out.println(s.PrintMinNumber(numbers));
	}
}
