package MergeTwoSortedLinkedList17;

/**
 * Title: 合并两个排序的链表 (递归法,归来时不断解决问题)
 * Description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author rico
 * @created 2017年6月14日 下午3:59:10
 */
public class Solution2 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {  // 递归终止条件1
			return list2;   // 递归终止时的处理办法
		}else if (list2 == null) {  // 递归终止条件2
			return list1;   // 递归终止时的处理办法
		}else {
			ListNode target = null;
			if (list1.val > list2.val) {
				target = list2;
				target.next = Merge(list1, list2.next);  // 提取重复的逻辑，缩小问题规模
			}else{
				target = list1;
				target.next = Merge(list1.next, list2);  // 提取重复的逻辑，缩小问题规模
			}
			return target;
		}
	}
}
