package sort;

public class SelectSort {

	/**
	 * 选择排序之简单选择排序
	 * @param args
	 */
	public static void main(String[] args) {
		selectSort();//简单选择排序
	}
	
	/**
	 * 简单选择排序
	 * 思路：
	 * 将数组第一位元素与之后的每一位元素依次进行比较（存在数组a,长度len;a[0]与a[1]比较，a[0]与a[2]比较，依次类推，直至a[0]与a[len-1];
	 * 以升序排列为例，比较时若前者大于后者，则二者交换位置后再接着比较下一组）。没进行一轮（一次for循环）就能获取一个最小值，放在开始比较的位置。
	 * 即第一轮结束获取该数组的最小值放在首位，进行下一轮比较时从第二个元素开始即可，比较结束后最小值放在第二位；依次类推。
	 * 重复上述进行比较...总共比较n-1次。
	 */
	public static void selectSort(){
		int [] a = new int[]{12,123,23,1,32,45,32,34,0,23,348,1,2,323};
		for (int i = 0; i < a.length-1; i++) {
			int min=0;
			for (int j = i+1; j < a.length; j++) {
				if(a[i]>a[j]){
					min = a[j];
					a[j] = a[i];
					a[i] = min;
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
