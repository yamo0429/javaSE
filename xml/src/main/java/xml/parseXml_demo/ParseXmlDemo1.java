package xml.parseXml_demo;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXmlDemo1 {
	public static void main(String[] args) throws Exception {
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("05-servlet.xml");
		Element rootElement = document.getRootElement();
		//如果子标签有多种，获取子标签时需要指定标签名
		List<Element> servlets = rootElement.elements("servlet");
		for (Element element : servlets) {
			//获取字标签的值
			String name = element.elementText("servlet-name");
			String cls = element.elementText("servlet-class");
			System.out.println("name:" + name + ";cls:" + cls);
		}
		List<Element> mappings = rootElement.elements("servlet-mapping");
		for (Element element : mappings) {
			//获取字标签的值
			String name = element.elementText("servlet-name");
			String url = element.elementText("url-pattern");
			System.out.println("name:" + name + ";url:" + url);
		}
	}
}
