package Offer16;

/**
 * Title: 反转链表(递归算法,在归来时解决问题) 
 * Description:输入一个链表，反转链表后，输出链表的所有元素。 时间复杂度：O(n),空间复杂度：O(n)
 * 
 * @author rico
 * @created 2017年6月10日 下午5:47:21
 */   
public class Solution3 {
	public ListNode ReverseList(ListNode head) {
		if (head == null || head.next == null ) {   // 递归终止条件
			return head;     // 简单情景
		}else{
			// 反转好的链表，node指向表头
			ListNode node = ReverseList(head.next);  // 提取重复的逻辑，缩小问题规模
			
			//遍历反转链表到尾节点
			ListNode tmp = node;   
			while(tmp.next != null){
				tmp = tmp.next;
			}
			//将当前结点链入已经反转好的链表
			tmp.next = head;
			head.next = null;  // 将当前节点的指针置空，防止死循环
			return node;
		}
	}
}
