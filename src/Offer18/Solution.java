package Offer18;

/**
 * Title: 树的子结构 (递归算法/思想)
 * Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 * @author rico
 * @created 2017年6月14日 下午5:39:04
 */
public class Solution {

	/**     
	 * @description 递归判断root2是不是root1的子结构
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) { // 递归终止条件
			return false; // 简单情景：空树不是任意一个树的子结构
		} else {
			if (root1.val == root2.val) {   // 若树A/B根结点相同，且B的左、右子树均是A的左、右子树的子结构
				boolean flag = compareTree(root1.left, root2.left)
						&& compareTree(root1.right, root2.right);
				if (flag)  
					return true;   // 直接返回
			}
			// 否则，继续判断树B是否是树A的右子树或左子树的子结构
			return HasSubtree(root1.left, root2)
					|| HasSubtree(root1.right, root2);
		}
	}

	/**
	 * @description 自上而下递归判断树root2各节点是否与树root1相同
	 * @author rico
	 * @created 2017年6月15日 上午8:19:05
	 * @param root1
	 * @param root2
	 * @return 
	 */
	public boolean compareTree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) { 
			// root1为空且root2不为空，直接返回false;否则，返回true
			if (root1 == null && root2 != null) {
				return false;
			}
			return true;
		} else if (root1.val != root2.val) {  // root1与root2不等
			return false;
		} else {  // 继续比较
			return compareTree(root1.left, root2.left)
					&& compareTree(root1.right, root2.right);
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