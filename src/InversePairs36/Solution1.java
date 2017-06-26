package InversePairs36;

import java.util.Arrays;

/**
 * Title:数组中的逆序对 
 * Description:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P
 * 。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 * 输入描述: 题目保证输入的数组中没有的相同的数字
 * 
 * 数据范围：对于%50的数据,size<=10^4 对于%75的数据,size<=10^5 对于%100的数据,size<=2*10^5
 * 
 * 输入例子: 1,2,3,4,5,6,7,0
 * 
 * 输出例子: 7
 * 
 * @author rico
 * @created 2017年6月24日 上午11:07:55
 */

public class Solution1 {

	public int InversePairs(int[] array) {
		if (array == null || array.length < 2) {
			return 0;
		} else {
			long result = InversePairs(array, 0, array.length-1);
			System.out.println(result);
			return (int) (result % 1000000007);
		}
	}

	public long InversePairs(int[] array, int from, int to) {
		if (from == to) {
			return 0;
		} else {
			int mid = (from + to) / 2;
			long left = InversePairs(array, from, mid);
			long right = InversePairs(array, mid + 1, to);
			long merge = merge(array, from, mid, to);
			long sum = left + right + merge;
			return sum;
		}
	}

	public int merge(int[] array, int from, int mid, int to) {
		int[] tmp = Arrays.copyOf(array, array.length);
		int p1 = mid;
		int p2 = to;
		int cur = to;
		int result = 0;

		while (p1 >= from && p2 >= mid + 1) {
			if (tmp[p1] > tmp[p2]) {
				result += p2 - mid;
				array[cur] = tmp[p1];
				p1--;
				cur--;
			} else {
				array[cur] = tmp[p2];
				p2--;
				cur--;
			}
		}

		while (p1 >= from) {
			array[cur] = tmp[p1];
			cur--;
			p1--;
		}

		while (p2 >= mid + 1) {
			array[cur] = tmp[p2];
			cur--;
			p2--;
		}

		return result;
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		 int[] array = {1,2,3,4,5,1,7,0};
//		int[] array = {7, 5, 6, 4};
		System.out.println("逆序对 ：" + s.InversePairs(array));
		System.out.println(Long.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
}
