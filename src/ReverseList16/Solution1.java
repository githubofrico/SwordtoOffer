package ReverseList16;

/**
 * Title: 反转链表(双指针法) 
 * Description:输入一个链表，反转链表后，输出链表的所有元素。 时间复杂度：O(n),空间复杂度：O(n)
 * 
 * @author rico
 * @created 2017年6月10日 下午5:47:21
 */
public class Solution1 {
	public ListNode ReverseList(ListNode head) {
		ListNode p1 = null;    // 慢指针
		ListNode p2 = head;    // 快指针
		ListNode tmp = null;
		while (p2 != null) {
			tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}
		head = p1;    // head指向反转链表的表头
		return head;
	}
}
