package StringPermutations;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: 字符串全排列 
 * Description: 字符串 str 的全排列是字符串 str 的子串 (str除去第一位的字符组成的字符串)的全排列结果
 * 和字符 c (str第一个位置的字符)的运算结果
 * 
 * 三种递归解法(第一种解法与后两种解法在具体处理逻辑上稍有不同)
 * 
 * 第三种解法是常考面试题
 * 
 * @author rico
 */
public class StringPermutationsRecursive {

	/**
	 * @description 先求str.substring(1)的全排列，在此结果上，求得str的全排列
	 * @author rico
	 * @param str
	 *            目标字符串
	 * @return 目标字符串的全排列
	 */
	public static List<String> getStringPermutations1(String str) {

		// 用于存储全排列结果
		List<String> list = new ArrayList<String>();

		if (str != null) {
			if (str.length() == 1) { // 递归终止条件
				list.add(str);
			} else {
				char first = str.charAt(0);
				String sub = str.substring(1);
				List<String> temp = getStringPermutations1(sub); // 递归调用，缩小问题的规模
				for (String s : temp) { // 在子串的全排列结果上求解原串的全排列结果
					for (int i = 0; i <= s.length(); i++) {
						if (i == 0) {
							list.add(first + s);
						} else if (i == s.length()) {
							list.add(s + first);
						} else {
							list.add(s.substring(0, i) + first
									+ s.substring(i, s.length()));
						}
					}
				}
			}
		}
		return list;
	}

	
	/**
	 * @description 先求str.substring(1)的全排列，在此结果上，求得str的全排列
	 * @author rico
	 * @param str
	 *            目标字符串
	 * @return 目标字符串的全排列
	 */
	public static List<String> getStringPermutations2(String str) {

		// 用于存储全排列结果
		List<String> list = new ArrayList<String>();

		if (str != null) {
			if (str.length() == 1) { // 递归终止条件
				list.add(str);
			} else {
				// 从字符串中每次选取一个元素，作为结果中的第一个元素;然后，对剩余的元素全排列
				for (int i = 0; i < str.length(); i++) {
					char first = str.charAt(i);
					List<String> temp = getStringPermutations2(str.substring(0,
							i) + str.substring(i + 1, str.length())); // 递归调用，缩小问题的规模
					for (String s : temp) {
						list.add(first + s);
					}
				}
			}
		}
		return list;
	}

	
	/**
	 * @description 从字符串数组中每次选取一个元素，作为结果中的第一个元素;然后，对剩余的元素全排列
	 * @author rico
	 * @param s
	 *            字符数组
	 * @param from
	 *            起始下标
	 * @param to
	 *            终止下标
	 */
	public static void getStringPermutations3(char[] s, int from, int to) {
		if (s != null && to >= from && to < s.length && from >= 0) { // 边界条件检查
			if (from == to) { // 递归终止条件
				System.out.println(s); // 打印结果
			} else {
				for (int i = from; i <= to; i++) {
					swap(s, i, from); // 交换前缀,作为结果中的第一个元素，然后对剩余的元素全排列
					getStringPermutations3(s, from + 1, to); // 递归调用，缩小问题的规模
					swap(s, from, i); // 换回前缀，复原字符数组
				}
			}
		}
	}
	
	/**
	 * @description 对字符数组中的制定字符进行交换
	 * @author rico
	 * @param s
	 * @param from
	 * @param to
	 */
	public static void swap(char[] s, int from, int to) {
		char temp = s[from];
		s[from] = s[to];
		s[to] = temp;
	}



	public static void main(String[] args) {
		System.out.println("解法二：");
		String target = "abcde";
		List<String> list = new ArrayList<String>();
		list = getStringPermutations2(target);
		System.out.println(list.size());
		 
		System.out.println("\n-------------------------\n");
		
		System.out.println("解法三：");
		char[] target1 = { 'a', 'b', 'c' };
		getStringPermutations3(target1, 0, 2);
	}
}
