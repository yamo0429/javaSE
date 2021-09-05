package jdkAnno;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * ## 2. JDK提供的注解
 * 1. Override 重写
 * 1. 被 override 注解修饰的方法必须是父类中bei重写方法或接口中的抽象方法
 * <p>
 * 2. Deprecated 过时
 * 1. 一些该方法后期发现了一些安全隐患, 或者是有更好的方式取代了该方法, 因此不建议使用了.
 * 2. 没有任何参数信息的注解被称为  `标识注解`.
 * <p>
 * 3. SuppressWarnings	抑制警告
 * 0. 让编译器不要报出警告信息
 * 1. 属性：rawtypes ，忽略类型安全  unused ，忽略不使用  serial, 忽略序列号
 * 2. 属性：all，忽略所有（记住这个就够了）
 */
@SuppressWarnings("all")
public class BasicAnnotationDemo {

    //	@SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {

        Wolf w = new Wolf();
        w.eatSheep();

//		@SuppressWarnings({ "rawtypes", "unused" })
        ArrayList list = new ArrayList();

        ArrayList<String> list2 = new ArrayList<String>();
        list2.size();

        FileReader fr = new FileReader("");
//		fr.close();
    }
}


class Animal {
    void eat() {
    }
}

class Wolf extends Animal {

    @Override
    void eat() {
        super.eat();
    }

    /**
     * 方法设计者，在以后的版本中发现这个方法有安全隐患，会让这个方法过时！
     * 不能直接删除这个方法，如果删除了，之前的开发者项目就报错了！！！！
     * 向下兼容！
     * 提示用户：这个方法有安全隐患，现在有相应的替代方案。
     */
    //此方法已经过时，请用loveSheep替代
    @Deprecated
    void eatSheep() {
        System.out.println("灰太狼正在吃羊！");
    }

    void loveSheep() {
        System.out.println("灰太狼爱上了喜羊羊！");
    }
}














