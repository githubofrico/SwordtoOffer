package IsBalanceTree39_1;

public class Solution1 {

	public boolean isBalanced(TreeNode root) {
		int depth = 0;
		return isBalanced2(root, depth);
	}

	public boolean isBalanced2(TreeNode root, int depth) {
		if (root == null) {
			depth = 0;
			return true;
		}
		int left = 0, right = 0;
		if (isBalanced2(root.left, left) && isBalanced2(root.right, right)) {
			int diff = left - right;
			if (diff <= 1 && diff >= -1) {
				depth = 1 + (left > right ? left : right);
				return true;
			}
		}
		return false;
	}
}
