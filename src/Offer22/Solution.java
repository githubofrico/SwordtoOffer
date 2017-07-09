package Offer22;

import java.util.LinkedList;

/**
 * Title: 栈的压入、弹出序列(创建一个栈并模拟入栈序列和弹栈序列，通过最后栈是否为空判断入栈序列与弹栈序列是否匹配)
 * Description:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序,序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 
 * 思路：在按pushA中元素的顺序入栈时，对于每一个元素，无非有两种情况：入栈后马上弹出(可能引发一系列元素的弹栈)，或者下一个元素接着入栈
 * 
 * @author rico
 * @created 2017年6月15日 下午4:56:55
 */

public class Solution {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null && popA == null) { // 边界条件1：都为空
			return true;
		} else if (pushA == null || popA == null) { // 边界条件2：一个为空，一个不为空
			return false;
		} else if (pushA.length != popA.length) { // 边界条件3：长度不等
			return false;
		}

		int n = pushA.length;
		int popA_index = 0;
		// 栈stack同时模拟压栈操作pushA和弹栈操作popA,最后stack变为空,则popA与pushA对应
		LinkedList<Integer> stack = new LinkedList<Integer>(); // 模拟pushA序列中个元素的压栈过程
		for (int i = 0; i < n; i++) {
			// 模拟入栈
			stack.push(pushA[i]); 
			
			// 模拟弹栈：若当前栈顶元素与popA[popA_index]相同，则弹栈
			while (!stack.isEmpty() && stack.peek() == popA[popA_index]) {
				stack.pop();
				popA_index++;
			}
		}
		return stack.isEmpty(); // 栈是否为空：栈为空，则匹配成功；否则，失败。
	}

	public static void main(String[] args) {
		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 4, 5, 3, 2, 1 };
		Solution s = new Solution();
		System.out.println(s.IsPopOrder(pushA, popA));
	}
}
