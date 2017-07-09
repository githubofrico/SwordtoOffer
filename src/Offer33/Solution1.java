package Offer33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Title:把数组排成最小的数
 * Description:输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组
 * {3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author rico
 * @created 2017年6月21日 上午9:08:42
 */
public class Solution1 {
	public String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return "";
		} else if (numbers.length == 1) {
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
				int min = Math.min(s1.length(), s2.length());
				for (int i = 0; i < min; i++) {
					if (i < s2.length()) {
						if (s1.charAt(i) > s2.charAt(i)) {
							return 1;
						} else if (s1.charAt(i) < s2.charAt(i)) {
							return -1;
						} else {
							continue;
						}
					}
				}
				
				if (s1.length() > min) {
					for (int j = min; j < s1.length(); j++) {
						if (s2.charAt(min-1) > s1.charAt(j)) {
							return -1;
						} else if (s2.charAt(min-1) < s1.charAt(j)) {
							return 1;
						} else {
							if (j == s1.length()-1) {
								return 0;
							}
							continue;
						}
					}
				}else{
					for (int j = min; j < s2.length(); j++) {
						if (s1.charAt(min-1) > s2.charAt(j)) {
							return 1;
						} else if (s1.charAt(min-1) < s2.charAt(j)) {
							return -1;
						} else {
							if (j == s2.length()-1) {
								return 0;
							}
							continue;
						}
					}
				}
				return 0;
			}
		});
	}
}
