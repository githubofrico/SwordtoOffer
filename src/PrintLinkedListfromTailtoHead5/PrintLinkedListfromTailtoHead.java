package PrintLinkedListfromTailtoHead5;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Title:从尾到头打印链表(递归的解决思路/思维：描述问题是"递去"，解决问题是"归来",也就是说，只有把问题的解决思路描述出来，才能写出递归代码)
 * Description: 输入一个链表，从尾到头打印链表每个节点的值。
 * 
 * @author rico
 * @created 2017年5月29日 下午8:53:30
 */
public class PrintLinkedListfromTailtoHead {
	  
	/**     
	 * @description 递归实现
	 * @author rico       
	 * @created 2017年5月29日 下午9:51:49     
	 * @param listNode
	 * @return     
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (listNode != null) { 	// 递归终止条件
			ListNode next = listNode.next;
			list.addAll(printListFromTailToHead(next)); 	// 先递归打印子序列(缩小规模)
			list.add(listNode.data); 	// 再打印本身
		}
		return list;
	}
	
	  
	/**     
	 * @description 循环实现，借助栈
	 * @author rico       
	 * @created 2017年5月29日 下午9:51:43     
	 * @param listNode
	 * @return     
	 */
	public ArrayList<Integer> printListFromTailToHeadwithStack(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		// 入栈
		while (listNode != null) { 	
			stack.push(listNode.data);
			listNode = listNode.next;
		}
		
		// 出栈
		for (Integer i : stack) {
			list.add(i);
		}
		return list;
	}
}

  
/**        
 * Title: 链表结点   
 * Description: 
 * @author rico       
 * @created 2017年5月29日 下午8:56:09    
 */      
class ListNode {
	int data;
	ListNode next;

	public ListNode(int data) {
		this.data = data;
	}
}