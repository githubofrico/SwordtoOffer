package LeftRotateString_ReverseSentence42;

/**
 * Title: 翻转单词顺序列(双指针法) 
 * Description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣
 * ，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am
 * I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a
 * student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 
 * @author rico
 * @created 2017年6月29日 下午12:13:40
 */
public class ReverseSentence {
	public String reverseSentence(String str) {
		if (str != null && str.split(" ").length > 1) {
			StringBuilder sb = new StringBuilder();
			String[] strs = str.split(" ");
			int start = 0; // 头指针
			int end = strs.length - 1; // 尾指针
			String tmp = null;
			while (end > start) {
				tmp = strs[start];
				strs[start] = strs[end];
				strs[end] = tmp;
				end--;
				start++;
			}
			for (String s : strs) {
				sb.append(s).append(" ");
			}
			return sb.toString().trim();
		}
		return str;
	}

	public static void main(String[] args) {
		ReverseSentence s = new ReverseSentence();
		String str = "student. a am I";
		System.out.println(s.reverseSentence(str));

	}
}
