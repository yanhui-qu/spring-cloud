package sort;


public class HeapSort {

	/**
	 * 选择排序之堆排序
	 * @param args
	 * 效率：时间复杂度O（nlogn），一个辅助空间
	 */
	public static void main(String[] args) {
		heapSort();//堆排序
	}
	
	/**
	 * 堆排序
	 * 思路：
	 * 堆排序使用堆结构的性质，堆是一个完全二叉树的结构，且其父节点比两个孩子节点（如存在）值都大（或都小，都大的叫大顶堆，都晓得叫小顶堆）
	 * 1.将原数组构建大顶堆，最大值被放到跟根节点；
	 * 2.将构建好的堆的首位与末位交换位置，最大值放到最后；
	 * 3.交换位置后，首位的最大值被替换后，不再满足堆结构，将数组前（n-1）个元素重复步骤1、2，重构堆结构并交换位置
	 * 注：执行步骤3，重构堆结构时，数组长度每次减1，即交换后的最大值不再参与堆结构重建
	 */
	public static void heapSort() {
		int [] a = new int[]{12,123,23,1,32,45,32,34,0,23,348,1,2,323};
		int len = a.length-1;
		//初始化大顶堆，从最后一个非叶子节点开始构建
		for (int i = (len-1)/2; i >=0 ; i--) {
			initHeap(a, i, len);
		}
		
		//首末未位置交换后，重构大顶堆
		for (int i = len; i > 0; i--) {
			if(a[0]>a[i]){
				int temp = a[0];
				a[0] = a[i];
				a[i] = temp;
			}
			initHeap(a, 0, i-1);
		}
		
		for (int i = 0; i < a.length; i++) {
			if(i==a.length-1){
				System.out.print(a[i]);
			}else{
				System.out.print(a[i]+", ");
			}
		}
	}	
	
	//构建堆结构，根据完全二叉树的结构可知，所有非叶子节点左孩子肯定存在，右孩子可能不存在
	//从第一个非叶子节点开始初始化堆结构，向上遍历
	public static void initHeap(int[] a, int parent, int high) {
		//low,high 参与对构建的数组的索引（参与元素的第一个和最后一个索引）
		//i代表非叶子节点，i=(high-1)/2
		for (int i = 2*parent+1; i <= high; i=2*i+1) {
			
			if(i < high && a[i]<a[i+1]){
				if(a[parent]<a[i+1]){
					i=i+1;
				}
			}
			if(a[parent]<a[i]){
				int temp = a[parent];
				a[parent] = a[i];
				a[i] = temp;
				parent = i;
			}
			
		}
		
	}
	
}
