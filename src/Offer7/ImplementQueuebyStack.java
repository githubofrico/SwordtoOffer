package Offer7;

import java.util.Stack;

/**        
 * Title:两个栈来实现一个队列     
 * Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作,队列中的元素为int类型。
 * 				主要解法：一个栈用于入队，另一个栈用于出队
 * @author rico       
 * @created 2017年5月30日 下午10:21:26    
 */      
public class ImplementQueuebyStack {
	Stack<Integer> stack1 = new Stack<Integer>();  // 用作入队
    Stack<Integer> stack2 = new Stack<Integer>();  	// 用作出队
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if (stack2.isEmpty()) {
    		while(!stack1.isEmpty())
    			stack2.push(stack1.pop());
		}
    	return stack2.pop();
    }
}
