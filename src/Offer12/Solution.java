package Offer12;

/**
 * Title: 打印1到最大的n位数
 * Description:输入数字n,按顺序打印出从1到最大的n位十进制数。比输入3，则打印出1、2、3一直到最大的3位数999.
 * 
 * @author rico
 * @created 2017年6月5日 下午9:03:10
 */
public class Solution {

	public void print(int n) {
		StringBuilder start = new StringBuilder(); // 最小的n位数
		StringBuilder end = new StringBuilder(); // 最大的n位数
		for (int i = 0; i < n; i++) {
			start.append("0");
			end.append("9");
		}

		// 循环打印从1到最大的n位十进制数
		while (!start.toString().equals(end.toString())) { // StringBuilder没有重写Object的equals方法
			int index = n - 1;
			while (Integer.valueOf(start.charAt(index) - 48) == 9) { //从后向前扫描，使index指向第一个不为9的数字
				index--;
			}
			if (index == n - 1) {	 // 正常累加
				start = start.replace(index, index + 1,
						String.valueOf(start.charAt(index) - 48 + 1));
			} else { 	// 进位处理
				StringBuilder rp = new StringBuilder(String.valueOf(start
						.charAt(index) - 48 + 1));
				int temp = index;
				while (temp < n - 1) {
					temp++;
					rp.append("0");
				}
				start = start.replace(index, n, rp.toString());
			}
			System.out.println(trim(start));
		}
	}

	  
	/**     
	 * @description 去掉前面的0
	 * @author rico       
	 * @created 2017年6月10日 上午10:06:59     
	 * @param sb
	 * @return     
	 */
	public String trim(StringBuilder sb) {
		int index = 0;
		while (index < sb.length() && sb.charAt(index) == '0') {
			index++;
		}
		return sb.substring(index);
	}

	public static void main(String[] args) {
		new Solution().print(5);
	}
}
