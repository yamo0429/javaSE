package bean;

import java.util.List;

public class Star {
    String type;
    String size;
    List<SubStar> subStarList;

    public Star(String type, String size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<SubStar> getSubStarList() {
        return subStarList;
    }

    public void setSubStarList(List<SubStar> subStarList) {
        this.subStarList = subStarList;
    }

    @Override
    public String toString() {
        return "Star{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", subStarList=" + subStarList +
                '}';
    }
}
