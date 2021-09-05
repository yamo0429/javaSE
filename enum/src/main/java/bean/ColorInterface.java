package bean;

interface ColorInterface {

    String DB_NAME_1 = "loanDB"; // 接口里常量可以在实现类中使用
    String DB_NAME_2 = "mallDB";

    String getDbName(); // 接口方法需要在实现类中实现
    String getSqlName();
    int getNo();

}
