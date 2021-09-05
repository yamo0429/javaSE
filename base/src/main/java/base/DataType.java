package base;

import org.junit.Test;

public class DataType {

    /**
     * byte占一个字节（即8个二进制位），表示-128~127，为何128就超出一个字节的内存了呢？
     * 答案：在二进制里，有一个位模式的概念，8位的位模式下，8个比特位表示的数值范围为-128~127（即00000000表示-128，而11111111表示127），
     * 而128超出了这个范围，在127基础上加1，那么所有数位依次进1，导致结果该字节的8个位变成00000000（对应十进制数值为-128）。故计算时可能超出范围，而损失精度
     */
    @Test
    public void test21(){
        byte aa = 127;
        int bb = 1;
        byte cc = (byte)(aa + bb);
        System.out.println(cc); // 结果-128，而不是128
    }

    @Test
    public void test2(){
        float aa =10.3F;
        float cc = aa%3;
        System.out.println(cc); // 1.3000002
    }
    @Test
    public void test3(){
        float aa =10.4F;
        System.out.println(aa/3); // 3.4666665
        System.out.println(3.4666665*3); // 10.3999995
    }

    /***
     * 隐式数据类型转换：取值范围小的数据类型与取值范围大的数据类型进行运算,会先将小的数据类型提升为大的,再运算
     */
    @Test
    public void test32(){
        //直接输出了运算的结果
        System.out.println(3 + 4);

        //定义两个int类型的变量
        int a = 3;
        int b = 4;
        int c = a + b;
        System.out.println(c);

        //定义一个byte类型,定义一个int类型
        byte bb = 2;
        int cc = 5;
        System.out.println(bb + cc);

        //我能不能不直接输出，用一个变量接受呢?
        //用变量接受，这个变量应该有类型
        //可能损失精度
        //byte dd = bb + cc;
        int dd = bb + cc;
        System.out.println(dd);
    }

    /**
     * 强制类型数据转换:如果超出了被赋值的数据类型的取值范围，会有精度的损失
     */
    @Test
    public void test322(){
        int a = 3;
        byte b = 4;
        int c = a + b;
        //byte d = a + b;
        byte d = (byte) (a + b);
    }

    @Test
    public void test3212(){
    }

    @Test
    public void test3222(){
    }


}
