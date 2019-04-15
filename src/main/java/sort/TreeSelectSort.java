package sort;


public class TreeSelectSort {

	/**
	 * 选择排序之树形选择排序
	 * @param args
	 * 效率：时间复杂度O（nlogn），占用较多的辅助空间
	 */
	public static void main(String[] args) {
		treeSelectSort();//树形选择排序
	}
	
	/**
	 * 树形选择排序
	 * 思路：
	 * 1.将数组的元素两两相比较，得到n/2个较小的元素，
	 * 2.重复步骤1，直至取到最小的元素。
	 * 3.将剩余n-1个元素继续1，2中步骤比较
	 * 注：此处用到完全二叉树的性质
	 * 使用完全二叉树实现：将n个元素放到二叉树的最后n个位置，两两比较较小的放到二者父亲的位置，直至将最小值放到根节点为止；
	 * 第一次取到最小值后，将该值取出放到原来数组的第一个位置，将二叉树中该值得为设置为最大值Integer.MAX_VALUE，进行
	 * 下一轮比较。
	 */
	public static void treeSelectSort() {
		int [] a = new int[]{12,123,23,1,32,45,32,34,0,23,348,1,2,323};
		int len = a.length;
        int treeSize = 2 * len - 1; // 完全二叉树的节点数
        int[] tree = new int[treeSize];
        int j = treeSize;
        //将数组放到tree中
        for (int i = len-1; i >= 0; i--) {
			tree[j-1] = a[i];
			j--;
		}
        // 根据叶子节点两两比较，去较小的，填充非叶子节点(即填入到父节点,根据完全二叉树特性可以确定父节点位置(i-1)/2)
        for (int i = treeSize-1; i > 0; i-=2) { 
        	tree[(i-1)/2] = tree[i]>tree[i-1] ? tree[i-1] : tree[i];
        }
        
        
        //重复寻找最小值，将最小值按顺序重新放回原来的数组
        int ii = 0;
        while (ii < len) {
        	int min = tree[0];//数组比较后的最小值
            int minIndex = 0;
            //确定最小值在tree中的位置
            for (int i = treeSize-1; i > 0; i--) {
    			if(min==tree[i]){
    				minIndex = i;
    				// 将最小值设置为最大(设置为Integer.MAX_VALUE)
    		        tree[i] = Integer.MAX_VALUE; //设置一个最大值标志
    				break;
    			}
    		}
            
          //将最小值按顺序重新放回原来的数组
            a[ii++] = min;
           
            // 找到其兄弟节点
            while (minIndex > 0) {//如果其还有父节点，继续向上寻找并比较，直至将最小值放到根节点
                if (minIndex % 2 == 0) {//如果为右节点,跟其左节点作比较，取最小值
                    tree[(minIndex-1)/2] = tree[minIndex]>tree[minIndex-1] ? tree[minIndex-1] : tree[minIndex];
                    minIndex = (minIndex - 1) / 2; //设置为父节点的索引,继续向上比对
                } else {//如果为左节点,跟其右节点作比较，取最小值
                    tree[minIndex/2] = tree[minIndex]>tree[minIndex+1] ? tree[minIndex+1] : tree[minIndex];
                    minIndex = minIndex / 2; //设置为父节点的索引,继续向上比对
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
