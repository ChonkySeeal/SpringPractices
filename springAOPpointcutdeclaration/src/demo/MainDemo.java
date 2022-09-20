package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.dao.AccountDAO;
import demo.dao.MemberShipDAO;

public class MainDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		AccountDAO accountdao = context.getBean("accountDAO", AccountDAO.class);

		MemberShipDAO membershipdao = context.getBean("memberShipDAO", MemberShipDAO.class);

		Account myAccount = new Account();
		accountdao.addAccount(myAccount, true);
		accountdao.doWork();

		// call the membership business method
		membershipdao.addSillyMember();
		membershipdao.goToSleep();

		// close the context
		context.close();

	}

}
