package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.dao.AccountDAO;
import demo.dao.MemberShipDAO;

public class MainDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		AccountDAO accountdao = context.getBean("accountDAO", AccountDAO.class);

		MemberShipDAO membershipdao = context.getBean("memberShipDAO", MemberShipDAO.class);

		accountdao.addAccount();

		membershipdao.addSillyMember();

		context.close();

	}

}
