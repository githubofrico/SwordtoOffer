package Offer56;

import java.util.HashSet;
import java.util.Set;
  
/**        
 * Title: 链表中环的入口结点(链表尾节点的指向)    
 * Description: 一个链表中包含环，请找出该链表的环的入口结点。 
 * @author rico       
 * @created 2017年7月6日 下午4:14:08    
 */      
public class Solution3 {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead != null) {
			Set<ListNode> set = new HashSet<ListNode>();
			ListNode cur = pHead;
			while (cur != null) {
				if (set.contains(cur)) {
					return cur;
				}else{
					set.add(cur);
					cur = cur.next;
				}
			}
		}
		return null;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}