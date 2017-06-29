package LeftRotateString_ReverseSentence42;

/**        
 * Title: 左旋转字符串     
 * Description: 将字符串分为两部分
 * 1. 反转第一部分
 * 2. 反转第二部分
 * 3. 反转整体
 * @author rico       
 * @created 2017年6月29日 下午2:47:52    
 */      
public class LeftRotateString1 {
	public String leftRotateString(String str, int n) {
		if (str == null || n >= str.length()) {
			return str;
		} else {
			char[] arr = str.toCharArray();
			String str1 = reverse(arr, 0, n-1);  
			String str2 =  reverse(str1.toCharArray(), n, arr.length - 1);
			return reverse(str2.toCharArray(), 0, arr.length - 1);
		}
	}

	  
	/**     
	 * @description 反转字符数组指定部分
	 * @author rico       
	 * @created 2017年6月29日 下午2:49:29     
	 * @param arr
	 * @param start
	 * @param end
	 * @return     
	 */
	public String reverse(char[] arr, int start, int end) {
		char c = 0;
		while (start < end) {
			c = arr[start];
			arr[start] = arr[end];
			arr[end] = c;
			start ++;
			end --;
		}
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		LeftRotateString1 lrs1 = new LeftRotateString1();
		String test = "abcdefg";
		System.out.println(lrs1.leftRotateString(test, 2));
	}
}
