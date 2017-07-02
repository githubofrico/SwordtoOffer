package PublicAncestor50;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Title: 树中两个结点的最低公共祖先
 * Description: 求树中两个结点的最低公共祖先，此树不是二叉树，并且没有指向父节点的指针。
 * 
 * @author rico
 * @created 2017年7月2日 下午5:25:26
 */
public class Solution {

	/**
	 * @description 根结点到目标节点的路径(先根次序遍历)
	 * @author rico
	 * @created 2017年7月2日 下午6:27:51
	 * @param root
	 *            根结点
	 * @param target
	 *            目标节点
	 * @return
	 */
	public static LinkedList<TreeNode> getPathFromRootToTarget(TreeNode root,
			TreeNode target) {
		LinkedList<TreeNode> path = new LinkedList<TreeNode>();
		if (root == null) { // 递归终止条件1：不包含目标节点
			return path;
		} else if (root == target) { // 递归终止条件2：包含目标节点
			path.push(root);
			return path;
		} else { // 缩小范围，递归处理
			LinkedList<TreeNode> children = root.children;
			LinkedList<TreeNode> tmp;
			for (TreeNode node : children) {
				tmp = getPathFromRootToTarget(node, target);
				if (tmp.size() != 0) { // 根据树的定义，节点最多只能存在于一颗树中
					path = tmp;
					break;
				}
			}
			if (path.size() != 0) { // 树中包含目标节点
				path.push(root);
			}
			return path;
		}
	}

	/**
	 * @description 根据两节点的路径，寻找其最低公共祖先
	 * @author rico
	 * @created 2017年7月2日 下午6:29:09
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static TreeNode getLastCommonParent(TreeNode root, TreeNode node1,
			TreeNode node2) {
		if (root == null || node1 == null || node2 == null) { // 边界条件
			return null;
		} else {
			// root节点分别到两目标节点node1和node2的路径
			LinkedList<TreeNode> path1 = getPathFromRootToTarget(root, node1);
			System.out.println("path1 : " + path1);
			LinkedList<TreeNode> path2 = getPathFromRootToTarget(root, node2);
			System.out.println("path2 : " + path2);
			if (path1 == null || path2 == null) {
				return null;
			}
			TreeNode lastCommonParent = null; // 最低公共祖先
			Iterator<TreeNode> iter1 = path1.iterator();
			Iterator<TreeNode> iter2 = path2.iterator();
			while (iter1.hasNext() && iter2.hasNext()) {
				TreeNode tmp1 = iter1.next();
				TreeNode tmp2 = iter2.next();
				if (tmp1 != null && tmp2 != null) {
					if (tmp1 == tmp2) {
						lastCommonParent = tmp1; // 更新最低公共祖先
					} else {
						break;
					}
				}
			}
			return lastCommonParent;
		}
	}

	public static void main(String[] args) {
		test01();
		System.out.println("==========");
	}

	public static void test01() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);

		n1.children.add(n2);
		n1.children.add(n3);

		n2.children.add(n4);
		n2.children.add(n5);

		n4.children.add(n6);
		n4.children.add(n7);

		n5.children.add(n8);
		n5.children.add(n9);
		n5.children.add(n10);

		System.out.println("LastCommonParent : "
				+ getLastCommonParent(n1, n6, n8));
		// System.out.println(getPathFromRootToTarget(n1, n10));
	}

}

class TreeNode {
	int val;
	LinkedList<TreeNode> children = new LinkedList<TreeNode>(); // 树的一般表示法(多个孩子)

	TreeNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}
}