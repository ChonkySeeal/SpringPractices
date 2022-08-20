package javatpoint;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Country countryBean = (Country) ac.getBean("country");
		String name = countryBean.getName();
		System.out.println("Country name: "+name);
		long population = countryBean.getPopulation();
		System.out.println("Country population: "+population);
		ac.close();
	}
}
