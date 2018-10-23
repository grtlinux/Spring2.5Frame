package kame.spring.appA;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class SimpleDateFormatBeanDefinitionParser extends
		AbstractSingleBeanDefinitionParser {

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		String pattern = element.getAttribute("pattern");
		bean.addConstructorArg(pattern);

		String lenient = element.getAttribute("lenient");
		if (StringUtils.hasText(lenient)) {
			bean.addPropertyValue("lenient", Boolean.valueOf(lenient));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Class getBeanClass(Element element) {
		return SimpleDateFormat.class;
	}

}
