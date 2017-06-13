package ReverseList16;

/**        
 * Title: 反转链表()   
 * Description:输入一个链表，反转链表后，输出链表的所有元素。
 * 时间复杂度：O(n),空间复杂度：O(n)
 * @author rico       
 * @created 2017年6月10日 下午5:47:21    
 */  
public class Solution1 {
	public ListNode ReverseList(ListNode head) {
		if (head != null && head.next != null) {
			ListNode p1 = head;
			ListNode p2 = p1.next;
			while(p2 != null){
				ListNode tmp = p2.next;
				p2.next = p1;
				if (p1 == head) {
					p1.next = null;
				}
				p1 = p2;
				p2 = tmp;
			}
			head = p1;
		}
		return head;
	}
}
