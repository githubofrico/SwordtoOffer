package FindNumsAppearOnce40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:数组中只出现一次的数字 (使用哈希表求解)
 * Description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @author rico
 * @created 2017年6月28日 下午5:11:23
 */
public class Solution {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : array) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {  // 第二次出现的数字在哈希表中删除即可
				map.remove(i);
			}
		}

		List<Integer> list = new ArrayList<Integer>(map.keySet());
		num1[0] = list.get(0);
		num2[0] = list.get(1);
	}
}