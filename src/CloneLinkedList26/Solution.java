package CloneLinkedList26;

/**
 * Title: 复杂链表的复制(时间复杂度：O（n^2）)
 * Description:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点
 * ），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * @author rico
 * @created 2017年6月17日 上午11:27:19
 */
public class Solution {

	/**
	 * @description 为由CloneList()得到的链表依次设置各节点random指针
	 * @author rico
	 * @created 2017年6月17日 下午2:35:40
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {
		RandomListNode cHead = CloneList(pHead);
		RandomListNode cur1 = pHead;   // 链表pHead的指针
		RandomListNode cur2 = cHead;   // 链表cHead的指针

		//为cHead链表依次设置各节点的random指针
		while (cur1 != null) {
			RandomListNode tmp1 = cur1.random;
			if (tmp1 != null) {
				RandomListNode tmp2 = pHead;
				RandomListNode tmp3 = cHead;
				while (tmp2 != tmp1) {
					tmp2 = tmp2.next;
					tmp3 = tmp3.next;
				}
				cur2.random = tmp3;
			} else {
				cur2.random = null;
			}

			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cHead;
	}

	/**
	 * @description 递归复制一个与pHead一模一样的链表(没有设置random指针)
	 * @author rico
	 * @created 2017年6月17日 下午2:35:09
	 * @param pHead
	 * @return
	 */
	public RandomListNode CloneList(RandomListNode pHead) {
		if (pHead == null) {   // 递归终止条件
			return null;    // 简单情景下的处理
		} else {  // 缩小规模，递归调用
			RandomListNode cHead = CloneList(pHead.next);
			RandomListNode head = new RandomListNode(pHead.label);
			head.next = cHead;
			return head;
		}
	}

	public void print(RandomListNode pHead) {
		if (pHead == null) {
			return;
		} else {
			RandomListNode head = pHead;
			while (head != null) {
				System.out.print(head.label + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
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

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}

	@Override
	public String toString() {
		if (random == null) {
			return "RandomListNode [label=" + label + ", random=" + null + "]";
		}
		return "RandomListNode [label=" + label + ", random=" + random.label + "]";
	}

	
}