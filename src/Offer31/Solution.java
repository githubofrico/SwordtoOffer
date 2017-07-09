package Offer31;
/**
 * Title:连续子数组的最大和
 * 
 * Description:HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中
 * ,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望
 * 旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 * 
 * 时间复杂度O(n)
 * 
 * @author rico
 * @created 2017年6月20日 上午10:39:07
 */
public class Solution {
	public int FindGreatestSumOfSubArray(int[] array) {
		if ((array == null) || array.length <= 0) {  // 边界条件
			return 0;
		}
		int curSum = 0;  // 保存当前连续子数组的和
		int greatestSum = Integer.MIN_VALUE;   // 保存连续子数组和的最大值
		for (int i = 0; i < array.length; i++) {
			if (curSum <= 0) {  // 只要curSum不大于0，就重新累计
				curSum = array[i];
			} else {    // 只要curSum大于0，就不断累计
				curSum += array[i];
			}
			if (curSum > greatestSum) {  //每次判断curSum与greatestSum的值，并及时更新
				greatestSum = curSum;
			}
		}
		return greatestSum;
	}

	public static void main(String[] args) {
		// int[] test = { 1, -2, 3, 10, -4, 7, 2, -5 };
		int[] test = { 6, -3, -2, 7, -15, 1, 2, 2 };
		System.out.println(new Solution().FindGreatestSumOfSubArray(test));
	}
}
