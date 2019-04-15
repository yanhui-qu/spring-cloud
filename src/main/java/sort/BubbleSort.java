package sort;

public class BubbleSort {

	/**
	 * 交换排序之冒泡排序
	 * @param args
	 */
	public static void main(String[] args) {
		bubbleSort();//冒泡排序
	}
	
	/**
	 * 冒泡排序
	 * 思路：
	 * 从数组第一位元素开始，每两位相邻元素一组相比较（存在数组a,长度len;a[0]与a[1]比较，a[1]与a[2]比较，依次类推，
	 * 直至a[len-2]与a[len-1];以升序排列为例，若前者大于后者，则二者交换位置后再接着比较下一组。），每比较一轮进行一
	 * 次for循环，要想完成排序则需要len-1轮，因此需要两次for循环。
	 */
	public static void bubbleSort(){
		int [] a = new int[]{12,123,23,1,32,45,32,34,0,23,348,1,2,323};
		for (int i = 0; i < a.length-1; i++) {
			int min=0;
			for (int j = 0; j < a.length-1; j++) {
				if(a[j]>a[j+1]){
					min = a[j+1];
					a[j+1] = a[j];
					a[j] = min;
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			if(i==a.length-1){
				System.out.print(a[i]);
			}else{
				System.out.print(a[i]+", ");
			}
		}
	}
	
}
