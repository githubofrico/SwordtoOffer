package Offer59;

/**
 * Title: 对称的二叉树 (递归算法) 
 * Description:请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author rico
 * @created 2017年7月7日 下午9:07:26
 */
public class Solution {
	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return true;
		}
		return isSymmetrical(pRoot.left, pRoot.right);
	}

	/**
	 * @description 判断两棵树(A,B)是否对称：A的左子树与B的右子树对称 && A的右子树与B的左子树对称
	 * @author rico
	 * @created 2017年7月8日 上午7:39:53
	 * @param t1
	 * @param t2
	 * @return
	 */
	boolean isSymmetrical(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {   // 两颗空树是对称的
			return true;
		} else if (t1 != null && t2 != null) { 
			if (t1.val == t2.val) {  // 判断 A的左子树与B的右子树对称 && A的右子树与B的左子树对称
				return isSymmetrical(t1.left, t2.right)
						&& isSymmetrical(t1.right, t2.left);
			}
		}
		return false;
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