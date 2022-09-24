package demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.dao.AccountDAO;

public class AfterThrowingDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;

		try {
			boolean tripWire = true;
			accounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\n Main Program... caugth exception: " + e);
		}

		System.out.println("\n Main Program: AfterThrowingDemo");

		System.out.println(accounts);

		context.close();

	}

}
