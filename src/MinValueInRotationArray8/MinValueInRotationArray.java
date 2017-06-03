package MinValueInRotationArray8;

public class MinValueInRotationArray {

	public int minNumberInRotateArray(int[] array) {
		if (array != null || array.length == 0 ) {
			if (array.length != 1) {
				// 查找旋转点
				int index = 0;
				for (int i = 0; i < array.length; i++) {
					if (i + 1 < array.length) {
						if (array[i+1] < array[i]) {
							index = i + 1;
							break;
						}
					}
				}
				
				// 二分查找
				return array[index];
			}
			return array[0];
		}
		return 0;
	}
}
