package xml.parseXml_demo;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 	3. dom4j
		1. 导入jar包
		2. 常用API：
			1. SaxReader 类
	 			1. 作用 : 将硬盘上的 xml 文件读取到内存中, 并在内存中生成一个 `Document` 文档树对象.
		  		2. 方法 : read(String fileName);
	 		2. Document 类
				1. 作用 : 使用文档对象可以获取 `根元素` 对象.
				2. 方法 : getRootElement();
	 		 3. Element 类
				1. 作用 : 可以获取子元素对象. 还有属性值, 和子元素文本数据内容.
				2. 方法 : elements();  返回值为 Element 集合.	
				3. elementText(子标签名称)	获取子标签中的文本数据信息
				4. attributeValue(属性名称)	获取对应属性的属性值.
 *
 */
public class ParseXmlDemo2 {
	
	public static void main(String[] args) throws Exception {
		SAXReader saxReader = new SAXReader();
		//1.saxReader解析类，加载需要解析的xml
		Document document = saxReader.read("07-bean.xml");
		//2. 通过文档获取根标签
		Element rootElement = document.getRootElement();
		//3.获取此标签的所有子标签
		List<Element> elements = rootElement.elements();
		
		for (Element element : elements) {
			//4.获取标签上的属性
			String cls = element.attributeValue("className");
			String id = element.attributeValue("id");
			System.out.println("cls:" + cls + ";id:" + id);
			
			//5. 继续遍历子标签
			List<Element> list2 = element.elements();
			for (Element element2 : list2) {
				String name = element2.attributeValue("name");
				String value = element2.attributeValue("value");
				System.out.println("\tname:" + name + ";value:" + value);
			}
		}
		
	}
}











