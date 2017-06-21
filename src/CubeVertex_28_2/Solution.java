package CubeVertex_28_2;

import java.util.Arrays;

/**
 * Title:正方体的相对面顶点和相等(全排列的应用,规则约束)
 * Description: 把八个数字放到正方体的8个顶点上，使得正方体三组相对的面上的4个顶点和相等。
 * 
 * 核心思想：全排列的应用，列举出所有可能性，再用具体条件逐一验证，剔除不满足条件的结果
 * 
 * @author rico
 * @created 2017年6月19日 下午10:18:51
 */
public class Solution {
	public static void getSpecifiedArrangement(int[] target, int from, int to) {
		if (from == to) { // 递归终止条件,简单情景下的处理
			if (((target[0] + target[1] + target[2] + target[3]) == (target[4]
					+ target[5] + target[6] + target[7]))
					&& ((target[0] + target[2] + target[4] + target[6]) == (target[1]
							+ target[2] + target[4] + target[6]))
					&& ((target[0] + target[1] + target[4] + target[5]) == (target[2]
							+ target[3] + target[6] + target[7]))) {
				System.out.println(Arrays.toString(target)); 
			}
		} else { // 缩小规模，递归调用
			for (int i = from; i <= to; i++) {
				swap(target, from, i);
				getSpecifiedArrangement(target, from + 1, to);
				swap(target, from, i);
			}
		}
	}

	/**
	 * @description 交换指定两个元素
	 * @author rico
	 * @created 2017年6月19日 下午10:38:27
	 * @param target
	 * @param from
	 * @param index
	 */
	public static void swap(int[] target, int from, int index) {
		int tmp = target[from];
		target[from] = target[index];
		target[index] = tmp;
	}

	public static void main(String[] args) {
		int target[] = { 1, 2, 3, 4, 1, 2, 3, 4};
		getSpecifiedArrangement(target, 0, target.length - 1);
	}
}
