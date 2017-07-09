package Offer34;

/**
 * Title: 丑数 
 * Description: 把只包含因子2、3和5的数称作丑数（Ugly
 * Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * @author rico
 * @created 2017年6月23日 下午8:40:35
 */
public class Solution1 {
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0)
			return 0;
		int[] result = new int[index];   // 既然是寻找第N个丑数，那么数组大小为N
		result[0] = 1;
		int begin = 1, m2 = 0, m3 = 0, m5 = 0;  // 在已有丑数序列中，第一个乘以2或3或5大于当前最大丑数的位置
		while (begin < index) {
			result[begin] = min(result[m2] * 2, result[m3] * 3, result[m5] * 5);// 大于当前当前最大丑数的最小数
			
			// 更新 m2、m3 及 m5 的位置
			while ((result[m2] * 2 <= result[begin])) {
				m2++;
			}
			while ((result[m3] * 3 <= result[begin])) {
				m3++;
			}
			while ((result[m5] * 5 <= result[begin])) {
				m5++;
			}
			begin++;
		}
		return result[index - 1];
	}

	public int min(int i, int j, int k) {
		int temp = i < j ? i : j;
		return temp < k ? temp : k;
	}
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.GetUglyNumber_Solution(1500));
	}
}
