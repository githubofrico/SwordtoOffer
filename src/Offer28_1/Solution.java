package Offer28_1;

import java.util.ArrayList;
import java.util.List;
  
/**        
 * Title:字符串的所有字符的组合(分治 + 递归) 
 * Description: 给定一个字符串，求这个字符串所包含字符的所有组合
 * 分三步走：字符串中重复字符去重，分别获取含1...n个字符的组合，将上一步所得到的所有组合合并 
 * @author rico       
 * @created 2017年6月18日 下午6:03:20    
 */      
public class Solution {

	/**     
	 * @description 给定一个字符串，求这个字符串所包含字符的所有组合 
	 * @author rico       
	 * @created 2017年6月18日 下午5:46:26     
	 * @param s
	 * @return     
	 */
	public static List<String> getStringCombinations(String s) {
		s = deleteRepeatChar(s);
		List<String> list = new ArrayList<String>();
		if (s == null) {
			return list;
		}else{
			for (int i = 1; i <= s.length(); i++) {
				list.addAll(getStringCombinations(s, i));
			}
		}
		return list;
	}

	/**
	 * @description 含n个字符的字符串s中的含m个字符的所有组合
	 * @author rico
	 * @created 2017年6月18日 下午5:14:15
	 * @param s
	 * @param n
	 * @param m
	 * @return
	 */
	public static List<String> getStringCombinations(String s, int m) {
		List<String> list = new ArrayList<String>();
		if (s.length() < m) { // 边界条件
			return list;
		}else if (s.length() == m) {  // 递归终止条件：s恰好包含m个字符
			list.add(s);
			return list;
		} else if (m == 1) {   // 递归终止条件：字符串s的所有组合中只包含一个字符的组合 
			char[] chars = s.toCharArray();
			for (char c : chars) {
				list.add(String.valueOf(c));
			}
			return list;
		} else {   // 缩小问题范围，开始递归:分两种情况
			
			// 首字符 + 从除首字符除外的剩下m-1个字符中选取m-1个字符
			List<String> tmp = getStringCombinations(s.substring(1), m - 1);
			for (String str : tmp) {
				list.add(s.charAt(0) + str);
			}
			
			// 从首字符除外的剩下m-1个字符中选取m个字符
			list.addAll(getStringCombinations(s.substring(1), m));
			return list;
		}
	}
	
	  
	/**     
	 * @description 字符串去除重复字符(删除重复字符，使字符串各 字符互异)，递归算法
	 * @author rico       
	 * @created 2017年6月18日 下午5:59:58     
	 * @param target
	 * @return     
	 */
	public static String deleteRepeatChar(String target){
		if (target == null) {
			return target;
		}else if (target.length() == 1) {
			return target;
		}else{
			char c = target.charAt(0);
			String temp = deleteRepeatChar(target.substring(1));
			temp = temp.replaceAll(String.valueOf(c), "");
			return c + temp;
		}
	}
	
	public static void main(String[] args) {
		String test = "abcbcd";
		System.out.println(getStringCombinations(test));
		
		System.out.println(deleteRepeatChar("adasada"));
	}
}
