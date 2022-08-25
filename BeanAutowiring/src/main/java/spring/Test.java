package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Country countryObj = (Country) appContext.getBean("country");
		String countryName = countryObj.getCountryName();
		String capitalName = countryObj.getCapital().getCapitalName();
		System.out.println(capitalName + " is capital of " + countryName);

	}

}
