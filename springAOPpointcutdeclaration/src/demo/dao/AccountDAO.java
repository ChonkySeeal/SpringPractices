package demo.dao;

import org.springframework.stereotype.Component;

import demo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing My DB WORK: ADDING MEMBERSHIP ACCOUNT");

	}

	public boolean doWork() {

		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
