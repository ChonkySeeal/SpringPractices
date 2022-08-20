package springJavaBasedConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		Country countryObj = (Country) appContext.getBean("countryObj");
		String countryName = countryObj.getCountryName();

		System.out.println("Country name: " + countryName);

	}

}
