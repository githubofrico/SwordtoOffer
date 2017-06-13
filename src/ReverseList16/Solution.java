package ReverseList16;

import java.util.LinkedList;
  
/**        
 * Title: 反转链表(依次将链表各节点的数据压栈，然后依次进行弹栈操作并将其赋值为链表各节点的data字段)   
 * Description:输入一个链表，反转链表后，输出链表的所有元素。
 * 时间复杂度：O(n),空间复杂度：O(n)
 * @author rico       
 * @created 2017年6月10日 下午5:47:21    
 */      
public class Solution {
	public ListNode ReverseList(ListNode head) {
		LinkedList<Integer> stack = new LinkedList<Integer>();   // 辅助空间
		ListNode cur = head;
		while(cur != null){
			stack.push(cur.data);
			cur = cur.next;
		}
		
		// 依次修改链表的节点data字段
		cur = head;
		while (cur!= null) {
			cur.data = stack.pop();
			cur = cur.next;
		}
		return head;
    }
}

class ListNode{
	int data;
	ListNode next;
}