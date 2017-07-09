package Offer27;

/**
 * Title: 二叉搜索树与双向链表(递归算法)
 * Description:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author rico
 * @created 2017年6月18日 上午10:30:03
 */
public class Solution {

	public TreeNode Convert(TreeNode pRootOfTree) {
		TreeNode list = Convert1(pRootOfTree);
		if (list != null) { // 题目中所指的双向链表不是真正意义上的双向链表，因为其首、尾并未相互指向
			list.left.right = null;
			list.left = null;
		}
		return list;
	}

	/**
	 * @description 将二叉搜索树转化为有序的双向链表(首位相互指向的双向链表)
	 * @author rico
	 * @created 2017年6月18日 下午2:17:51
	 * @param pRootOfTree
	 * @return
	 */
	public TreeNode Convert1(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {   // 递归终止条件
			return null;   // 递归终止条件下，简单情景的处理
		} else {
			TreeNode list1 = Convert1(pRootOfTree.left);  // 左子树转换成双向链表1
			TreeNode list2 = Convert1(pRootOfTree.right);  // 右子树转换成双向链表2

			if (list1 == null && list2 == null) { // 叶节点
				pRootOfTree.left = pRootOfTree;
				pRootOfTree.right = pRootOfTree;
				return pRootOfTree;
			} else if (list1 == null && list2 != null) { // 左孩子为空
				TreeNode tmp = list2.left; // 链表的尾节点
				pRootOfTree.right = list2;
				list2.left = pRootOfTree;

				pRootOfTree.left = tmp;
				tmp.right = pRootOfTree;

				return pRootOfTree;
			} else if (list1 != null && list2 == null) { // 右孩子为空
				TreeNode tmp = list1.left; // 链表的尾节点
				tmp.right = pRootOfTree;
				pRootOfTree.left = tmp;

				list1.left = pRootOfTree;
				pRootOfTree.right = list1;

				return list1;
			} else { // 左、右孩子
				// 双向链表1的尾节点与根结点相连
				TreeNode tmp1 = list1.left; // 双向链表1的尾结点
				tmp1.right = pRootOfTree;
				pRootOfTree.left = tmp1;

				// 双向链表1的头结点与双向链表2的尾节点相连
				TreeNode tmp2 = list2.left; // 双向链表2的尾结点
				list1.left = tmp2;
				tmp2.right = list1;

				// 根结点与双向链表2的头节点相连
				pRootOfTree.right = list2;
				list2.left = pRootOfTree;
				return list1;
			}
		}
	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}