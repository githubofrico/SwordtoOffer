package FirstNotRepeatingChar35;

/**
 * Title:第一个只出现一次的字符(使用char[256]作存储结构)
 * Description: 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @author rico
 * @created 2017年6月24日 上午8:51:27
 */
public class Solution1 {
	public int FirstNotRepeatingChar(String str) {
		if (str != null && str.length() != 0) {
			char[] arr = new char[256];
			for (char c : str.toCharArray()) {
				arr[c] ++;
			}
			for (char c : str.toCharArray()) {
				if (arr[c] == 1) {
					return str.indexOf(c);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String str = "google";
		System.out.println(s.FirstNotRepeatingChar(str));
	}
}
