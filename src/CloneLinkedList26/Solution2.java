package CloneLinkedList26;

import sun.net.www.content.image.png;

/**
 * Title: 复杂链表的复制(时间复杂度：O(n),空间复杂度：O(1))
 * Description:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点
 * ），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * @author rico
 * @created 2017年6月17日 上午11:27:19
 */
public class Solution2 {

	/**
	 * @description 为由CloneList()得到的链表依次设置各节点random指针
	 * @author rico
	 * @created 2017年6月17日 下午2:35:40
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {
		pHead = CloneList(pHead);
		setRandom(pHead);
		RandomListNode splitList = splitList1(pHead);
		return splitList;
	}

	/**
	 * @description 递归复制pHead节点并连接在pHead后面(没有设置random指针)
	 * @author rico
	 * @created 2017年6月17日 下午2:35:09
	 * @param pHead
	 * @return
	 */
	public RandomListNode CloneList(RandomListNode pHead) {
		if (pHead == null) { // 递归终止条件
			return null; // 简单情景下的处理
		} else { // 缩小规模，递归调用
			RandomListNode cHead = CloneList(pHead.next);
			RandomListNode head = new RandomListNode(pHead.label);
			pHead.next = head;
			head.next = cHead;
			return pHead;
		}
	}

	/**
	 * @description 设置random指针
	 * @author rico
	 * @created 2017年6月17日 下午3:10:49
	 * @param pHead
	 */
	public void setRandom(RandomListNode pHead) {
		RandomListNode cur = pHead;
		while (cur != null) {
			RandomListNode random = cur.random;
			RandomListNode cnode = cur.next;
			if (random != null) {
				cnode.random = random.next;
			} else {
				cnode.random = null;
			}
			cur = cur.next.next;
		}
	}

	/**
	 * @description 拆分两链表
	 * @author rico
	 * @created 2017年6月17日 下午3:29:49
	 * @param pHead
	 * @return
	 */
	public RandomListNode splitList1(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		RandomListNode pClonedHead = null;
		RandomListNode pClonedNode = null;
		
		if (pNode != null) {
			pClonedHead = pClonedNode = pNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		
		while(pNode != null){
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		return pClonedHead;
	}

	public void print(RandomListNode pHead) {
		if (pHead == null) {
			return;
		} else {
			RandomListNode head = pHead;
			while (head != null) {
				System.out.print(head);
				head = head.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		node1.random = node3;
		node2.random = node5;
		node3.random = null;
		node4.random = node2;
		node5.random = null;

		s.print(s.Clone(node1));
	}
}
