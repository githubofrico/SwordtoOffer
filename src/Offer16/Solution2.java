package Offer16;

/**        
 * Title: 反转链表()   
 * Description:输入一个链表，反转链表后，输出链表的所有元素。
 * 时间复杂度：O(n),空间复杂度：O(n)
 * @author rico       
 * @created 2017年6月10日 下午5:47:21    
 */ 
public class Solution2 {
	public ListNode ReverseList(ListNode head) {
		if (head != null) {
			ListNode reverseListHead = null;  // 链表反转后的表头
			ListNode pre = null;    // 前驱节点
			ListNode cur = head;   // 当前节点
			ListNode next = null;   // 后继节点
			while(cur != null){
				next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			reverseListHead = pre;
			return reverseListHead;
		}
		return head;
	}
}
