package org.mursil.spring.practice;

//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Triangle t= new Triangle();
		
		//Deprecated Method
		//BeanFactory factory= new XmlBeanFactory(new ClassPathResource("template.xml"));
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("template.xml");
		context.registerShutdownHook();
		Triangle t = (Triangle)context.getBean("triangle1");
		t.draw();
		
	}

}
