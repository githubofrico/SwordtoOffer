package Offer51;

import java.util.Arrays;

/**
 * Title:数组中重复的数字，解法类似于题目Offer35：第一个只出现一次的字符，简易哈希表
 * Description: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 
 * 时间复杂度：O(n)
 * 
 * 空间复杂度：O(n)
 * 
 * @author rico
 * @created 2017年7月3日 下午4:38:19
 */
public class Solution {
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers != null && length > 0 && duplication.length > 0) {
			boolean[] hash = new boolean[length];   // 简易哈希表
			for (int num : numbers) {
				if (!hash[num]) {
					hash[num] = true;
				}else{
					duplication[0] = num;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] test = {2,3,1,0,2,5,3};
		int[] duplication = new int[1];
		System.out.println(s.duplicate(test, test.length, duplication));
		System.out.println(Arrays.toString(duplication));
	}
}