package sort;


public class MergeSort {

	/**
	 * 归并排序
	 * 效率：时间复杂度O（nlogn），空间复杂度O（n）
	 */
	public static void main(String[] args) {
		//定义整型数组
		int[] a = {12,123,23,1,32,45,32,34,0,23,348,1,2,323};
		
		mergeSort(a, 0, a.length-1);//归并排序
		
		for (int i = 0; i < a.length; i++) {
			if(i==a.length-1){
				System.out.print(a[i]);
			}else{
				System.out.print(a[i]+", ");
			}
		}
	}
	
	/**
	 * 归并排序
	 * 思路：
	 * 1.利用分治法将待排序数组进行拆分
	 * 2.重复步骤1，将拆分后的子数组进行拆分，直至子元素的长度为1
	 * 3.合并，对拆分的元素进行排序，然后合并
	 * 拆分
	 * {3,8,6,1,5,2,4}
	 * {3,8,6,1},{5,2,4}
	 * {3,8},{6,1}, {5},{2,4}
	 * {3},{8},{6},{1}, {5},{2},{4}
	 * 合并
	 * {3,8},{1,6}, {5},{2,4}
	 * {1,3,6,8}, {2,4,5}
	 * {1,2,3,4,5,6,8}
	 */
	public static void mergeSort(int[] a, int low, int high) {
		if(low<high){
			int middle = (low + high)/2;
			mergeSort(a, low, middle);
			mergeSort(a, middle+1, high);
			
			merge(a, low, middle, high);
		}
		
	}
	
	public static void merge(int[] a, int low, int middle, int high) {
		int i=low, m=middle+1;
		int [] arr = new int[high-low+1];//临时数组
		int k=0;
		//将子数组排序并放进临时数组
		while(i<=middle && m<=high){
			arr[k++] = a[i] < a[m] ? a[i++] : a[m++];
		}
		while(i<=middle){
			arr[k++] = a[i++];
		}
		while(m<=high){
			arr[k++] = a[m++];
		}
		//将子数组合并至原数组
		for (int j = 0; j < arr.length; j++) {
			a[low+j] = arr[j];
		}
	}
	
}
