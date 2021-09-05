package xml;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class BeanUtilsTest {
    @Test
    public void test1() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user, "id", "001");
        BeanUtils.setProperty(user, "username", "Ethan");
        BeanUtils.setProperty(user, "password", "123");
        System.out.println(user);

        String id = BeanUtils.getProperty(user, "id");
        String username = BeanUtils.getProperty(user, "username");
        String password = BeanUtils.getProperty(user, "password");
        System.out.println(id + "--" + username + "--" + password);
    }

    @Test
    public void test2() throws InvocationTargetException, IllegalAccessException {
        HashMap<String, Object> map = new HashMap<>();
        User user1 = new User();
        map.put("id", "001");
        map.put("username", "Ethan");
        map.put("password", "123");
        BeanUtils.populate(user1, map);
        System.out.println(user1);
    }


}
