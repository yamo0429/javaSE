package enumTest;

import bean.Color6;
import org.junit.Test;

/**
 * 测试：枚举类实现接口后，每个枚举实例均需要实现接口方法,调用接口方法才能测试成功
 */
public class EnumInterfaceTest {

    @Test
    public void enumInterfaceTest2() {
        // 可将Color6.ONE作为参数传递，然后调用其方法获取枚举实例里面的属性值
        System.out.println(Color6.ONE.getDbName() + "===" + Color6.ONE.getSqlName()  + "===" + Color6.ONE.getNo());

        Color6[] values = Color6.values();
        for (Color6 color : values) {
            System.out.println(color + ":" +color.getDbName() + "===" +color.getSqlName() + "===" +color.getNo());
        }
    }

}

