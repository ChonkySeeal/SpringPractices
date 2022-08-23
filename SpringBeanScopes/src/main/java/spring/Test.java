package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Country countryObj1 = (Country) appContext.getBean("country");
		countryObj1.setCountryName("India");
		System.out.println("Country Name: " + countryObj1.getCountryName());
		Country countryObj2 = (Country) appContext.getBean("country");
		System.out.println("Country Name: " + countryObj2.getCountryName());
	}

}
