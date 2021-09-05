package bean;

public enum Color3 {
    //	必须放在第一行，可以设置任意多个属性
    Red("红色", 1, 11),
    Yellow("黄色", 2, 22);

    private String color;
    private int no;
    private int num;

    //构造器对枚举实例的属性进行初始化
    Color3(String color, int no, int num) {
        this.color = color;
        this.no = no;
        this.num = num;
    }
    //对外提供获取枚举实例的属性的方法
    public String getColor() {
        return color;
    }
    public int getNo() {
        return no;
    }
    public int getNum() {
        return num;
    }

}
