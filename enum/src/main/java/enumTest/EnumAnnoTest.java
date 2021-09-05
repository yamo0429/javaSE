package enumTest; /**
 * 枚举类作为注解类的成员，需要结合反射解析使用
 */
import java.lang.annotation.*;

public class EnumAnnoTest{
    public static void main(String[] args) {

    }
}

@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface EnumAnno {
    //注解里的枚举类
    enum Permission {
        ANCHOR(0),
        DIRECTORE(1);

        private int id;

        public int getId() {
            return id;
        }

        Permission(int id) {
            this.id = id;
        }

        /**
         * 对外提供静态方法
         */
        public static Permission convert(String id) {
            Permission[] permissions = Permission.values();
            for (Permission permission : permissions) {
                if (String.valueOf(permission.getId()).equals(id))
                    return permission;
            }
            return null;
        }
    }

    //注解里的属性
    Permission value();
}
