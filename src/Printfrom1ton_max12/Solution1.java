package Printfrom1ton_max12;

/**
 * Title: 打印1到最大的n位数（n个从0到9的全排列）
 * Description:输入数字n,按顺序打印出从1到最大的n位十进制数。比输入3，则打印出1、2、3一直到最大的3位数999.
 * 
 * @author rico
 * @created 2017年6月5日 下午9:03:10
 */
public class Solution1 {

	/**  在递归的临界点解决问题，用于保存结果  (@author: rico) */      
	static StringBuilder result = new StringBuilder();

	/**     
	 * @description 递归打印从1到99...9
	 * @author rico       
	 * @created 2017年6月10日 上午11:39:14     
	 * @param n     
	 */
	public static void print(int n) {
		if (n == 0) {   // 递归终止条件
			// 简单情景下的处理
			String s = trim(result);
			if (!s.equals("")) {
				System.out.println(s);
			}
		} else {   
			for (int i = 0; i < 10; i++) {
				result.append(i);
				print(n - 1);    // 提取重复的逻辑，缩小问题规模
				result = result.deleteCharAt(result.length() - 1);
			}
		}
	}

	/**
	 * @description 去掉前面的0
	 * @author rico
	 * @created 2017年6月10日 上午10:06:59
	 * @param sb
	 * @return
	 */
	public static String trim(StringBuilder sb) {
		int index = 0;
		while (index < sb.length() && sb.charAt(index) == '0') {
			index++;
		}
		return sb.substring(index);
	}

	public static void main(String[] args) {
		Solution1.print(5);
	}
}
