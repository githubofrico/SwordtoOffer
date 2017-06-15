package IsPopOrder_21_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Title: 栈的压入、弹出序列
 * Description:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1
 * ,2,3,4,5是某栈的压入顺序
 * ,序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 
 * @author rico
 * @created 2017年6月15日 下午4:56:55
 */

public class Solution {
    public boolean IsPopOrder(int [] pushA, int [] popA) {
    	if (pushA == null && popA == null) {
    		return true;
		}else if(pushA == null || popA == null){
			return false;
		}else if (pushA.length != popA.length) {
			return false;
		}
    	LinkedList<Integer> stack1 = new LinkedList<Integer>();
    	ArrayList<Integer> popList = new ArrayList<Integer>();
    	int n = pushA.length;
    	int index = 0;
    	for (int i = 0; i < n; i++) {
    		if (stack1.isEmpty()) {
				stack1.push(pushA[i]);
			}
    		if(stack1.peek() != popA[index]){
				stack1.push(pushA[i]);
			}else{
				popList.add(stack1.pop());
				index ++;
				while(!stack1.isEmpty() && stack1.peek() == popA[index]){
					popList.add(stack1.pop());
					index ++;
				}
			}
		}
    	
    	while(!stack1.isEmpty()){
    		popList.add(stack1.pop());
    	}
    	
    	for (int i = 0; i < popA.length; i++) {
			if (popA[i] != popList.get(i)) 
				return false;
		}
    	return true;
    }
}
