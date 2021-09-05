package bean;

public class SubStar {
    String name;
    String length;

    public SubStar(String name, String length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "SubStar{" +
                "name='" + name + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
