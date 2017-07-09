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
public class GreatestSolution {
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
	 * @description 为Integer定义新的排序规则,巧妙地比较大小
	 * @author rico
	 * @created 2017年6月21日 下午3:07:46
	 * @param list
	 */
	public void sort(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {
			/** 
			 * @description o1o2与o2o1长度大小相同，要想比较o1与o2的大小，只需比较o1o2与o2o1的大小
			 * @author rico       
			 * @created 2017年6月21日 下午3:51:19      
			 * @param o1
			 * @param o2
			 * @return     
			 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)     
			 */  
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String s1 = String.valueOf(o1) + String.valueOf(o2);
				String s2 = String.valueOf(o2) + String.valueOf(o1);
				if (Long.valueOf(s1) > Long.valueOf(s2)) {  // 用Long比较，大数问题
					return 1;
				}else if(Long.valueOf(s1) < Long.valueOf(s2)){
					return -1;
				}else{
					return 0;
				}
			}
		});
	}

	public static void main(String[] args) {
		GreatestSolution s = new GreatestSolution();
		int[] numbers = { 3334, 3, 3333332 };
		System.out.println(s.PrintMinNumber(numbers));
	}
}
