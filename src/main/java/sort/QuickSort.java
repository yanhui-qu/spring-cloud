package sort;

public class QuickSort {

	/**
	 * 交换排序之快速排序
	 * @param args
	 */
	public static void main(String[] args) {
		int [] a = new int[]{12,123,23,1,32,45,32,34,0,23,348,1,2,323};
		int low =0;
		int high = a.length-1;
		quickSort(a, low, high);//快速排序
		for (int i = 0; i < a.length; i++) {
			if(i==a.length-1){
				System.out.print(a[i]);
			}else{
				System.out.print(a[i]+", ");
			}
		}
	}
	
	/**
	 * 快速排序
	 * 思路：随机选择数组的一个元素作为中轴，通过比较将比中轴大的元素放到右侧，小的放到左侧；通过对左右两侧数据分别递归调用进行比较
	 * 1.待排序有数组a,则令low=0;high=a.length-1;
	 * 2.随机选择数组的一个元素作为枢轴,此处取temp = a[low]，
	 * 3.将temp与数组high位置开始向前匹配，直至出现temp>a[high]，将a[high]=a[low],
	 * 4.然后temp与数组low位置开始向后匹配，直至出现temp<a[high]，将a[low]=a[high],
	 * 5.如此循环3,4，直至low=high,终止循环，此时a[low]=temp,并返回low，如此low将数组分为左右两个子数组。
	 * 6.分别对得到的子数组重复1-5步骤，即递归调用
	 */
	public static void quickSort(int a[], int low, int high){
		int mid = quick(a, low, high);//确定中轴的位置
		if(low<high && mid>1){//对左侧进行快速排序
			quickSort(a, low, mid-1);
		}
		if(low<high && mid+1<high){//对右侧进行快速排序
			quickSort(a, mid+1, high);
		}
	}
	
	public static int quick(int a[], int low, int high){
		int temp = a[low];
		while(low<high){
			while(low<high){
				if(temp>a[high]){
					a[low] = a[high];
					break;
				}else{
					high--;
				}
			}
			while(low<high){
				if(temp<a[low]){
					a[high] = a[low];
					high--;
					break;
				}else{
					low++;
				}
			}
			
		}
		a[low] = temp;
		return low;
	}
	
}
