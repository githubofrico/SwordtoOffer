package SpaceReplacement;

/**
 * Title:替换空格(先计算出空格替换后需要多大数组)
 * Description: 请实现一个函数，将一个字符串中的空格替换成“%20”。 例如，当字符串为 “We Are
 * Happy”.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * @author rico
 * @created 2017年5月12日 下午5:15:59
 */
public class Solution1 {
	
	public static String replaceSpace(StringBuffer str) {
		StringBuilder sb = new StringBuilder();
		if (str == null) {
			return null;
		}
		
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if(temp == ' '){
				sb.append("%20");
			}else{
				sb.append(temp);
			}
		}
		return sb.toString();
	}
	
	
	public static String replaceSpace(String str) {
		char[] s = str.toCharArray();
		int counter = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				counter ++;
			}
		}
		
		char[] target = new char[str.length() + 2 * counter];
		if (counter != 0) {
			int num = s.length -1;
			for (int i = target.length - 1; i >= 0; i--) {
				if(num >= 0){
					if(s[num] != ' '){						
						target[i] = s[num];
						num --;
					}else{
						target[i--] = '0';
						target[i--] = '2';
						target[i] = '%';
						num --;
					}
				}
			}
			return String.valueOf(target);
		}
		return str;
	}
	
	public static String replaceSpace1(String str) {
		char[] src = str.toString().toCharArray();
		int counter = 0;
		for (int i = 0; i < src.length; i++) {
			if (src[i] == ' ') {
				counter ++;
			}
		}
		
		char[] target = new char[str.length() + 2 * counter];
		if (counter != 0) {
			System.arraycopy(src, 0, target, 0, src.length);
			int j = src.length -1;
			for (int i = target.length - 1; i >= 0; i--) {
				if(target[j] != ' '){
					target[i] = target[j];
					j--;
				}else{
					target[i--] = '0';
					target[i--] = '2';
					target[i] = '%';
					j --;
				}
			}
			return String.valueOf(target);
		}
		return str;
	}
	
	public static void main(String[] args) {
		String test = "h w";
		System.out.println(replaceSpace1(test));
	}
}
