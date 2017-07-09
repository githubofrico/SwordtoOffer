package Offer19;

/**        
 * Title: 二叉树的镜像(画图找规律，递归算法)，二叉树前序遍历的应用
 * Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author rico       
 * @created 2017年6月15日 上午9:30:37    
 */      
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) {   // 递归终止条件
			return;   // 简单情景的处理
		}else{
			// 先对调左右子树
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			
			//再将左右子树分别变换为其对应的镜像
			Mirror(root.left);   // 重复逻辑的提取，缩小问题规模
			Mirror(root.right);  // 重复逻辑的提取，缩小问题规模
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