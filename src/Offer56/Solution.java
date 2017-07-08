package Offer56;
  
/**        
 * Title: 链表中环的入口结点(链表尾节点的指向)    
 * Description: 一个链表中包含环，请找出该链表的环的入口结点。
 * 空间复杂度O(1) 
 * @author rico       
 * @created 2017年7月6日 下午4:14:08    
 */      
public class Solution {
	  
	/**     
	 * @description 快指针比慢指针快count步(count为环中节点的数目)
	 * @author rico       
	 * @created 2017年7月7日 下午1:46:27     
	 * @param pHead
	 * @return     
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead != null) {
			int count = NodeNuminLoop(pHead);  // 计算环中节点数目
			if (count != 0) {
				ListNode p1 = pHead;  // 慢指针
				ListNode p2 = pHead;  // 快指针
				while (count > 0) {   // 快指针比慢指针快count步
					p2 = p2.next;
					count --;
				}
				// 快慢指针交汇处即为环的入口点
				while (p1 != p2) {
					p1 = p1.next;
					p2 = p2.next;
				}
				return p1;
			}
		}
		return null;
	}
	
	  
	/**     
	 * @description 链表所包含环的节点数，不包含环时，个数为0.
	 * @author rico       
	 * @created 2017年7月7日 上午8:41:16     
	 * @param pHead
	 * @return     
	 */
	public int NodeNuminLoop(ListNode pHead){
		ListNode p1 = pHead;   // 慢指针，一次走一步
		ListNode p2 = pHead;   // 快指针，一次走两步
		int count = 1;   // 链表环中数目

		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {   // 两指针交汇于一个结点,该节点必然属于环,计算环内结点数目
				ListNode tmp = p1;
				while (tmp != p1.next) {
					count++;
					p1 = p1.next;
				}
				return count;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Solution s1 = new Solution();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		
		System.out.println(s1.NodeNuminLoop(node1));
	}
}
