package Offer63;

/**
 * Title:二叉搜索树的第k个结点(递归算法的设计与二叉搜索树的特征相结合) 
 * Description: 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4
 * 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * 
 * @author rico
 * @created 2017年7月9日 上午9:15:26
 */
public class Solution {
	/**     
	 * @description 结合二叉搜索树的特征进行搜索
	 * @author rico       
	 * @created 2017年7月9日 上午9:41:46     
	 * @param pRoot 
	 * @param k
	 * @return     
	 */
	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k < 0) {
			return null;
		}else{
			int count = count(pRoot.left);
			if (k == count + 1) {  // 所求节点即为树根
				return pRoot;
			}else if (k < count + 1) {  // 所求节点在左子树中
				return KthNode(pRoot.left, k);
			}else{
				return KthNode(pRoot.right, k-count-1);  // 所求节点在右子树中(K大于树的节点数时，返回null)
			}
		}
	}
	  
	/**     
	 * @description 前序遍历的应用，计算树中节点数目
	 * @author rico       
	 * @created 2017年7月9日 上午9:38:50     
	 * @param pRoot
	 * @return     
	 */
	public int count(TreeNode pRoot){
		if (pRoot == null) {
			return 0;
		}else{
			int left = count(pRoot.left);
			int right = count(pRoot.right);
			return left + right + 1;
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