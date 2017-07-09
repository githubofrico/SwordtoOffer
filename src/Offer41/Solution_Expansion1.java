package Offer41;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Title:和为S的正数序列(不要求连续，递归方法)
 * Description: 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good
 * Luck!
 * 
 * 输出描述: 输出所有和为S的正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 
 * @author rico
 * @created 2017年6月28日 下午8:18:42
 */

public class Solution_Expansion1 {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (sum < 3) {     // 递归终止条件
			return result;     // 简单情景下的处理
		} else {
			for (int i = 1; i < sum - i; i++) {    // 缩小范围，递归处理
				result.add(new ArrayList<Integer>(Arrays.asList(i, sum - i)));
				ArrayList<ArrayList<Integer>> list = FindContinuousSequence(sum
						- i);
				if (list != null) {
					for (ArrayList<Integer> tmpList : list) {
						if (tmpList.get(0) > i) {
							// System.out.println("tmpList : " + tmpList);
							ArrayList<Integer> tmp = new ArrayList<Integer>();
							tmp.add(i);
							tmp.addAll(tmpList);
							result.add(tmp);
						}
					}
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution_Expansion1 s = new Solution_Expansion1();
		int sum = 15;
		System.out.println(s.FindContinuousSequence(sum));
	}
}
