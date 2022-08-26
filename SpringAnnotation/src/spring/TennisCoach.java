package spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortune;

	public TennisCoach() {
		System.out.println("TennisCoach default constructor");
	}

	@PostConstruct
	public void doMyStuff() {
		System.out.println("I'm doing my stuffss");
	}

	@PreDestroy
	public void doCleanStuff() {
		System.out.println("I'm cleaning stuffs");
	}

//	@Autowired
//	public TennisCoach(FortuneService fortuneservice) {
//		fortune = fortuneservice;
//	}

//	@Autowired
//	public void setFortuneService(FortuneService f) {
//		System.out.println("setFortuneservice inside");
//		fortune = f;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {

		return fortune.getFortune();
	}

}
