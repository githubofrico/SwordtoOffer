package Offer64;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Title:数据流中的中位数
 * Description:如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值
 * 。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 
 * @author rico
 * @created 2017年7月9日 上午9:46:05
 */
public class Solution1 {

	List<Integer> list = new ArrayList<Integer>();

	public void Insert(Integer num) {
		list.add(num);
	}

	public Double GetMedian() {
		Collections.sort(list);
		int size = list.size();
		if (size != 0) {
			if ((size & 1) == 1) {
				return Double.valueOf(String.valueOf(list.get(size / 2)));
			} else {
				double result = list.get(size/2) + list.get((size / 2)-1);
				result /= 2;
				return result;
			}
		}
		return null;
	}
}