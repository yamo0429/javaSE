package api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JSONObjectTest {

    @Test
    public void test(){
        Map map = new HashMap<>();
        map.put("aaa","aaa");
        map.put("bbb","bbb");
        map.put("ddd","ddd");

        System.out.println(map); // {aaa=aaa, bbb=bbb, ddd=ddd}
        String jsonString = JSONObject.toJSONString(map);
        System.out.println(jsonString); // {"aaa":"aaa","bbb":"bbb","ddd":"ddd"}
    }

    @Test
    public void test24(){
        Map map = new HashMap<>();
        map.put("aaa","aaa");
        map.put("ddd","ddd");

        System.out.println(map); // {aaa=aaa, bbb=bbb, ddd=ddd}
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString); // {"aaa":"aaa","bbb":"bbb","ddd":"ddd"}

    }

    @Test
    public void test2(){

        String ddd = "";
        if (StringUtils.isNullOrEmpty(ddd)){

        }
    }



}
