package Offer55;

/**
 * Title:字符流中第一个不重复的字符 (ASCII字符，简易哈希表)
 * Description:请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"
 * 时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * 
 * @author rico
 * @created 2017年7月6日 下午3:40:43
 */
public class Solution {

//	String stringstream = null;
	String stringstream = "avcdvsad";
	StringBuilder sb = new StringBuilder();

	// Insert one char from stringstream
	public void Insert(char ch) {
		stringstream = sb.append(ch).toString();
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		if (stringstream != null) {
			int[] arr = new int[256];
			for (char c : stringstream.toCharArray()) {
				int count = arr[c];
				count++;
				arr[c] = count;
			}
			
			for (char c : stringstream.toCharArray()) {
				if (arr[c] == 1) {
					return c;
				}
			}
		}
		return '#';
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.FirstAppearingOnce());
	}
}
