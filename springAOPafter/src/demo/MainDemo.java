package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.dao.AccountDAO;
import demo.dao.MemberShipDAO;

public class MainDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MemberShipDAO theMembershipDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

		// call the business method
		Account myAccount = new Account("SJ", "Challenger");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

		// close the context
		context.close();

	}

}
