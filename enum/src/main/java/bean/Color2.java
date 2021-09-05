package bean;

public enum Color2 {
    //	必须放在第一行
    Red("红色", 1),
    Yellow("黄色", 3);

    private String color;
    private int no;

    public String getColor() {
        return color;
    }

    public int getNo() {
        return no;
    }

    //必须用默认或者 private 修饰，本类中的枚举实例在声明的时候，就会调用该构造器初始化自己的属性，删除会报错
    Color2(String color, int no) {
        this.color = color;
        this.no = no;
    }

    /**
     * 提供对外的静态方法
     */
    public static Color2 outerMethod(int no) {
        Color2[] values = Color2.values(); //values是枚举类自带的方法之一，见EnumMethodTest演示
        for (Color2 color2 : values) {
            if (color2.getNo() == no) {
                return color2;
            }
        }
        return null;
    }

}