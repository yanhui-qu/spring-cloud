package sort;

public class InsertSort {

	/**
	 * 直接插入排序
	 * @param args
	 */
	public static void main(String[] args) {
		insertSort1();//直接插入排序一
		System.out.println();
		insertSort2();//直接插入排序二
		System.out.println();
		insertSort3();//直接插入排序三
	}

	/**
	 * 直接插入排序一
	 * 思路：当执行插入第i个元素时，将第i个元素与有序元素集合一一比较，并交换位置，
	 * 直至找到插入的位置，不会后移元素
	 */
	public static void insertSort1(){
		int [] a = new int[]{12,23,1,32,45,32};
		for (int i = 1; i < a.length; i++) {
			int temp=0;
			for (int j = 0; j < i; j++) {
				if(a[i]<a[j]){
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
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
	
	/**
	 * 直接插入排序二
	 * 思路：当执行插入第i个元素时，将第i个元素与有序元素集合比较，若大于第i个元素，则该元素后移
	 * 直至找到插入的位置
	 */
	public static void insertSort2(){
		int [] a = new int[]{12,23,1,32,45,32};
		for (int i = 1; i < a.length; i++) {
			int temp=a[i];
			int j=i;
			for (j = i; j > 0; j--) {
				if(temp<a[j-1]){
					a[j] = a[j-1];
				}else{
					break;
				}
			}
			a[j]=temp;
		}
		for (int i = 0; i < a.length; i++) {
			if(i==a.length-1){
				System.out.print(a[i]);
			}else{
				System.out.print(a[i]+", ");
			}
		}
	}
	/**
	 * 直接插入排序三
	 * 思路：当执行插入第i个元素时，将第i个元素与有序元素集合比较，若大于第i个元素，则该元素后移
	 * 直至找到插入的位置
	 */
	public static void insertSort3(){
		int [] a = new int[]{12,23,1,32,45,32};
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i;
			while(j>0 && temp<a[j-1]){
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
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
