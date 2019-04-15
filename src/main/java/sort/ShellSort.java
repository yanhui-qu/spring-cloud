package sort;

public class ShellSort {

	/**
	 * 希尔排序
	 * @param args
	 */
	public static void main(String[] args) {
		insertSort();//折半插入排序
	}
	
	/**
	 * 希尔排序
	 * 思路：
	 * 1.根据数组确定步长，并根据步长分组
	 * 2.对按步长分组的数据分别进行直接插入排序，排完序后，进行合并，并确定下一个步长
	 * 3.重复步骤2，直至步长为1
	 * 本例步长选择数组长度1/2;
	 * {12,123,23,1,32,45,32,34,0,23,348,1,2,323}
	 * 第一次分组步长7：
	 * 
	 *  12    				 34
	 *     123                  0
	 *     	   23                 23
	 *            1                  348
	 *              32                    1 
	 *                  45                 2
	 *                    32                 323
	 * 第二次分组步长3：
	 * (12,1,32,23,2),(123,32,34,348,323),(23,45,0,1)
	 *  12        1       32      23       2
	 *     123      32       34      348     323
	 *         23       45      0         1                 
	 * 第三次。。。。。                       
	 */
	public static void insertSort(){
		int [] a = new int[]{12,123,23,1,32,45,32,34,0,23,348,1,2,323};
		int d = a.length/2;
		while(true){
			for (int i = 0; i < a.length/d; i++) {//按步长分若干组
				for (int j = i; j < a.length/d; j=j+d) {//每一个步长分若干组
					int temp=a[j];
					int m=j;
					for (m = j; m > i; m--) {//对单个步长下的每组进行直接插入排序
						if(temp<a[m-1]){
							a[m] = a[m-1];
						}else{
							break;
						}
					}
					a[m]=temp;
				}
			}
			d = d/2;
			if(d<1){
				break;
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
