package IsBalanceTree39_1;

public class Solution {
	  
	/**     
	 * @description 判断二叉树是否平衡
	 * @author rico       
	 * @created 2017年6月26日 下午5:07:51     
	 */
	public boolean isBalanceTree(TreeNode root) {
		if (root == null) {  // 递归终止条件
			return true;  // 简单情景
		} else {
			boolean left = isBalanceTree(root.left);
			boolean right = isBalanceTree(root.right);
			if (left && right) {
				return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) < 2 ? true
						: false;
			} else {
				return false;
			}
		}
	}

	  
	/**     
	 * @description 求二叉树的深度/高度
	 * @author rico       
	 * @created 2017年6月26日 下午5:07:31     
	 */
	public int TreeDepth(TreeNode root) {
		if (root == null) { // 递归终止条件
			return 0; // 简单情境下的处理
		} else { // 缩小规模，递归调用
			int h1 = TreeDepth(root.left);
			int h2 = TreeDepth(root.right);
			return h2 > h1 ? h2 + 1 : h1 + 1;
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