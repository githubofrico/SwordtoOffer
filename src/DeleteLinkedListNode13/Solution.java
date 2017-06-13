package DeleteLinkedListNode13;

/**
 * Title: 在O(1)时间删除链表的节点(被删除节点是中间节点，则只需复制后继节点的内容并使其覆盖待删除节点，然后再删除待删除节点的后继节点即可)
 * Description: 给定单向链表的头指针和一个节点的指针，定义一个函数在O(1)时间删除该节点。 
 * 时间复杂度(平均)：[(n-1)O(1) + 1*O(n)]/n = O(1)
 * 
 * @author rico
 * @created 2017年6月10日 下午12:01:17
 */
public class Solution {
	public void deleteNode(ListNode head, ListNode target) {
		if (target.next == null) { // 被删除节点没有后继节点
			if (head == target) { // 链表只有一个节点，并且这个节点就是被删除节点:O(1)
				head = null;
				target = null;
			} else { // 被删除节点是链表的尾节点(需要遍历整个链表)：O(n)
				ListNode tmp = head;
				while (head.next != target) {
					tmp = tmp.next;
				}
				tmp.next = null;
				target = null;
			}
		} else { // 被删除节点是中间节点，则只需复制后继节点的内容并使其覆盖待删除节点，然后再删除待删除节点的后继节点即可
			ListNode tmp = target.next;
			target.data = tmp.data;
			target.next = tmp.next;
			tmp.next = null;
			tmp = null;
		}
	}
}

class ListNode {
	int data;
	ListNode next;
}