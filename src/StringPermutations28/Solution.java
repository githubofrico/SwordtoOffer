package StringPermutations28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Title: 字符串的排列(递归法)
 * Description:
 * 输入一个字符串(长度不超过9(可能有字符重复),字符只包括大小写字母),按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * @author rico
 * @created 2017年6月18日 下午4:49:30
 */
public class Solution {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> strs = new ArrayList<String>();
		if (str == null || str.length() == 0) {    // 边界条件
			return strs;
		} else if (str.length() == 1) {  // 递归终止条件
			strs.add(str);  // 简单情景下的处理
			return strs;
		} else {   // 缩小规模，递归调用
			for (int i = 0; i < str.length(); i++) {
				String s = swap(str, i);
				ArrayList<String> tmp = Permutation(s.substring(1));
				for (String string : tmp) {
					strs.add(s.charAt(0) + string);
				}
			}

			// 以下代码解决字符重复问题
			Collections.sort(strs);  // 首先对结果进行排序
			// 然后扫描整个序列，将重复的字符串删除
			String s = null;  
			for (Iterator<String> iterator = strs.iterator(); iterator
					.hasNext();) {
				if (s == null) {
					s = (String) iterator.next();
				}
				while (iterator.hasNext()) {   // 删除重复字符串
					String tmp = (String) iterator.next();
					if (s.equals(tmp)) {
						iterator.remove();  // 使用迭代器的删除，否则容易导致快速失败
					} else {
						s = tmp;
						break;
					}
				}
			}
			return strs;
		}
	}

	  
	/**     
	 * @description 将字符串中指定位置的字符与字符串首字符交换
	 * @author rico       
	 * @created 2017年6月18日 下午4:59:07     
	 * @param s 目标字符串
	 * @param i 
	 * @return     
	 */
	private String swap(String s, int i) {
		char c1 = s.charAt(0);
		char c2 = s.charAt(i);
		if (i == 0) {
			return s;
		}
		return c2 + s.substring(1, i) + c1 + s.substring(i + 1, s.length());
	}

	public static void main(String[] args) {
		ArrayList<String> strs = new Solution().Permutation("aab");
		Collections.sort(strs);
		System.out.println(strs);
		String s = null;
		for (Iterator<String> iterator = strs.iterator(); iterator.hasNext();) {
			if (s == null) {
				s = (String) iterator.next();
			}
			while (iterator.hasNext()) {
				String tmp = (String) iterator.next();
				if (s.equals(tmp)) {
					iterator.remove();  
				} else {
					s = tmp;
					break;
				}
			}
		}
		System.out.println(strs);
	}
}
