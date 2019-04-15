package sort;

public class BinaryInsertSort {

	/**
	 * 折半插入排序
	 * @param args
	 */
	public static void main(String[] args) {
		insertSort();//折半插入排序
	}
	
	/**
	 * 折半插入排序
	 * 思路：当执行插入第i个元素时，先将有序序列进行二分查找，
	 * 然后将第i个元素与中间元素比较，若找到插入位置则进行插入，
	 * 找不到继续进行二分查找，直至找到插入位置为止
	 */
	public static void insertSort(){
		int [] a = new int[]{12,123,23,1,32,45,32,34,23,348};
		for (int i = 1; i < a.length; i++) {
			int temp=a[i];
			int low = 0;
			int high = i-1;
			int j=(low+high)/2;//有序序列的中间位置
			while(low<=high){
				if(temp<a[j]){
					high = j-1;
				}else{
					low = j+1;
				}
				j = (low+high)/2;
			}
			//新数据插入位置low
			for (int m = i; m > low; m--) {
				a[m] = a[m-1];
			}
			a[low] = temp;
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
