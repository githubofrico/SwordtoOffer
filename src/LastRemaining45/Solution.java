package LastRemaining45;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:孩子们的游戏(圆圈中最后剩下的数) Description:
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老
 * ,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈
 * 。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌
 * ,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始
 * ,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演
 * ,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 
 * @author rico
 * @created 2017年7月2日 上午9:39:03
 */
public class Solution {

	/**
	 * @description 模拟循环链表，模拟游戏流程
	 * @author rico
	 * @created 2017年7月2日 下午2:00:04
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution(int n, int m) {
		if (n >= 1 && m >= 1) {
			List<Integer> list = new ArrayList<Integer>(n);
			for (int i = 0; i < n; i++) {
				list.add(i);
			}

			int count = 0; // 正在报哪个数
			int index = 0; // 哪位同学正在报数
			while (list.size() != 1) { // 只剩一个小朋友时，循环终止
				if (index == list.size()) { // 循环遍历
					index = 0;
				}
				if (count == m - 1) { // 报m-1的小朋友出局
					list.remove(index);
					count = 0;
					continue;
				}
				index++;
				count++;
			}
			return list.get(0);
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.LastRemaining_Solution(5, 3));
	}
}
