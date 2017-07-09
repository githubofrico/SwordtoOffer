package Offer35;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Title:第一个只出现一次的字符(使用LinkedHashMap作存储结构)
 * Description: 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @author rico
 * @created 2017年6月24日 上午8:51:27
 */

public class Solution {
	public int FirstNotRepeatingChar(String str) {
		if (str != null && str.length() != 0) {
			// 存储字符串各字符及其位置，若字符重复，则将其位置设为-1
			LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();  // 维持插入顺序
			for (int i = 0; i < str.length(); i++) {
				Character key = str.charAt(i);
				if (!map.containsKey(key)) {
					map.put(key, i);
				} else {
					map.put(key, -1);
				}
			}
			System.out.println(map);
			Set<Map.Entry<Character, Integer>> set = map.entrySet();
			for (Map.Entry<Character, Integer> entry : set) {  //LinkedHashMap遍历顺序是插入顺序 
				if (entry.getValue() != -1) {
					return entry.getValue();
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "google";
		System.out.println(s.FirstNotRepeatingChar(str));
	}
}
