package com.xiahu.XML.Servlet_V1;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

public class TestMyServlet {

	@Test
	public void TestMyServlet() {
		try {
			// 1.创建解析器对象
			SAXReader sr = new SAXReader();
			// 2.通过解析器将xml文件解析为document
			Document doc = sr.read("src/com/xiahu/XML/Servlet_V1/web.xml");
			// 3.获取根元素节点
			Element rootElement = doc.getRootElement();
			// 4.根据元素名称获取根节点
			Element elements = rootElement.element("servlet");
			// 5.获取xml文件中的Servlet-class的文本
			String servletClass = elements.element("servlet-class").getText();
			// System.out.println(servletClass);
			Class clazz = Class.forName(servletClass);
			MyServlet ms = (MyServlet) clazz.newInstance();
			ms.init("servlet");
			ms.service();
			ms.destory();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 8.创建一个HashMap对象
	private HashMap<String, String> map = new HashMap<String, String>();

	@Before
	public void TestMyServlet2() {
		try {
			// 1.创建解析器对象
			SAXReader sa = new SAXReader();
			// 2. 将XML文件解析成为document
			Document doc = sa.read("src/com/xiahu/XML/Servlet_V1/web.xml");
			// 3.获取根元素
			Element rootElement = doc.getRootElement();
			// 4.获取根元素下面所有的元素
			List<Element> elements = rootElement.elements();
			// 5.遍历这些所有元素
			for (Element element : elements) {
				// 6.判断元素的名称为servlet的元素节点
				if ("servlet".equals(element.getName())) {
					// 7.分别获取到xml文件中的所有servlet-name,servlet-class的文本
					String servletName = element.element("servlet-name").getText();
					String servletClass = element.element("servlet-class").getText();
					// System.out.println(servletName);
					// System.out.println(servletClass);

					// 9.将servlet-name,servlet-class分别添加到HashMap
					map.put(servletName, servletClass);

				}

				// 10.判断元素的名称为servlet-mapping的元素节点
				if ("servlet-mapping".equals(element.getName())) {
					// 11.分别获取xml文件中servlet-mapping节点下的servlet-name,url-pattern的文本
					String servletName = element.element("servlet-name").getText();
					String url = element.element("url-pattern").getText();
					// System.out.println(servletName);
					// System.out.println(url);

					// 12.将servletName作为key来获取servletClass的值
					String servletClass = map.get(servletName);
					// 13.将url作为key,servletClass作为value添加到map
					map.put(url, servletClass);

					/**
					 * 遍历map集合
					 * 
					 * Set<Map.Entry<String, String>> set = map.entrySet();
					 * for(Map.Entry<String, String> me:set){ String key =
					 * me.getKey(); String value = me.getValue();
					 * System.out.println(key+"-----"+value); }
					 */

					// 14.移除servletName
					map.remove(servletName);

				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void Test() {
		try {
			String url = "/myServlet2";
			String className = map.get(url);
			Class clazz = Class.forName(className);
			Object ms = clazz.newInstance();
			// ms.init();
			// ms.service();
			// ms.destory();
			// 获取其中的一个方法
			Method init = clazz.getMethod("init", String.class);
			init.setAccessible(true);
			init.invoke(ms, "我是被修改后的INIT");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
