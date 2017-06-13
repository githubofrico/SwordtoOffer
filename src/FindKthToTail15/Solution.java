package FindKthToTail15;

/**        
 * Title: 链表中倒数第k个结点 (双指针法(一个比另一个快几步))
 * Description: 输入一个链表，输出该链表中倒数第k个结点。
 * @author rico       
 * @created 2017年6月10日 下午5:44:16    
 */      
public class Solution {
	public ListNode FindKthToTail(ListNode head, int k) {
		
		if (k < 1 || head == null) {  // 边界条件
			return null;
		}
		
		ListNode pre = head;
		ListNode post = head;
		for (int i = 1; i < k; i++) { // pre先走k-1步
			if (pre != null) {
				pre = pre.next;
			}
		}
		if (pre != null) {
			// 当pre走到链表末端时，post正好指向倒数第K个节点
			while (pre != null && pre.next != null) {
				pre = pre.next;
				post = post.next;
			}
			return post;
		}
		return null;
	}
}

class ListNode{
	int data;
	ListNode next;
}
