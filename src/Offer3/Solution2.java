package Offer3;

import java.util.Arrays;

/**
 * Title : 二维数组中的查找 
 * Description : 不断剔除无关行列，缩小查找范围
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 
 * @author rico
 */    
public class Solution2 {

	public static boolean contain(int[][] array, int target) {
		
		// 目标数组不为null且含有元素
		if(array != null && array.length > 0){
			int row = 0;
			int col = array[row].length - 1;
			if(col >= 0){
				// 不断搜索目标值，直到搜索到结果或者将范围缩成空
				while(row <= array.length-1 && col >= 0){
					//从二维数组的右上角搜索，右上角值小于目标值，则搜索到结果
					if(array[row][col] == target){
						return true;
					} else if(array[row][col] > target){ // 右上角值大于目标值，则删除列
						col--;
					} else{
						row++;  // 右上角值小于目标值，则删除列
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[][] = {new int[]{1,2,8,9},new int[]{2,4,9,12},new int[]{4,7,10,13},new int[]{6,8,11,15}};
		System.out.println(contain(arr, 5));
		System.out.println(Arrays.toString(arr));
	}
}
