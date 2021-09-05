package bean;

//测试实现接口方法，有枚举实例，有属性值、属性、构造器
public enum Color6 implements ColorInterface {

    ONE(DB_NAME_1, "aaa", 11), // 引用接口里的常量
    TWO(DB_NAME_2, "bbb", 22),
    THREE("db2", "ccc", 33);

    private String dbName;
    private String sqlName;
    private int no;

    Color6(String dbName, String sqlName, int no) {
        this.dbName = dbName;
        this.sqlName = sqlName;
        this.no = no;
    }

    @Override
    public String getDbName() {
        return dbName;
    }

    public String getSqlName() {
        return sqlName;
    }

    @Override
    public int getNo() {
        return no;
    }
}
