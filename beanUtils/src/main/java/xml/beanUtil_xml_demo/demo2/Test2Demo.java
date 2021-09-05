package xml.beanUtil_xml_demo.demo2;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class Test2Demo {
	
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read("test2.xml");
		Element rootElement = document.getRootElement();
		
		
		List<Element> elements = rootElement.elements();
		
		ArrayList<Student> list = new ArrayList<Student>();
		for (Element element : elements) {
			Student student = new Student();
			
			String stuNo = element.attributeValue("stuNo");
			student.setStuNo(stuNo);
			
//			System.out.println(stuNo);
			List<Element> elements2 = element.elements();
			for (Element e2 : elements2) {
				//获取标签名   按照遍历的顺序动态变化
				String name = e2.getName();
				//获取对应的值
//				String value = e2.getText();
				String value = e2.getStringValue();
//				System.out.println("\t" + name + ":" + value);
				BeanUtils.setProperty(student, name, value);
			}
//			System.out.println(student);
			list.add(student);
		}
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
