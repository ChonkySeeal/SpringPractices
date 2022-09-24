package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.service.TrafficFortuneService;

public class AroundDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		// get the bean from spring container
		TrafficFortuneService trafficfortuneservice = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);
		System.out.println("\n Main Program: AroundDemo");

		System.out.println("\n calling fortuneService");

		String data = trafficfortuneservice.getFortune();

		System.out.println("\n My fortune is: " + data);

		System.out.println("Finished");

		context.close();

	}

}
