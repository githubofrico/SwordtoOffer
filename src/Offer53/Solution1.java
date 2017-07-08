package Offer53;

/**
 * Title:正则表达式匹配 Description:请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'
 * 表示它前面的字符可以出现任意次
 * （包含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 * 
 * @author rico
 * @created 2017年7月3日 下午7:22:57
 */
public class Solution1 {

	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) { // 边界条件:字符串与模式串有一个为空,返回false
			return false;
		} else {
			if (str.length == 0 && pattern.length == 0) { // 边界条件:字符串与模式串长度均为0
				return true;
			} else if (str.length != 0 && pattern.length == 0) { // 边界条件:字符串长度为0，模式串长度不为0
				return false;
			} else {	 // 匹配处理
				return matchCore(str, pattern, 0, 0, str.length, pattern.length);
			}
		}
	}

	/**
	 * @description 字符串匹配核心算法，递归穷举法(迭代法不好做)
	 * @author rico
	 * @created 2017年7月6日 下午1:40:07
	 * @param str
	 *            字符串
	 * @param pattern
	 *            模式串
	 * @param p1
	 *            字符串指针
	 * @param p2
	 *            模式串指针
	 * @param n1
	 *            字符串长度
	 * @param n2
	 *            模式串长度
	 * @return 是否匹配
	 */
	public boolean matchCore(char[] str, char[] pattern, int p1, int p2,
			int n1, int n2) {
		if (p1 == n1 && p2 == n2) { 	// 递归终止条件：字符串指针、模式串指针同时扫描完毕
			return true;
		} else if (p1 != n1 && p2 == n2) { 	// 递归终止条件：字符串指针未扫描完毕，模式串指针扫描完毕
			return false;
		} else {  	//字符串和模式串都未扫描完毕，或者字符串扫描完毕但模式串未扫描完毕
			// 模式串当前字符的下一个字符为'*'
			if (p2 + 1 < n2 && pattern[p2 + 1] == '*') {
				if ((pattern[p2] == '.' && p1 < n1)
						|| (p1 < n1 && str[p1] == pattern[p2])) { // 注意p1指针的越界情况
					// 穷举所有情况
					return matchCore(str, pattern, p1 + 1, p2 + 2, n1, n2) // 字符串移动1位，模式串移动2位
							|| matchCore(str, pattern, p1 + 1, p2, n1, n2) // 字符串移动1位，模式串不移动
							|| matchCore(str, pattern, p1, p2 + 2, n1, n2); // 字符串不移动，模式串移动1位
				} else { // 模式串与字符串对应字符不匹配，或者字符串扫描到末尾但模式串还未到末尾(且其下一个字符是'*')
					return matchCore(str, pattern, p1, p2 + 2, n1, n2);
				}
			}

			// 模式串当前字符的下一个字符不为'*'
			if ((pattern[p2] == '.' && p1 < n1)
					|| (p1 < n1 && str[p1] == pattern[p2])) {
				return matchCore(str, pattern, p1 + 1, p2 + 1, n1, n2);
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String str = "aaa";
		String pattern = "ab*a*c*a";
		System.out.println(s.match(str.toCharArray(), pattern.toCharArray()));
	}
}
