package demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {

	public void addSillyMember() {
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}

	public void goToSleep() {

		System.out.println(getClass() + ": I'm going to sleep now...");

	}
}
