package demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.dao.AccountDAO;

public class AfterReturningDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = theAccountDAO.findAccounts();

		System.out.println("Main Program: AfterReturningDemo");

		System.out.println(accounts);
		// close the context
		context.close();

	}

}
