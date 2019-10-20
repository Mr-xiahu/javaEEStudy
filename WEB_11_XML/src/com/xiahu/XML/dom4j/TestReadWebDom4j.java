package com.xiahu.XML.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestReadWebDom4j {

	@Test
	public void readWeb() {

		try {
			// 1.获取解析器
			SAXReader sr = new SAXReader();
			// 2.获取xml文件
			Document doc = sr.read("src/com/xiahu/XML/Schema/web.xml");
			// 3.获取根元素
			Element rootElement = doc.getRootElement();
			// System.out.println(rootElement.getName());获取根元素的名称
			// System.out.println(rootElement.attributeValue("version"));//获取根元素中的属性值(version属性值)
			// 4.获取跟元素下的所有元素
			List<Element> elements = rootElement.elements();
			// 5.遍历所有子元素
			for (Element element : elements) {
				if ("servlet".equals(element.getName())) {
					Element servletName = element.element("servlet-name");
					Element servletClass = element.element("servlet-class");
					System.out.println(servletName.getText()+"---------"+servletClass.getText());
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
