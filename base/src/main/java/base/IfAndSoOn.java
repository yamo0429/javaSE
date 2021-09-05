package base;

import org.junit.Test;

public class IfAndSoOn {

    /**
     *
     * 三种循环的区别：
     * 		A:do...while至少执行一次循环体
     * 		B:for,while循环先判断条件是否成立，然后决定是否执行循环体
     *
     * for和while的小区别：
     * 		for循环的初始化变量，在循环结束后，不可以被访问。而while循环的初始化变量，是可以被继续使用的。
     * 		如果初始化变量，后面还要继续访问，就使用while，否则，推荐使用for。原因是for循环结束，该变量就从内存中消失，能够提高内存的使用效率
     */

    @Test
    public void test152(){
        /*
		int x = 3;
		while(x<3) {
			System.out.println("我爱林青霞");
			x++;
		}
		System.out.println("--------------");
		int y = 3;
		do {
			System.out.println("我爱林青霞");
			y++;
		}while(y<3);
		*/


        for(int x=1; x<=10; x++){
            System.out.println("爱生活，爱Java");
        }
        //这里的x无法继续访问
        //System.out.println(x);
        System.out.println("-----------------");

        int y = 1;
        while(y<=10) {
            System.out.println("爱生活，爱Java");
            y++;
        }
        System.out.println(y);
    }

    /**
     * 控制跳转语句：break、continue
     * break：跳出循环，让循环提前结束
     * continue：结束一次循环，继续下一次的循环
     */
    @Test
    public void test192(){
        for(int x=1; x<=10; x++) {
            if(x == 3) {
                break;
//                continue;
            }
            System.out.println("HelloWorld");
        }
    }

    /**冒泡排序*/
    @Test
    public void te33st(){
        int[] arr = {2, 3, 1};

        // 第一个for表示对待排序的数组进行arr.length-1次比较，实际比较操作都在第二个for里
        for (int i = 0; i < arr.length-1; i++) { // -1表示最后一个，已经是最小，不用再比较了
            for (int j = 0; j < arr.length-1-i; j++) { // 每次只运送一个最大值到末尾。-1防止索引越界，-i表示已经跳过排好序的那个
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

    @Test
    public void tess(){
        int[] aaa = {5,4,3,2,1};
        for (int i = 0; i < aaa.length-1; i++) {
            for (int j = 0; j < aaa.length-1-i; j++) {
                if (aaa[j]>aaa[j+1]){
                    int temp=aaa[j];
                    aaa[j]=aaa[j+1];
                    aaa[j+1]=temp;
                }
            }
        }
        System.out.println(aaa);
    }

    @Test
    public void te3ss(){
        for(int i = 1;i<10;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(j+"*"+i+"="+j*i+" ");
            }
            System.out.println();
        }
    }

}
