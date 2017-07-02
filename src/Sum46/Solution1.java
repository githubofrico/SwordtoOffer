package Sum46;

/**
 * Title:求1+2+3+...+n
 * Description:求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch
 * 、case等关键字及条件判断语句（A?B:C）。
 * 
 * @author rico
 * @created 2017年7月2日 上午11:26:35
 */
public class Solution1 {
	public int Sum_Solution(int n) {
		if (n == 1) {
			return 1;
		} else {
			return Sum_Solution(n - 1) + n;
		}
	}
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.Sum_Solution(5));
	}
}
