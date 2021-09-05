package api;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * ##6. Properties类
 * 1. Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
 * 2. 特点：
 * 1. 是Hashtable的子类，map集合中的方法都可以用。
 * 2. 该集合没有泛型。键值都是字符串。
 * 3. 它是一个可以持久化的属性集。键值可以存储到集合中，也可以存储到持久化的设备(硬盘、U盘、光盘)上。键值的来源也可以是持久化的设备。
 * 4. 有和流技术相结合的方法。
 * 3. 方法：
 * 1. setProperty(String key, String value)：调用 Hashtable 的方法 put
 * 2. stringPropertyNames()返回此属性列表中的键集
 * 3. getProperty(String key)用指定的键在此属性列表中搜索属性
 * <p>
 * 4. store(Writer,comments)和 store(OutputStream,comments)
 * 1. 把集合中的数据，保存到指定的流所对应的文件中，参数comments代表描述信息
 * 5. load(InputStream) 和load(Reader)
 * 1. 把指定流所对应的文件中的数据，读取出来，保存到Propertie集合中
 * <p>
 * 4. 获取本地系统的属性集
 * 1. Properties prop = System.getProperties() 所有属性集
 * 2. String country = System.getProperty("user.country") 单个属性集
 */
public class PropertiesDemo {
    /**
     * properties 属性集类的 Map 接口方法、特有方法演示
     */
    @Test
    public void properties_method() {
        // 创建一个属性集合，注意用Map接收
        Map<Object, Object> map = new Properties();

        // Map接口方法实参存取
        map.put("曹雪芹", "红楼梦");
        map.put("吴晨恩", "西游记");
        map.put("罗贯中", "三国演义");
        map.put("施耐奄", "水浒传");
        // 遍历
        Set<Object> keys = map.keySet();
        for (Object key : keys) {
            Object value = map.get(key);
            System.out.println("key:" + key + ", value:" + value);
        }

        // properties 特有方法实现存储与读取
        Properties prop = new Properties();
        prop.setProperty("刘德华", "综合");
        prop.setProperty("张学友", "歌神");
        prop.setProperty("黎明", "颜值担当");
        prop.setProperty("郭富城", "舞神");
        // 遍历
        Set<String> names = prop.stringPropertyNames();
        for (String name : names) {
            String value = prop.getProperty(name);
            System.out.println("key:" + name + ", value:" + value);
        }
    }

    /**
     * properties 属性集类 与 流
     */
    @Test
    public void properties_stream() throws IOException {
        //保存资源:持久化
        Properties properties = new Properties();
//        properties.setProperty("红楼梦", "曹雪芹");
//        properties.setProperty("三国志", "陈寿");
//
//        properties.store(new FileOutputStream("a.properties"), "文档注释");//第二个参数是文档描述信息
//        properties.store(new FileWriter("a.properties"), "文档注释2");

        //加载资源
        properties.load(new FileReader("b.properties")); //项目根路径下（与src同级）
//        properties.load(PropertiesDemo.class.getClassLoader().getResourceAsStream("a.properties")); //项目resources资源路径下
        Set<String> keySet = properties.stringPropertyNames();
        for (String key : keySet) {
            String value = properties.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    /**
     * properties属性集类 与 System类
     */
    @Test
    public void properties_system() throws IOException {
        Properties properties = System.getProperties();
        Set<String> keySet = properties.stringPropertyNames();
        for (String key : keySet) {
            String value = properties.getProperty(key);
//			System.out.println(key + " = " + value);
        }
        String property = System.getProperty("os.version");
        System.out.println(property);
    }

}
