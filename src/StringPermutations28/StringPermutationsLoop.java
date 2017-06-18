package StringPermutations28;
import java.util.Arrays;

/**
 * Title: 字符串全排列非递归算法(字典序全排列)
 * Description: 字典序全排列，其基本思想是：
 * 先对需要求排列的字符串进行字典排序，即得到全排列中最小的排列.
 * 然后,找到一个比它大的最小的全排列，一直重复这一步直到找到最大值,即字典排序的逆序列.
 * 
 * 不需要关心字符串长度
 * 
 * @author rico
 */
public class StringPermutationsLoop {

	/**
	 * @description 字典序全排列
	 * 
	 * 设一个字符串(字符数组)的全排列有n个，分别是A1,A2,A3,...,An
	 * 
	 * 1. 找到最小的排列 Ai
	 * 2. 找到一个比Ai大的最小的后继排列Ai+1
	 * 3. 重复上一步直到没有这样的后继
	 * 
	 * 重点就是如何找到一个排列的直接后继:
	 * 对于字符串(字符数组)a0a1a2……an,
	 * 1. 从an到a0寻找第一次出现的升序排列的两个字符(即ai < ai+1),那么ai+1是一个极值，因为ai+1之后的字符为降序排列，记 top=i+1;
	 * 2. 从top处(包括top)开始查找比ai大的最小的值aj，记 minMax = j;
	 * 3. 交换minMax处和top-1处的字符;
	 * 4. 翻转top之后的字符(包括top)，即得到一个排列的直接后继排列
	 * 
	 * @author rico
	 * @param s
	 *            字符数组
	 * @param from
	 *            起始下标
	 * @param to
	 *            终止下标
	 */
	public static void getStringPermutations4(char[] s, int from, int to) {
		
		Arrays.sort(s,from,to+1);  // 对字符数组的所有元素进行升序排列，即得到最小排列 
		System.out.println(s);    
		
		char[] descendArr = getMaxPermutation(s, from, to); // 得到最大排列,即最小排列的逆序列
		
		while (!Arrays.equals(s, descendArr)) {  // 循环终止条件：迭代至最大排列
			if (s != null && to >= from && to < s.length && from >= 0) { // 边界条件检查
				int top = getExtremum(s, from, to); // 找到序列的极值
				int minMax = getMinMax(s, top, to);  // 从top处(包括top)查找比s[top-1]大的最小值所在的位置
				swap(s, top - 1, minMax);  // 交换minMax处和top-1处的字符
				s = reverse(s, top, to);   // 翻转top之后的字符
				System.out.println(s);
			}
		}
	}
	
	/**
	 * @description 对字符数组中的制定字符进行交换
	 * @author rico
	 * @param s
	 * @param from
	 * @param to
	 */
	public static void swap(char[] s, int from, int to) {
		char temp = s[from];
		s[from] = s[to];
		s[to] = temp;
	}

	/**     
	 * @description 获取序列的极值
	 * @author rico       
	 * @param s 序列
	 * @param from 起始下标
	 * @param to 终止下标
	 * @return     
	 */
	public static int getExtremum(char[] s, int from, int to) {
		int index = 0;
		for (int i = to; i > from; i--) {
			if (s[i] > s[i - 1]) {
				index = i;
				break;
			}
		}
		return index;
	}
	  
	/**     
	 * @description 从top处查找比s[top-1]大的最小值所在的位置
	 * @author rico       
	 * @created 2017年5月10日 上午9:21:13     
	 * @param s
	 * @param top 极大值所在位置
	 * @param to
	 * @return     
	 */
	public static int getMinMax(char[] s, int top, int to) {
		int index = top;
		char base = s[top-1];
		char temp = s[top];
		for (int i = top + 1; i <= to; i++) {
			if (s[i] > base && s[i] < temp) {
				temp = s[i];
				index = i;
			}
			continue;
		}
		return index;
	}
	  
	/**     
	 * @description 翻转top(包括top)后的序列
	 * @author rico       
	 * @param s
	 * @param from
	 * @param to
	 * @return     
	 */
	public static char[] reverse(char[] s, int top, int to) {
		char temp;
		while(top < to){
			temp = s[top];
			s[top] = s[to];
			s[to] = temp;
			top ++;
			to --;
		}
		return s;
	}
	  
	/**     
	 * @description 根据最小排列得到最大排列
	 * @author rico       
	 * @param s 最小排列
	 * @param from 起始下标
	 * @param to 终止下标
	 * @return     
	 */
	public static char[] getMaxPermutation(char[] s, int from, int to) {
		//将最小排列复制到一个新的数组中
		char[] dsc = Arrays.copyOfRange(s, 0, s.length);
		int first = from;
		int end = to;
		while(end > first){  // 循环终止条件
			char temp = dsc[first];
			dsc[first] = dsc[end];
			dsc[end] = temp;
			first ++;
			end --;
		}
		return dsc;
	}

	public static void main(String[] args) {
		char[] target = { 'a', 'a', 'b', 'c'};
		getStringPermutations4(target, 0, target.length - 1);
	}
}
