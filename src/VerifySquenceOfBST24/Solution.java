package VerifySquenceOfBST24;

/**
 * Title:二叉搜索树的后序遍历序列 (左子树 < 根  < 右子树)
 * Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author rico
 * @created 2017年6月16日 上午11:57:30
 */
public class Solution {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null) {
			return true;
		}else if (sequence.length == 0) {
			return false;
		}else {
			return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
		}
	}

	  
	/**     
	 * @description 判断给定序列是不是某二叉搜索树的后序遍历的结果
	 * @author rico       
	 * @created 2017年6月17日 上午9:00:08     
	 * @param sequence
	 * @param from
	 * @param to
	 * @return     
	 */
	public boolean VerifySquenceOfBST(int[] sequence, int from, int to) {
		if (to - from <= 1) {   // 递归终止条件：只剩两个节点时
			return true;  // 简单情境下的处理
		} else {
			int root = sequence[to];  //根结点
			// 找到左右子树的边界
			int border = from;
			for (int i = from; i < to; i++) {
				if (sequence[i] < root) {
					border++;
				} else {
					break;
				}
			}
			
			// 判断右子树是不是都大于根结点
			for (int i = border + 1; i < to; i++) {
				if (sequence[i] < root) {
					return false;
				}
			}
			
			// 递归调用，缩小问题的规模
			return VerifySquenceOfBST(sequence, from, border-1)
					&& VerifySquenceOfBST(sequence, border, to-1);
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] test = {4,8,6,12,16,14,10};
		System.out.println(s.VerifySquenceOfBST(test));
	}
}
