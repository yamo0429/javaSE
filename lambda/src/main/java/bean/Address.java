package bean;

public class Address {
    int no;
    String desc;

    public Address(int no, String desc) {
        this.no = no;
        this.desc = desc;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Address{" +
                "no=" + no +
                ", desc='" + desc + '\'' +
                '}';
    }
}
