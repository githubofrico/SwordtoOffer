package TheContainingMinFunStack21;

import java.util.Stack;

/**
 * Title:包含min函数的栈 
 * Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * @author rico
 * @created 2017年6月15日 下午4:19:59
 */
public class Solution {

	private Stack<Integer> storeStack = new Stack<Integer>();  // 存储栈
	private Stack<Integer> minStack = new Stack<Integer>();   // 存储最小值的栈

	public void push(int node) {  // 入栈操作
		storeStack.push(node);
		if (minStack.isEmpty() || (!minStack.isEmpty() && node <= minStack.peek())) {  // 满足条件时，将该值同时入最小值栈
			minStack.push(node);
		}
	}

	public void pop() {  // 弹栈操作
		if (!storeStack.isEmpty()) {
			int tmp = storeStack.pop();
			if (tmp == minStack.peek()) {  //若所弹出元素与最小值栈栈顶元素相同，那么在最小值栈中也执行弹栈操作
				minStack.pop();
			}
		}
	}

	public int top() {   // 返回当前栈顶元素
		if (!storeStack.isEmpty()) {
			return storeStack.peek();
		}
		return Integer.MIN_VALUE;
	}

	public int min() {  // 返回当前栈的最小值 
		if (!minStack.isEmpty()) {
			return minStack.peek();
		}
		return Integer.MIN_VALUE;
	}
}