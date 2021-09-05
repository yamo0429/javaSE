package xml.beanUtil_xml_demo.demo1;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;


public class Test1Demo {
	public static void main(String[] args) throws Exception {
		
		SAXReader reader = new SAXReader();
		Document doc = reader.read("test1.xml");
		Element rootElement = doc.getRootElement();
		List<Element> elements = rootElement.elements();
		for (Element element : elements) {
			String clsName = element.attributeValue("className");
//			System.out.println(clsName);
			/**
			 * 反射创建相应的对象
			 */
			Class<?> cls = Class.forName(clsName);
			Object obj = cls.newInstance();
			
			List<Element> es2 = element.elements();
			for (Element e2 : es2) {
				/**
				 * 注意： name  value才是元数据（xml）
				 * name 是 javabean 中的元数据
				 * value是 对应的值
				 */
				String name = e2.attributeValue("name");
				String value = e2.attributeValue("value");
//				System.out.println("\t" + name + ":" + value);
				
				BeanUtils.setProperty(obj, name, value);
				
			}
			System.out.println(obj);
		}
	}
}
