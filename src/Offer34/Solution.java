package Offer34;

/**
 * Title: 丑数 Description: 把只包含因子2、3和5的数称作丑数（Ugly
 * Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * @author rico
 * @created 2017年6月23日 下午8:40:35
 */
public class Solution {
	  
	/**     
	 * @description 依次判断每个数是否为丑数
	 * @author rico       
	 * @created 2017年6月24日 上午8:35:11     
	 * @param index
	 * @return     
	 */
	public int GetUglyNumber_Solution(int index) {
		int count = 0;
		int number = 1;
		while (count < index) {
			if (isUglyNumber(number)) {
				count++;
			}
			if (count == index)
				break;
			number++;
		}
		return number;
	}

	  
	/**     
	 * @description 判断一个数是否为丑数
	 * @author rico       
	 * @created 2017年6月24日 上午8:33:52     
	 * @param num
	 * @return     
	 */
	public boolean isUglyNumber(int num) {
		int tmp = num;
		if (tmp == 1) {
			return true;
		}else if (tmp % 2 == 0) {
			tmp /= 2;
			return isUglyNumber(tmp);
		} else if (tmp % 3 == 0) {
			tmp /= 3;
			return isUglyNumber(tmp);
		} else  if (tmp % 5 == 0){
			tmp /= 5;
			return isUglyNumber(tmp);
		}else{
			return false;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.GetUglyNumber_Solution(2000));
	}
}
