package cn.edu.tju.rico.inttree;

/**
 * Title: 结点类 
 * Description: 二叉树的结点
 * 
 * @author rico
 * @created 2017年4月6日 下午9:55:58
 */
public class TreeNode {

	public int data; // 结点数据
	public TreeNode left; // 指向左孩子结点
	public TreeNode right; // 指向右孩子结点
	public boolean flag; // 用于非递归后序遍历

	/**
	 * 构造函数
	 * 
	 * @description 构造一个新结点
	 * @author rico
	 * @created 2017年4月6日 下午9:56:56
	 * @param data
	 *            新元素数据
	 * @param next
	 *            新元素与链表结合结点
	 */
	public TreeNode(int data) {
		this.data = data;
	}

	public TreeNode() {
	}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof TreeNode) {
			TreeNode temp = (TreeNode) obj;
			if (data == temp.data) {
				return true;
			}
		}
		return false;
	}
}
