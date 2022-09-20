package demo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public boolean addAccount() {
		System.out.println(getClass() + ": Doing My DB WORK: ADDING MEMBERSHIP ACCOUNT");

		return true;
	}
}
